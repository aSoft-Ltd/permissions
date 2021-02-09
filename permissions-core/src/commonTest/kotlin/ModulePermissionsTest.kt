import tz.co.asoft.*
import kotlin.test.Test

/**
 * An X Module = resource location
 * A User can
 * - create an X resource if has the permissions to
 * - edit an X resource
 * module.x - owner [create,read,update,delete,execute,kill]
 *          - group [create,read,update,delete,execute,kill]
 *          - other [create,read,update,delete,execute,kill]
 *
 * e.g. Users Module {
 *      Can't be owned,
 *      User Creates themselves (No Permissions Required)
 *      Admin Can Edit/Update/Block A User ()
 * }
 *
 * e.g. Admin User {
 *      groups(x,y,z)
 * }
 */
class ModulePermissionsTest {
    @Test
    fun should_have_a_creating_permissions_for_a_an_entity() {
        val perm = Permission(
            name = "module.x.create",
            details = "Could create a module permission"
        )
        val claim = ModulePermission(permissions = listOf(perm.title))
        expect(claim.permissions).toContain(perm.title)
    }

    @Test
    fun should_not_have_a_creating_permission_for_an_entity() {
        val perm = Permission(
            name = "module.x.create",
            details = "Could create a module permission"
        )
        val claim = ModulePermission(permissions = listOf())
        expect(claim.permissions).toNotContain(perm.title)
    }
}