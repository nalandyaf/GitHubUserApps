package com.cermati.test.domain.usecases.base

import com.cermati.test.data.remote.BaseRepository
import com.cermati.test.data.remote.UserRepository
import com.cermati.test.domain.mappers.BaseMapper

abstract class BaseUsecase<M : BaseMapper<*, *>?, R :
BaseRepository<*>?>(protected var mapper: M, protected var repository: UserRepository?) {

    fun isErrorCode(statusCode: Int): Boolean {
        if (statusCode > 200) {
            return true
        }
        return false
    }
}