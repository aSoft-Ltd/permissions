import TestResourcePermissions.edit
import tz.co.asoft.*
import kotlin.test.Test

class ResourcePermissionOwnerTest {
    private val owner = ResourceAccessor(uid = "one", name = "andy")

    @Test
    fun owner_should_have_permission_to_edit_a_resource() {
        val res = TestResource(
            owner = owner,
            claims = ResourcePermissions(
                owner = mutableListOf(edit.title)
            )
        )
        expect(owner.can(edit, res)).toBe(true)
    }

    @Test
    fun owner_should_not_have_permission_to_edit_a_resource() {
        val res = TestResource(
            owner = owner,
            claims = ResourcePermissions()
        )
        expect(owner.can(edit, res)).toBe(false)
    }

    @Test
    fun owner_should_have_permission_to_do_anything() {
        val res = TestResource(
            owner = owner,
            claims = ResourcePermissions(
                owner = mutableListOf("*")
            )
        )
        expect(owner.can(edit, res)).toBe(true)
    }
}