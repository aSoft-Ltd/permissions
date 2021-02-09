package tz.co.asoft

import kotlinx.serialization.Serializable

@Serializable
data class ResourceGroup(
    val name: String,
    val members: MutableList<ResourceAccessor> = mutableListOf(),
    val claims: MutableList<String> = mutableListOf()
)
