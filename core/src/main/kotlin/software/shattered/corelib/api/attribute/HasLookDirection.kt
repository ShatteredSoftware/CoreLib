package software.shattered.corelib.api.attribute

import software.shattered.corelib.api.math.Vector3Float

interface HasLookDirection {
    /**
     * The direction the attribute holder is looking.
     */
    fun getLookDirection(): Vector3Float
}