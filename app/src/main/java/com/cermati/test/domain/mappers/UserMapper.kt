package com.cermati.test.domain.mappers

import com.cermati.test.domain.entities.UserEntity
import com.cermati.test.domain.exceptions.MapperException
import com.cermati.test.domain.models.User

class UserMapper : BaseMapper<UserEntity?, User?>() {
    override fun createObject(): User? {
        return User()
    }

    override fun createEntity(): UserEntity? {
        return UserEntity()
    }

    @Throws(MapperException::class)
    override fun defineObject(`object`: User?): User? {
        `object`?.avatar = baseEntity?.avatarUrl
        `object`?.name = baseEntity?.login
        `object`?.score = baseEntity?.score
        `object`?.url = baseEntity?.url
        return `object`
    }

    @Throws(MapperException::class)
    override fun defineEntity(entity: UserEntity?): UserEntity? {
        return entity
    }
}