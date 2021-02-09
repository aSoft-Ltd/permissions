import tz.co.asoft.IPermission
import tz.co.asoft.Resource
import tz.co.asoft.ResourceAccessor
import tz.co.asoft.ResourcePermissions

enum class TestResourcePermissions(
    override val title: String,
    override val details: String,
    override val needs: List<String> = listOf()
) : IPermission {
    edit(
        title = "edit",
        details = "Testing editing"
    )
}