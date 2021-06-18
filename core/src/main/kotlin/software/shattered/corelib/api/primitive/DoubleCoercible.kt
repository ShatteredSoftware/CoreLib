package software.shattered.corelib.api.primitive

import software.shattered.corelib.api.functional.Conversion

interface DoubleCoercible {
    companion object {
        val conversion: Conversion<DoubleCoercible, Double> =
            object : Conversion<DoubleCoercible, Double> {
                override fun convert(value: DoubleCoercible): Double {
                    return value.toDouble()
                }
            }
    }

    fun toDouble(): Double
}