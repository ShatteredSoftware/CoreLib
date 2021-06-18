package software.shattered.corelib.api.region

import software.shattered.corelib.api.math.Vector3Int
import software.shattered.corelib.api.world.CoreWorld

abstract class CoreRegion(
    val featureOverrides: Map<String, Boolean>,
    val world: CoreWorld,
    val upperSouthEast: Vector3Int,
    val lowerNorthWest: Vector3Int,
)