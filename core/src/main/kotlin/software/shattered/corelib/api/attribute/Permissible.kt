package software.shattered.corelib.api.attribute

interface Permissible {
    fun hasPermission(permission: String): Boolean
}