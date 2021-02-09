package tz.co.asoft

/**
 * Checks if a specific accessor has a certain permission on a resource
 *
 * Note: Make sure that the resource is retrieved from the database to avoid validating falsified resource
 */
fun ResourceAccessor.can(action: IPermission, res: Resource): Boolean {
    // owner
    if (res.owner.uid == uid) {
        val claims = res.claims.owner
        return claims.contains("*") || claims.contains(action.title)
    }

    //group
    val group = res.claims.groups.firstOrNull { it.members.map { m -> m.uid }.contains(uid) }
    if (group != null) {
        val claims = group.claims
        return claims.contains("*") || claims.contains(action.title)
    }

    //other
    val claims = res.claims.other
    return claims.contains("*") || claims.contains(action.title)
}