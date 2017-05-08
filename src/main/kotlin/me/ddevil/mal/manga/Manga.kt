package me.ddevil.mal.manga

import me.ddevil.mal.misc.*
import me.ddevil.mal.util.getInt
import me.ddevil.mal.util.getString
import me.ddevil.util.getInt
import me.ddevil.util.getString
import org.w3c.dom.Element

class Manga : Media {
    val volumes: Int
    val chapters: Int
    val type: MangaType
    val status: MangaStatus

    constructor(map: Map<String, Any>) : super(map) {
        this.volumes = map.getInt(MANGA_VOLUMES_KEY)
        this.chapters = map.getInt(MANGA_CHAPTERS_KEY)
        this.type = MangaType.valueOf(map.getString(TYPE_KEY).toUpperCase())
        this.status = MangaStatus.valueOf(map.getString(STATUS_KEY).toUpperCase())
    }

    constructor(element: Element) : super(element) {
        this.volumes = element.getInt(MANGA_VOLUMES_KEY)
        this.chapters = element.getInt(MANGA_CHAPTERS_KEY)
        this.type = MangaType.valueOf(element.getString(TYPE_KEY).toUpperCase().replace('-', '_'))
        this.status = MangaStatus.valueOf(element.getString(STATUS_KEY).toUpperCase())
    }

    override fun toString(): String {
        return "Manga(id=$id, title='$title', englishTitle='$englishTitle', type=$type, status=$status)"
    }

}

