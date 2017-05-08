package me.ddevil.mal.misc

import me.ddevil.mal.util.getFloat
import me.ddevil.mal.util.getInt
import me.ddevil.mal.util.getString
import me.ddevil.util.getFloat
import me.ddevil.util.getInt
import me.ddevil.util.getList
import me.ddevil.util.getString
import org.w3c.dom.Element
import java.net.URL

const val NOT_FINISHED_DATE_STRING = "0000-00-00"

open class Media {
    val title: String
    val englishTitle: String
    val synonyms: List<String>
    val synopsis: String
    val score: Float
    val endDate: EventDate
    val startDate: EventDate
    val imgUrl: URL
    val id: Int

    constructor(map: Map<String, Any>) {
        this.id = map.getInt(ID_KEY)
        this.title = map.getString(TITLE_KEY)
        this.englishTitle = map.getString(ENGLISH_TITLE_KEY)
        this.synonyms = map.getList(SYNONYMS_KEY)
        this.synopsis = map.getString(SYNOPSIS_KEY)
        this.score = map.getFloat(SCORE_KEY)
        this.startDate = EventDate(map.getString(START_DATE_KEY))
        this.endDate = EventDate(map.getString(END_DATE_KEY))
        this.imgUrl = URL(map.getString(IMAGE_KEY))
    }


    constructor(element: Element) {
        this.id = element.getInt(ID_KEY)
        this.title = element.getString(TITLE_KEY)
        this.englishTitle = element.getString(ENGLISH_TITLE_KEY)
        this.synonyms = element.getString(SYNONYMS_KEY).split(';')
        this.synopsis = element.getString(SYNOPSIS_KEY)
        this.score = element.getFloat(SCORE_KEY)
        this.startDate = EventDate(element.getString(START_DATE_KEY))
        this.endDate = EventDate(element.getString(END_DATE_KEY))
        this.imgUrl = URL(element.getString(IMAGE_KEY))
    }

}