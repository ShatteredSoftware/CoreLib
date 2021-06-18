package software.shattered.corelib.api.math

import kotlin.math.sqrt

data class Vector2Float(override val x: Float, override val y: Float): Vector2<Float>() {
    override fun fromNumber(n: Number): Float {
        return n.toFloat()
    }

    override fun add(t1: Float, t2: Float): Float {
        return t1 + t2
    }

    override fun times(t1: Float, t2: Float): Float {
        return t1 * t2
    }

    override fun of(t1: Float, t2: Float): Vector2<Float> {
        return Vector2Float(t1, t2)
    }

    override fun inverse(t1: Float): Float {
        return 1f / t1
    }

    override fun squareRoot(t1: Float): Float {
        return sqrt(t1)
    }

    fun project(z: Float = 0f): Vector3Float {
        return Vector3Float(x, y, z)
    }
}