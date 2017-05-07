package me.ddevil.mal.util

import java.util.*

fun encodeBase64(string: String) = String(Base64.getEncoder().encode(string.toByteArray()))