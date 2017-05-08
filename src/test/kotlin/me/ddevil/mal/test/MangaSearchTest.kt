package me.ddevil.mal.test

import me.ddevil.mal.MALUser
import me.ddevil.mal.RequestManager
import me.ddevil.mal.request.MangaSearchRequest
import me.ddevil.util.getResource
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import org.junit.Test
import java.io.File
import java.io.FileInputStream
val MANGAS = arrayOf("Horimiya", "Nisekoi", "Nisekoi Doumei", "Re Life")
class MangaSearchTest {
    @Test
    fun test() {
        val jsonUrl = getResource("/config.json")
        val file = FileInputStream(File(jsonUrl.toURI()))
        val jsonString = String(file.readBytes())
        println("Found config $jsonString")
        val json = JSONParser().parse(jsonString) as JSONObject
        val user = MALUser(json as Map<String, Any>)

        val manager = RequestManager(user)
        for (mangaName in MANGAS) {
            println("Searching for '$mangaName'")
            val result = manager.request(MangaSearchRequest(mangaName))
            if (result.isEmpty()) {
                println("Couldn't find any manga for '$mangaName'")
                continue
            }
            println("Found ${result.size} mangas.")
            for (manga in result) {
                println(manga)
            }
        }
    }
}