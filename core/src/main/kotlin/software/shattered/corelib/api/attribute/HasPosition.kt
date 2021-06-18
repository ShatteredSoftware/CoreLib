package software.shattered.corelib.api.attribute

import software.shattered.corelib.api.math.Vector2Float
import software.shattered.corelib.api.math.Vector2Int
import software.shattered.corelib.api.math.Vector3Float
import software.shattered.corelib.api.math.Vector3Int
import software.shattered.corelib.api.region.CoreRegion
import software.shattered.corelib.api.world.CoreWorld

interface HasPosition {
    /**
     * Get the current world of the attribute holder.
     */
    fun getWorld(): CoreWorld

    /**
     * Get the 3D coordinates of the attribute holder.
     */
    fun getPosition(): Vector3Float

    /**
     * Get the 2D, top-down coordinates of the attribute holder.
     */
    fun getColumn(): Vector2Float {
        val pos = getPosition()
        return Vector2Float(pos.x, pos.y)
    }

    /**
     * Get the 3D integral coordinates of the attribute holder.
     */
    fun getBlockPosition(): Vector3Int {
        val pos = getPosition()
        return Vector3Int(pos.x.toInt(), pos.y.toInt(), pos.z.toInt())
    }

    /**
     * Get the 2D integral top-down coordinates of the attribute holder.
     */
    fun getBlockColumn(): Vector2Int {
        val pos = getPosition()
        return Vector2Int(pos.x.toInt(), pos.y.toInt())
    }

    /**
     * @return If the attribute holder is inside of the given region.
     */
    fun isInRegion(region: CoreRegion): Boolean {
        val world = getWorld()
        if (world.id != region.world.id) {
            return false
        }
        val pos = getPosition()
        val (px, py, pz) = pos
        val (ax, ay, az) = region.upperSouthEast
        val (bx, by, bz) = region.lowerNorthWest
        return px <= ax && py <= ay && pz <= az && px >= bx && py >= by && pz >= bz
    }
}