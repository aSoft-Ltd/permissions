package tz.co.asoft

data class ModulePermission(
    val claims: List<String>
) {
    companion object {
        val DEV: IPermission = Permission(
            name = "system.developer",
            details = "Grant's permissions to every action on the system (Should only be used in development)"
        )
    }
}