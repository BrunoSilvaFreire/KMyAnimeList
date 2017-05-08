package me.ddevil.mal.util

import me.ddevil.util.exception.ValueNotFoundException
import org.w3c.dom.Element
import org.w3c.dom.Node

fun Element.getElementByTagName(s: String): Node? = getElementsByTagName(s).item(0)

fun Element.getString(key: String): String = getOrException(key) { it }


inline fun <reified T : Any> Element.getOrException(key: String, transform: (String) -> T): T {
    val get = transform(this.getElementByTagName(key)?.textContent ?: throw ValueNotFoundException(
            key))
    return get
}

inline fun <reified T : Any> Element.getOrNull(key: String, transform: (String) -> T): T? {
    val get = transform(this.getElementByTagName(key)?.textContent ?: return null)
    return get
}

fun Element.getFloat(key: String) = getOrException(key) { it.toFloat() }

fun Element.getDouble(key: String) = getOrException(key) { it.toDouble() }

fun Element.getInt(key: String) = getOrException(key) { it.toInt() }

fun Element.getLong(key: String) = getOrException(key) {
    it.toLong()
}

fun Element.getBoolean(key: String): Boolean = getOrException(key) {
    it.toBoolean()
}