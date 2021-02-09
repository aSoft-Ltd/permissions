import tz.co.asoft.*
import kotlin.test.Test

/**
 * An X Module = resource location
 * A User/Client App can
 * - create an X resource if has the permissions to
 * - edit an X resource
 *
 * e.g. Users Module {
 *      Can't be owned,
 *      User Creates themselves (No Permissions Required)
 *      Admin Can Edit/Update/Block A User ()
 * }
 *
 * e.g Products Module {
 *      Can't be owned
 *      Admin Creates a Product
 *      Other Admin Can Edit it
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
        val claim = ModulePermission(name = "test-module", claims = listOf(perm.title))
        expect(claim.claims).toContain(perm.title)
    }

    @Test
    fun should_not_have_a_creating_permission_for_an_entity() {
        val perm = Permission(
            name = "module.x.create",
            details = "Could create a module permission"
        )
        val claim = ModulePermission(name = "test", claims = listOf())
        expect(claim.claims).toNotContain(perm.title)
    }
}