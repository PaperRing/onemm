package com.onemm.business.mapper.real

import com.onemm.business.model.BlockUser
import com.onemm.common.annotation.Real

@Real
interface BlockUserMapper {
    fun addBlockUser(blockUser: BlockUser)
}