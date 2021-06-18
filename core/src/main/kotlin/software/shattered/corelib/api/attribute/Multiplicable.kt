package software.shattered.corelib.api.attribute

interface Multiplicable<T> {
    fun multiply(other: T): T
}