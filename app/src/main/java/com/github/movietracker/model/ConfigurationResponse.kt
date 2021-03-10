package com.github.movietracker.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigurationResponse(
    @SerialName("images")
    val images: Images? = null,

    @SerialName("change_keys")
    val changeKeys: List<String?>? = null
)