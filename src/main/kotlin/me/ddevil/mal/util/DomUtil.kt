package me.ddevil.mal.util

import org.w3c.dom.Element

fun Element.getElementByTagName(s: String) = getElementsByTagName(s).item(0)!!
