package me.ddevil.mal.request

import me.ddevil.mal.manga.Manga
import org.w3c.dom.Element

class MangaSearchRequest(name: String) : SearchRequest<Manga>(name) {
    override val type get() = "manga"

    override fun deserialize(element: Element): Manga {
        return Manga(element)
    }
}