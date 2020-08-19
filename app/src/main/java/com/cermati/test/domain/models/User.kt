package com.cermati.test.domain.models

import com.cermati.test.domain.models.BaseObject

data class User(
        var avatar: String? = null,
        var name: String? = null,
        var score: Double? = null,
        var url: String? = null
) : BaseObject()