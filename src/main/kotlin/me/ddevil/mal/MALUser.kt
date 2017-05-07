package me.ddevil.mal

import me.ddevil.mal.util.encodeBase64
import me.ddevil.util.Serializable
import me.ddevil.util.getString
import me.ddevil.util.immutableStringAnyMapBuilder

const val USERNAME_KEY = "user"
const val PASSWORD_KEY = "pass"

class MALUser : Serializable {
    val name: String
    val pass: String
    val authorization get() = encodeBase64("$name:$pass")

    constructor(map: Map<String, Any>) {
        this.name = map.getString(USERNAME_KEY)
        this.pass = map.getString(PASSWORD_KEY)
    }

    constructor(name: String, pass: String) {
        this.name = name
        this.pass = pass
    }


    override fun serialize(): Map<String, Any> {
        return immutableStringAnyMapBuilder()
                .put(USERNAME_KEY, name)
                .put(PASSWORD_KEY, pass)
                .build()
    }
}