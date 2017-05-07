package me.ddevil.mal.request

import me.ddevil.mal.MALUser
import me.ddevil.mal.anime.Anime
import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpGet
import org.w3c.dom.Element
import javax.xml.parsers.DocumentBuilderFactory


const val ANIME_REQUEST_PREFIX = "https://myanimelist.net/api/anime/search.xml?q="

class AnimeRequest(val name: String, user: MALUser) : AbstractRequest<List<Anime>>(user) {
    override fun createRequest() = HttpGet("$ANIME_REQUEST_PREFIX$name")

    override fun execute(result: HttpResponse): List<Anime> {
        val dbf = DocumentBuilderFactory.newInstance()
        val db = dbf.newDocumentBuilder()
        val document = db.parse(result.entity.content)
        val list = ArrayList<Anime>()
        val foundAnime = document.getElementsByTagName("entry")
        for (i in 0..foundAnime.length - 1) {
            val serializedAnime = foundAnime.item(i) as Element
            list += Anime(serializedAnime)
        }
        return list
    }


}

fun Element.getElementByTagName(s: String) = getElementsByTagName(s).item(0)!!


val HttpResponse.content get() = String(entity.content.readBytes())
