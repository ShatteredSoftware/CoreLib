package software.shattered.corelib.api.primitive

import software.shattered.corelib.api.functional.Conversion

interface FloatCoercible {
    companion object {
        val conversion: Conversion<FloatCoercible, Float> =
            object : Conversion<FloatCoercible, Float> {
                override fun convert(value: FloatCoercible): Float {
                    return value.toFloat()
                }
            }
    }

    fun toFloat(): Float
}