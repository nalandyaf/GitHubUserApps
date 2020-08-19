package com.cermati.test.domain.entities.response

import com.cermati.test.domain.entities.BaseObjectEntity
import com.cermati.test.domain.entities.ErrorEntity
import com.google.gson.annotations.SerializedName

open class BaseResponse<E> : BaseObjectEntity() {
    var data: E? = null

    var errors: List<ErrorEntity>? = null

    @SerializedName("documentation_url")
    var documentationUrl: String? = null

}


