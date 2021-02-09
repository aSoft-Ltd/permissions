package tz.co.asoft

import kotlinx.serialization.Serializable

@Serializable
data class ModulePermission(
    val name: String,
    val claims: List<String>
) {
    companion object {
        val DEV: IPermission = Permission(
            name = "system.developer",
            details = "Grant's permissions to every action on the system (Should only be used in development)"
        )
    }
}