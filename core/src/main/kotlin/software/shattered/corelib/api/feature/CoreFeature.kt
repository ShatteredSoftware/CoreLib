package software.shattered.corelib.api.feature

abstract class CoreFeature(
    val id: String,
    val name: String,
    val defaultEnabled: Boolean,
    val description: String,
    val permission: String
)