package software.shattered.corelib.api.primitive

import software.shattered.corelib.api.functional.Conversion

interface NumberCoercible: IntCoercible, LongCoercible, FloatCoercible, DoubleCoercible {
    companion object {
        val conversion: Conversion<NumberCoercible, Number> =
            object : Conversion<NumberCoercible, Number> {
                override fun convert(value: NumberCoercible): Number {
                    return value.toNumber()
                }
            }
    }
    fun toNumber(): Number
    override fun toInt() = toNumber().toInt()
    override fun toLong() = toNumber().toLong()
    override fun toDouble() = toNumber().toDouble()
    override fun toFloat() = toNumber().toFloat()
}