package tz.co.asoft

import kotlinx.serialization.Serializable

@Serializable
data class ResourceAccessor(
    val uid: String,
    val name: String,
    val photoUrl: String? = null,
)