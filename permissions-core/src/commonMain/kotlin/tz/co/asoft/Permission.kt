package tz.co.asoft

fun Permission(
    name: String,
    details: String,
    needs: List<String> = listOf()
): IPermission = object : IPermission {
    override val title = name
    override val details = details
    override val needs: List<String> = needs

    override fun equals(other: Any?) = when (other) {
        is IPermission -> title == other.title
        else -> false
    }

    override fun hashCode(): Int = title.hashCode()

    override fun toString(): String = "Permission(title=$name)"
}

fun Collection<IPermission>.hasPermit(name: String): Boolean {
    if (any { it.title == "system.developer" }) return true
    if (any { it.title == name }) return true
    return false
}

fun Collection<IPermission>.hasPermit(permit: IPermission) = hasPermit(permit.title)