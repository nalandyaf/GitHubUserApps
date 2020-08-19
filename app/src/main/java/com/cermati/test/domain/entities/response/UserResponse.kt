package com.cermati.test.domain.entities.response

import com.cermati.test.domain.entities.UserEntity
import com.google.gson.annotations.SerializedName


class UserResponse(
    @SerializedName("total_count") val totalCount: Int? = null,
    @SerializedName("incomplete_results") val incompleteResults: Boolean? = null,
    @SerializedName("items") val items: List<UserEntity>? = null
) : BaseResponse<Any>()