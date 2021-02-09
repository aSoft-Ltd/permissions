import tz.co.asoft.Permission
import kotlin.test.Test
import kotlin.test.assertEquals

class SystemPermissionTest {

    @Test
    fun can_create_a_set_of_no_repeated_permissions_successfully() {
        val perm1 = Permission(name = "authorization.roles.create", "Creates new user roles")
        val perm2 = Permission(name = "authorization.roles.create", "Creates new user roles")
        assertEquals(perm1, perm2)
        val permSet = setOf(perm1, perm2)
        assertEquals(1, permSet.size)
    }

    @Test
    fun system_permissions_can_group_themselves_correctly() {
        val permSet = setOf(
            Permission("authorization.roles.create", "Can create new permission"),
            Permission("authorization.roles.edit", "Can edit existing user roles"),
            Permission("authentication.users.create", "Can create new users"),
            Permission("authentication.users.edit", "Can edit new users")
        )

        val map = mapOf(
            "authorization" to setOf(
                Permission("roles.create", "Can create new permission"),
                Permission("roles.edit", "Can edit existing user roles"),
            ),
            "authentication" to setOf(
                Permission("users.create", "Can create new users"),
                Permission("users.edit", "Can edit new users")
            )
        )
    }
}