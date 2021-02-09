import tz.co.asoft.Resource
import tz.co.asoft.ResourceAccessor
import tz.co.asoft.ResourcePermissions

data class TestResource(
    override var uid: String? = null,
    override val owner: ResourceAccessor,
    override val claims: ResourcePermissions,
    override var deleted: Boolean = false,
) : Resource