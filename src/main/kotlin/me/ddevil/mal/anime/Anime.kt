package me.ddevil.mal.anime

import me.ddevil.mal.misc.ANIME_EPISODES_KEY
import me.ddevil.mal.misc.Media
import me.ddevil.mal.misc.STATUS_KEY
import me.ddevil.mal.misc.TYPE_KEY
import me.ddevil.mal.util.getInt
import me.ddevil.mal.util.getString
import me.ddevil.util.getInt
import me.ddevil.util.getString
import org.w3c.dom.Element

class Anime : Media {

    val episodes: Int
    val type: AnimeType
    val status: AnimeStatus

    constructor(map: Map<String, Any>) : super(map) {
        this.episodes = map.getInt(ANIME_EPISODES_KEY)
        this.type = AnimeType.valueOf(map.getString(TYPE_KEY).toUpperCase())
        this.status = AnimeStatus.valueOf(map.getString(STATUS_KEY))

    }

    constructor(element: Element) : super(element) {
        this.episodes = element.getInt(ANIME_EPISODES_KEY)
        this.type = AnimeType.valueOf(element.getString(TYPE_KEY).toUpperCase())
        this.status = AnimeStatus.valueOf(element.getString(STATUS_KEY).toUpperCase().replace(' ',
                '_'))
    }

    override fun toString(): String {
        return "Anime(id=$id, title='$title', englishTitle='$englishTitle', type=$type, status=$status)"
    }


}

