package me.ddevil.mal

import me.ddevil.util.Serializable
import me.ddevil.util.getString
import me.ddevil.util.immutableStringAnyMapBuilder

const val MALSESSIONID_KEY = "MALSESSIONID"
const val MALHLOGSESSID_KEY = "MALHLOGSESSID"
//TODO: Make requests work with cookies
class MALSession : Serializable {
    val MALHLOGSESSID: String
    val MALSESSIONID: String

    constructor(map: Map<String, Any>) {
        this.MALHLOGSESSID = map.getString(MALHLOGSESSID_KEY)
        this.MALSESSIONID = map.getString(MALSESSIONID_KEY)
    }

    constructor(MALHLOGSESSID: String, MALSESSIONID: String) {
        this.MALHLOGSESSID = MALHLOGSESSID
        this.MALSESSIONID = MALSESSIONID
    }

    override fun serialize(): Map<String, Any> {
        return immutableStringAnyMapBuilder()
                .put(MALHLOGSESSID_KEY, MALHLOGSESSID)
                .put(MALSESSIONID_KEY, MALSESSIONID)
                .build()
    }

    val malSessionIdCookie get() = "$MALSESSIONID_KEY=$MALSESSIONID"
    val malHLogSessIdCookie get() = "$MALHLOGSESSID_KEY=$MALHLOGSESSID"

    fun toCookiesValues() = "$MALSESSIONID_KEY=$MALSESSIONID; $MALHLOGSESSID_KEY=$MALHLOGSESSID"
}