package software.shattered.corelib.api.functional

interface Conversion<T, R> {
    fun convert(value: T): R
}