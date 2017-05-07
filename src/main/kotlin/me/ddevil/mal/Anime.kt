package me.ddevil.mal

import me.ddevil.mal.util.getElementByTagName
import me.ddevil.util.getFloat
import me.ddevil.util.getInt
import me.ddevil.util.getList
import me.ddevil.util.getString
import org.json.simple.JSONObject
import org.w3c.dom.Element
import java.net.URL
import java.time.LocalDate
import java.time.format.DateTimeFormatter

const val ANIME_ID_KEY = "id"
const val ANIME_TITLE_KEY = "title"
const val ANIME_ENGLISH_TITLE_KEY = "english"
const val ANIME_SYNONYMS_KEY = "synonyms"
const val ANIME_EPISODES_KEY = "episodes"
const val ANIME_TYPE_KEY = "type"
const val ANIME_STATUS_KEY = "status"
const val ANIME_SYNOPSIS_KEY = "synopsis"
const val ANIME_SCORE_KEY = "score"
const val ANIME_START_DATE_KEY = "start_date"
const val ANIME_END_DATE_KEY = "end_date"
const val ANIME_IMAGE_KEY = "image"

class Anime {

    val id: Int
    val title: String
    val englishTitle: String
    val synonyms: List<String>
    val episodes: Int
    val type: AnimeType
    val synopsis: String
    val score: Float
    val endDate: LocalDate
    val startDate: LocalDate
    val status: AnimeStatus
    val imgUrl: URL

    constructor(map: Map<String, Any>) {
        println(JSONObject(map).toString())
        this.id = map.getInt(ANIME_ID_KEY)
        this.title = map.getString(ANIME_TITLE_KEY)
        this.englishTitle = map.getString(ANIME_ENGLISH_TITLE_KEY)
        this.synonyms = map.getList(ANIME_SYNONYMS_KEY)
        this.episodes = map.getInt(ANIME_EPISODES_KEY)
        this.type = AnimeType.valueOf(map.getString(ANIME_TYPE_KEY).toUpperCase())
        this.status = AnimeStatus.valueOf(map.getString(ANIME_STATUS_KEY))
        this.synopsis = map.getString(ANIME_SYNOPSIS_KEY)
        this.score = map.getFloat(ANIME_SCORE_KEY)
        this.startDate = LocalDate.parse(map.getString(ANIME_START_DATE_KEY))
        this.endDate = LocalDate.parse(map.getString(ANIME_END_DATE_KEY))
        this.imgUrl = URL(map.getString(ANIME_IMAGE_KEY))
    }

    constructor(map: Element) {
        this.id = map.getElementByTagName(ANIME_ID_KEY).textContent.toInt()
        this.title = map.getElementByTagName(ANIME_TITLE_KEY).textContent
        this.englishTitle = map.getElementByTagName(ANIME_ENGLISH_TITLE_KEY).textContent
        this.synonyms = map.getElementByTagName(ANIME_SYNONYMS_KEY).textContent.split(';')
        this.episodes = map.getElementByTagName(ANIME_EPISODES_KEY).textContent.toInt()
        this.type = AnimeType.valueOf(map.getElementByTagName(ANIME_TYPE_KEY).textContent.toUpperCase())
        this.status = AnimeStatus.valueOf(map.getElementByTagName(ANIME_STATUS_KEY).textContent.toUpperCase().replace(' ', '_'))
        this.synopsis = map.getElementByTagName(ANIME_SYNOPSIS_KEY).textContent
        this.score = map.getElementByTagName(ANIME_SCORE_KEY).textContent.toFloat()
        this.startDate = LocalDate.parse(map.getElementByTagName(ANIME_START_DATE_KEY).textContent, DateTimeFormatter.ISO_DATE)
        this.endDate = LocalDate.parse(map.getElementByTagName(ANIME_END_DATE_KEY).textContent, DateTimeFormatter.ISO_DATE)
        this.imgUrl = URL(map.getElementByTagName(ANIME_IMAGE_KEY).textContent)
    }

    override fun toString(): String {
        return "Anime(id=$id, title='$title', englishTitle='$englishTitle', type=$type, status=$status)"
    }


}

