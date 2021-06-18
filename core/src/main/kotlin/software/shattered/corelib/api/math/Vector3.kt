package software.shattered.corelib.api.math

import software.shattered.corelib.api.primitive.NumberCoercible

abstract class Vector3<T : Number> {
    abstract val x: T
    abstract val y: T
    abstract val z: T

    protected abstract fun fromNumber(n: Number): T
    protected abstract fun add(t1: T, t2: T): T
    protected abstract fun times(t1: T, t2: T): T
    protected abstract fun of(t1: T, t2: T, t3: T): Vector3<T>

    protected open fun inverse(t1: T): T {
        throw NotImplementedError("Inverse is not defined for this implementation of Vector2")
    }

    protected open fun squareRoot(t1: T): T {
        throw NotImplementedError("Square root is not defined for this implementation of Vector2")
    }

    fun translate(dx: Number, dy: Number, dz: Number): Vector3<T> {
        return of(add(x, fromNumber(dx)), add(y, fromNumber(dy)), add(z, fromNumber(dz)))
    }

    fun scale(scale: Number): Vector3<T> {
        return of(
            times(x, fromNumber(scale)),
            times(y, fromNumber(scale)),
            times(z, fromNumber(scale))
        )
    }

    fun scale(scale: NumberCoercible): Vector3<T> {
        return scale(scale.toNumber())
    }

    fun scale(sx: Number, sy: Number, sz: Number): Vector3<T> {
        return of(times(x, fromNumber(sx)), times(y, fromNumber(sy)), times(z, fromNumber(sz)))
    }

    fun scale(sx: NumberCoercible, sy: NumberCoercible, sz: NumberCoercible): Vector3<T> {
        return scale(sx.toNumber(), sy.toNumber(), sz.toNumber())
    }

    fun squareMagnitude(): T {
        return add(add(times(x, x), times(y, y)), times(z, z))
    }

    operator fun plus(other: Vector3<out Number>): Vector3<T> {
        return translate(other.x, other.y, other.z)
    }

    operator fun times(other: Number): Vector3<T> {
        return scale(other)
    }

    operator fun times(other: NumberCoercible): Vector3<T> {
        return scale(other.toNumber())
    }

    operator fun times(other: Vector3<out Number>): Vector3<T> {
        return scale(other.x, other.y, other.z)
    }

    infix fun dot(other: Vector3<out Number>): T {
        return add(
            add(times(x, fromNumber(other.x)), times(y, fromNumber(other.y))),
            times(z, fromNumber(other.z))
        )
    }

    fun magnitude(): T {
        return squareRoot(squareMagnitude())
    }

    fun unit(): Vector3<T> {
        val inverseMagnitude = inverse(magnitude())
        return of(times(x, inverseMagnitude), times(y, inverseMagnitude), times(z, inverseMagnitude))
    }
}