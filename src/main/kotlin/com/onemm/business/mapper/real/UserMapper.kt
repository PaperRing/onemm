package com.onemm.business.mapper.real

import com.onemm.business.model.Follow
import com.onemm.business.model.User
import com.onemm.common.annotation.Real

@Real
interface UserMapper {
    fun saveUser(user: User)
    fun findUser(uid: String): User?
    fun updateUser(uid: String, user: User)
    fun deleteUser(id: Long)
    fun addFollow(follow: Follow)
    fun getFollower(loginId: Long): List<Map<String, Any>>
    fun getFollowing(loginId: Long): List<Map<String, Any>>
    fun deleteFollow(loginId: Long, followingId: Long)
    fun getFollowOne(loginId: Long, followingId: Long): Follow?
    fun getOtherUserInfo(id: Long): User?
}
