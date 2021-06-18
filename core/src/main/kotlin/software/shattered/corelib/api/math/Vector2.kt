package software.shattered.corelib.api.math

import software.shattered.corelib.api.primitive.NumberCoercible
import kotlin.math.cos
import kotlin.math.sin


abstract class Vector2<T : Number> {
    abstract val x: T
    abstract val y: T

    protected abstract fun fromNumber(n: Number): T
    protected abstract fun add(t1: T, t2: T): T
    protected abstract fun times(t1: T, t2: T): T
    protected abstract fun of(t1: T, t2: T): Vector2<T>

    protected open fun inverse(t1: T): T {
        throw NotImplementedError("Inverse is not defined for this implementation of Vector2")
    }

    protected open fun squareRoot(t1: T): T {
        throw NotImplementedError("Square root is not defined for this implementation of Vector2")
    }

    fun translate(dx: Number, dy: Number): Vector2<T> {
        return of(add(x, fromNumber(dx)), add(y, fromNumber(dy)))
    }

    fun scale(scale: Number): Vector2<T> {
        return of(times(x, fromNumber(scale)), times(y, fromNumber(scale)))
    }

    fun scale(scale: NumberCoercible): Vector2<T> {
        return scale(scale.toNumber())
    }

    fun scale(sx: Number, sy: Number): Vector2<T> {
        return of(times(x, fromNumber(sx)), times(y, fromNumber(sy)))
    }

    fun scale(sx: NumberCoercible, sy: NumberCoercible): Vector2<T> {
        return scale(sx.toNumber(), sy.toNumber())
    }

    fun squareMagnitude(): T {
        return add(times(x, x), times(y, y))
    }

    operator fun plus(other: Vector2<out Number>): Vector2<T> {
        return translate(other.x, other.y)
    }

    operator fun times(other: Number): Vector2<T> {
        return scale(other)
    }

    operator fun times(other: NumberCoercible): Vector2<T> {
        return scale(other.toNumber())
    }

    operator fun times(other: Vector2<out Number>): Vector2<T> {
        return scale(other.x, other.y)
    }

    infix fun dot(other: Vector2<out Number>): T {
        return add(times(x, fromNumber(other.x)), times(y, fromNumber(other.y)))
    }

    fun magnitude(): T {
        return squareRoot(squareMagnitude())
    }

    fun unit(): Vector2<T> {
        val inverseMagnitude = inverse(magnitude())
        return of(times(x, inverseMagnitude), times(y, inverseMagnitude))
    }

    fun rotate(degrees: Number): Vector2<T> {
        return of(
            // cos(deg) * x - sin(deg) * y
            add(
                times(fromNumber(cos(degrees.toDouble())), x),
                times(times(fromNumber(sin(degrees.toDouble())), y), fromNumber(-1))
            ),
            // sin(deg) * x + cos(deg) * y
            add(
                times(fromNumber(sin(degrees.toDouble())), x),
                times(fromNumber(cos(degrees.toDouble())), y)
            )
        )
    }
}