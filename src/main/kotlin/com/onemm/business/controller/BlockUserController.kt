package com.onemm.business.controller

import com.onemm.business.mapper.real.BlockUserMapper
import com.onemm.business.mapper.real.UserMapper
import com.onemm.business.model.BlockUser
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user/block")
class BlockUserController(
    private val blockUserMapper: BlockUserMapper,
    private val userMapper: UserMapper
) {

    @PostMapping("/add")
    fun addBlockUser(@RequestBody blockUser: BlockUser) {
        blockUserMapper.addBlockUser(blockUser)
        userMapper.deleteFollow(blockUser.userId, blockUser.blockUserId)
    }
}