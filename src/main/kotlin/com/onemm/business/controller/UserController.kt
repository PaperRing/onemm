package com.onemm.business.controller

import com.onemm.business.mapper.real.UserMapper
import com.onemm.business.model.Follow
import com.onemm.business.model.User
import com.onemm.common.exception.CommonError
import com.onemm.common.exception.ServiceException
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
    val userMapper: UserMapper,
) {
    @PostMapping("/save")
    fun saveUser(@RequestBody user: User) {
        userMapper.saveUser(user)
    }

    @GetMapping("/get")
    fun findUser(@RequestParam("uid") uid: String): User {
        return userMapper.findUser(uid) ?: throw ServiceException(CommonError.AUTHENTICATION)
    }

    @GetMapping("/get/other/{id}")
    fun getOtherUserInfo(@PathVariable id: Long): User {
        return userMapper.getOtherUserInfo(id) ?: throw ServiceException(CommonError.AUTHENTICATION)
    }

    @PutMapping("/update")
    fun updateUser(@RequestParam("uid") uid: String, @RequestBody user: User) {
        userMapper.updateUser(uid, user)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteUser(@PathVariable id: Long) {
        userMapper.deleteUser(id)
    }

    @PostMapping("/follow")
    fun addFollow(@RequestBody follow: Follow) {
        userMapper.addFollow(follow)
    }

    //    나를 팔로우 하는 사람
    //    followingId가 현재 로그인한 사람의 아이디와 같은지
    @GetMapping("/follower/{loginId}")
    fun getFollower(@PathVariable loginId: Long): List<Map<String, Any>> {
        return userMapper.getFollower(loginId)
    }

    //    내가 팔로우 하는 사람
    //    loginId가 현재 로그인한 사람의 아이디와 같은지
    @GetMapping("/following/{loginId}")
    fun getFollowing(@PathVariable loginId: Long): List<Map<String, Any>> {
        return userMapper.getFollowing(loginId)
    }

    @DeleteMapping("/follow/delete/{loginId}/{followingId}")
    fun deleteFollow(
        @PathVariable loginId: Long,
        @PathVariable followingId: Long,
    ) {
        userMapper.deleteFollow(loginId, followingId)
    }


    @GetMapping("/get/follow/{loginId}/{followingId}")
    fun getFollowOne(
        @PathVariable(value = "loginId") loginId: Long,
        @PathVariable(value = "followingId") followingId: Long,
    ): Follow? {
        return userMapper.getFollowOne(loginId, followingId)
    }

    @GetMapping("/error1")
    fun error(): String {
        throw Exception("test")
    }
}
