package software.shattered.corelib.api.world

import software.shattered.corelib.api.attribute.Identified

abstract class CoreWorld(
    override val id: String,
    val featureOverrides: Map<String, Boolean>,
): Identified