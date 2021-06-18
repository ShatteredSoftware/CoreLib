package software.shattered.corelib.api.player

import software.shattered.corelib.api.attribute.Identified
import software.shattered.corelib.api.attribute.Permissible
import software.shattered.corelib.api.attribute.HasPosition
import software.shattered.corelib.api.attribute.HasLookDirection
import software.shattered.corelib.api.feature.CoreFeature

abstract class CorePlayer(
    override val id: String,
    val name: String,
    val flags: Map<String, Boolean>,
    val featureOverrides: Map<String, Boolean>
) : Identified, Permissible, HasPosition, HasLookDirection {
    fun canUseFeature(feature: CoreFeature): Boolean {
        return feature.defaultEnabled || this.featureOverrides[feature.id] ?: hasPermission(feature.permission)
    }
}