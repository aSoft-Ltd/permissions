import TestResourcePermissions.edit
import tz.co.asoft.*
import kotlin.test.Test

class ResourcePermissionGroupTest {
    private val accessors = List(10) {
        val tag = "accessor-${it + 1}"
        ResourceAccessor(uid = tag, name = tag)
    }

    @Test
    fun a_member_should_have_permission_to_edit_a_resource() {
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
                )
            )
        )
        expect(members.random().can(edit, res)).toBe(true)
    }

    @Test
    fun a_member_should_not_have_permission_to_edit_a_resource() {
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
        expect(members.random().can(edit, res)).toBe(false)
    }

    @Test
    fun a_member_should_have_permission_to_do_anything_to_a_resource() {
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
                )
            )
        )
        expect(members.random().can(edit, res)).toBe(true)
    }

    @Test
    fun a_non_member_should_have_permission_to_edit_a_resource() {
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
                )
            )
        )
        val accessor = ResourceAccessor(uid = "uid", name = "Pietro")
        expect(accessor.can(edit, res)).toBe(false)
    }
}