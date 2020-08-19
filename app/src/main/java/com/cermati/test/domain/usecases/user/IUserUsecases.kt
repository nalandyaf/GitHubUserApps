package com.cermati.test.domain.usecases.user

import com.cermati.test.data.remote.UserRepository
import com.cermati.test.domain.exceptions.MapperException
import com.cermati.test.domain.mappers.UserMapper
import com.cermati.test.domain.usecases.base.BaseUsecase
import io.reactivex.Single

abstract class IUserUsecases(mapper: UserMapper, userRepository: UserRepository?) :
        BaseUsecase<UserMapper, UserRepository>(mapper, userRepository) {

    @Throws(MapperException::class)
    abstract suspend fun getUser(q: String?, page: Int): Single<Any?>

}