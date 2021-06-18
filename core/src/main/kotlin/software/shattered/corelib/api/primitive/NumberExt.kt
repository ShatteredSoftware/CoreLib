package software.shattered.corelib.api.primitive

fun Number.asFloatCoercible(): FloatCoercible {
    return object : FloatCoercible {
        override fun toFloat(): Float {
            return this@asFloatCoercible.toFloat()
        }
    }
}

fun Number.asDoubleCoercible(): DoubleCoercible {
    return object : DoubleCoercible  {
        override fun toDouble(): Double {
            return this@asDoubleCoercible.toDouble()
        }
    }
}

fun Number.asIntCoercible(): IntCoercible {
    return object : IntCoercible {
        override fun toInt(): Int {
            return this@asIntCoercible.toInt()
        }
    }
}

fun Number.asLongCoercible(): LongCoercible {
    return object : LongCoercible {
        override fun toLong(): Long {
            return this@asLongCoercible.toLong()
        }
    }
}

fun Number.asNumberCoercible(): NumberCoercible {
    return object : NumberCoercible {
        override fun toNumber(): Number {
            return this@asNumberCoercible
        }
    }
}