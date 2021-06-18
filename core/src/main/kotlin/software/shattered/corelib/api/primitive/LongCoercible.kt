package software.shattered.corelib.api.primitive

import software.shattered.corelib.api.functional.Conversion

interface LongCoercible {
    companion object {
        val conversion: Conversion<LongCoercible, Long> =
            object : Conversion<LongCoercible, Long> {
                override fun convert(value: LongCoercible): Long {
                    return value.toLong()
                }
            }
    }

    fun toLong(): Long
}