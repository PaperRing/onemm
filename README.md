# onemm_backend

## 주요기능과 실행화면
----------
### 1) 리뷰

<img  src="https://github.com/PaperRing/onemm_backend/assets/63621849/42ecb2da-569c-4715-9e09-345cc7a33621"  width="300"  height="644"/>


가게에 대한 리뷰를 작성하고 별점을 줄 수 있는 기능입니다. 서버 사용 비용을 고려해 한장만 올릴 수 있도록 제한했습니다.

-   리뷰 `C` `R` `U` `D`
-   이미지 `C` `R`
    -   이미지는 보통 사이즈가 크기때문에 백엔드 서버로 동시요청을 하면 유저경험이 안좋을 수 있고, 속도적인 측면에서 장점이 있기때문에 클라이언트에서 S3로 업로드 가능한 PresignedUrl을 사용했습니다.
    -   리뷰 이미지는 유저가 리뷰를 삭제 하더라도 가게 대표 이미지로 사용하기때문에 삭제하지 않았습니다.

----------
### 2) 테마리스트
<img  src="https://github.com/PaperRing/onemm_backend/assets/63621849/5e8e0f42-c427-4a1a-b09c-1018fc2c226e"  width="300"  height="644"/>

자신이 좋아하는 가게들을 테마리스트로 만들어 공유하는 기능입니다. 테마리스트에는 가게(아이템)을 추가하거나 삭제할 수 있습니다. 유저들은 마음에 드는 테마리스트를 좋아요를 눌러서 찜한장소에 저장할 수 있습니다.

-   테마리스트 `C` `R` `U` `D`
-   아이템 `C` `D`

----------
### 3) 팔로우

<img  src="https://github.com/PaperRing/onemm_backend/assets/63621849/81053534-d7dd-4ecb-b040-2837fb98ac1b"  width="300"  height="644"/>

팔로우 기능입니다. 다른 유저들의 팔로우와 팔로워도 확인 할 수 있습니다.

-   팔로우 `C` `D`
    단순한 구조로 팔로우 정보를 저장하고 호출할 수 있도록 설계했습니다.
   
-   나의 id는 23 이라고 가정하겠습니다.
     `login_id`(로그인한 유저 id) , `follow_id` (팔로우하는 유저 id) 두 가지 데이터만 저장하고, 호출시에 내가 팔로우한 유저는 `login_id`가 나의 아이디인 23, 나를 팔로우한 유저는 `follow_id`가 23인 `login_id`를 찾도록 로직을 설계했습니다.

----------
### 4) 좋아요

<img  src="https://github.com/PaperRing/onemm_backend/assets/63621849/6de4515d-eb85-422a-89e3-c668b96d23ec"  width="300"  height="644"/>

마음에 드는 장소와 테마리스트를 좋아요해 찜한 장소에서 확인할 수 있습니다.

----------

### 5) 로그인

<img  src="https://github.com/PaperRing/onemm_backend/assets/63621849/9ceaad99-8c4e-4a25-8512-3765662276c9"  width="300"  height="644"/>

-   Firebase는 Flutter 친화적이며 기본적으로 social login 기능을 제공하고 있기때문에 사용하기 편리해서 Firebase Authentication을 사용했습니다.
-   하지만 유저 정보를 변경하거나 추가하는데에는 한계가 있고, 추가로 관리해야 하는 유저정보가 있었기때문에 기본 생성되는 uid와 로그인한 e-mail, 닉네임, 프로필 사진을 DB에 별도로 저장해서 관리했습니다.




----------
### 6) 검색

<img  src="https://github.com/PaperRing/onemm_backend/assets/63621849/8a695869-e42c-477b-8287-b31ad87d573b"  width="300"  height="644"/>

지역명, 가게명으로 검색할 수 있습니다.

-   검색 `C` `R` `D`
    
    지역, 가게 두가지 컬럼을 동시에 검색할 수 있도록 정규식으로 표현했습니다.
    
    ```sql
    select s.id,
           s.name,
           s.address,
           s.dong,
           group_concat(distinct c.name) as category,
           s.average_rating,
           (select count(id)
                    from onemm.review
                    where s.id = review.store_id
                    group by review.store_id) as count
    from onemm.store s
           left join onemm.store_category sc on s.id = sc.store_id
           left join onemm.category c on c.id = sc.category_id
    where concat(s.name, s.dong) regexp #{name}
    group by s.id
    
    ```
    
----------
### 7) 회원정보

<img  src="https://github.com/PaperRing/onemm_backend/assets/63621849/2f982d54-6d05-4277-bec2-73b77a59b6e7"  width="300"  height="644"/>

닉네임과 프로필 사진을 변경할 수 있습니다. 탈퇴하면 모든 리뷰와 테마리스트 회원정보가 삭제됩니다.

-   회원정보 관리 `R` `U` `D`

----------
### 8) 유저 차단/ 리뷰 신고

<img  src="https://github.com/PaperRing/onemm_backend/assets/63621849/875902c3-697f-4639-bea3-c713ea620c9d"  width="300"  height="644"/>

-   다른 유저를 차단하면 리뷰, 테마리스트 등을 볼 수 없습니다.
-   리뷰를 신고하면 검토후에 삭제합니다.
