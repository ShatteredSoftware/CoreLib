package software.shattered.corelib.api.math

import kotlin.math.round
import kotlin.math.sqrt

data class Vector3Int(override val x: Int, override val y: Int, override val z: Int) :
    Vector3<Int>() {
    override fun fromNumber(n: Number): Int {
        return n.toInt()
    }

    override fun add(t1: Int, t2: Int): Int {
        return t1 + t2
    }

    override fun times(t1: Int, t2: Int): Int {
        return t1 * t2
    }

    override fun of(t1: Int, t2: Int, t3: Int): Vector3<Int> {
        return Vector3Int(t1, t2, t3)
    }

    override fun squareRoot(t1: Int): Int {
        return round(sqrt(t1.toDouble())).toInt()
    }

    override fun inverse(t1: Int): Int {
        return round(1.0 / t1).toInt()
    }
}