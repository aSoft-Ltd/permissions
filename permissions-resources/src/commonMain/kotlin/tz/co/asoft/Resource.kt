package tz.co.asoft

interface Resource : Entity {
    val owner: ResourceAccessor
    val claims: ResourcePermissions
}