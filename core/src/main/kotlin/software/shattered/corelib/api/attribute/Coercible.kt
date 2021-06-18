package software.shattered.corelib.api.attribute

interface Coercible<T> {
    fun coerce(): T
}