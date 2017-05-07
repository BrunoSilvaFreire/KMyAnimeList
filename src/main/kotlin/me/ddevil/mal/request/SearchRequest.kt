package me.ddevil.mal.request

import me.ddevil.mal.MALUser
import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpUriRequest
import org.w3c.dom.Element
import javax.xml.parsers.DocumentBuilderFactory

abstract class SearchRequest<out T>(val name: String) : AbstractRequest<List<T>>() {
    abstract val type: String
    override fun createRequest(): HttpUriRequest {
        return HttpGet("https://myanimelist.net/api/$type/search.xml?q=$name")
    }

    override fun execute(result: HttpResponse, user: MALUser): List<T> {
        val dbf = DocumentBuilderFactory.newInstance()
        val db = dbf.newDocumentBuilder()
        val document = db.parse(result.entity.content)
        val list = ArrayList<T>()
        val foundResult = document.getElementsByTagName("entry")
        for (i in 0..foundResult.length - 1) {
            val serializedObject = foundResult.item(i) as Element
            list += deserialize(serializedObject)
        }
        return list
    }

    abstract fun deserialize(element: Element): T
}