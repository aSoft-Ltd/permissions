package tz.co.asoft

import kotlinx.serialization.Serializable

@Serializable
data class ResourcePermissions(
    val owner: MutableList<String> = mutableListOf(),
    val groups: MutableList<ResourceGroup> = mutableListOf(),
    val other: MutableList<String> = mutableListOf()
) {
    companion object {
        val modifyPermissions = Permission(
            name = "modify-permissions",
            details = "Grants ability to modify permissions"
        )
    }
}