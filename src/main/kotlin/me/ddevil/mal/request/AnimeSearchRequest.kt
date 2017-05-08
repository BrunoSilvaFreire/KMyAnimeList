package me.ddevil.mal.request

import me.ddevil.mal.anime.Anime
import org.w3c.dom.Element


class AnimeSearchRequest(name: String) : SearchRequest<Anime>(name) {

    override val type get() = "anime"

    override fun deserialize(element: Element) = Anime(element)

}