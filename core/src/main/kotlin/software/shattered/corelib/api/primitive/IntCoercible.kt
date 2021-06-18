package software.shattered.corelib.api.primitive

import software.shattered.corelib.api.functional.Conversion

interface IntCoercible {
    companion object {
        val conversion: Conversion<IntCoercible, Int> =
            object : Conversion<IntCoercible, Int> {
                override fun convert(value: IntCoercible): Int {
                    return value.toInt()
                }
            }
    }

    fun toInt(): Int
}