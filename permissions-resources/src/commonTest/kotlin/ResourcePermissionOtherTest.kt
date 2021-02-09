import TestResourcePermissions.edit
import tz.co.asoft.*
import kotlin.test.Test

class ResourcePermissionOtherTest {
    private val accessors = List(10) {
        val tag = "accessor-${it + 1}"
        ResourceAccessor(uid = tag, name = tag)
    }

    private val accessor = ResourceAccessor(uid = "uid", name = "Pietro")

    @Test
    fun any_other_accessor_should_have_permission_to_edit_a_resource() {
        val owner = accessors[1]
        val members = (accessors - owner).toMutableList()
        val res = TestResource(
            owner = owner,
            claims = ResourcePermissions(
                owner = mutableListOf(),
                groups = mutableListOf(
                    ResourceGroup(
                        name = "test-group-1",
                        members = members,
                        claims = mutableListOf(edit.title)
                    )
                ),
                other = mutableListOf(edit.title)
            )
        )
        expect(accessor.can(edit, res)).toBe(true)
    }

    @Test
    fun any_other_member_should_not_have_permission_to_edit_a_resource() {
        val owner = accessors[1]
        val members = (accessors - owner).toMutableList()
        val res = TestResource(
            owner = owner,
            claims = ResourcePermissions(
                owner = mutableListOf(),
                groups = mutableListOf(
                    ResourceGroup(
                        name = "test-group-1",
                        members = members,
                        claims = mutableListOf()
                    )
                )
            )
        )
        expect(accessor.can(edit, res)).toBe(false)
    }

    @Test
    fun any_other_member_should_have_permission_to_do_anything_to_a_resource() {
        val owner = accessors[1]
        val members = (accessors - owner).toMutableList()
        val res = TestResource(
            owner = owner,
            claims = ResourcePermissions(
                owner = mutableListOf(),
                groups = mutableListOf(
                    ResourceGroup(
                        name = "test-group-1",
                        members = members,
                        claims = mutableListOf("*")
                    )
                ),
                other = mutableListOf("*")
            )
        )
        expect(accessor.can(edit, res)).toBe(true)
    }
}