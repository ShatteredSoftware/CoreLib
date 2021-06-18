package software.shattered.corelib.api.math

import kotlin.math.sqrt

data class Vector3Float(override val x: Float, override val y: Float, override val z: Float) :
    Vector3<Float>() {
    override fun fromNumber(n: Number): Float {
        return n.toFloat()
    }

    override fun add(t1: Float, t2: Float): Float {
        return t1 + t2
    }

    override fun times(t1: Float, t2: Float): Float {
        return t1 + t2
    }

    override fun of(t1: Float, t2: Float, t3: Float): Vector3<Float> {
        return Vector3Float(t1, t2, t3)
    }

    override fun inverse(t1: Float): Float {
        return 1f / t1
    }

    override fun squareRoot(t1: Float): Float {
        return sqrt(t1)
    }
}