package software.shattered.corelib.api.attribute

interface Addable<T> {
    fun add(other: T): T
}