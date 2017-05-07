package me.ddevil.mal.test

import me.ddevil.mal.MALUser
import me.ddevil.mal.RequestManager
import me.ddevil.mal.request.AnimeSearchRequest
import me.ddevil.util.getResource
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import org.junit.Test
import java.io.File
import java.io.FileInputStream

//Mal doesn't like japanese searches apparently
val animes = arrayOf("Nisekoi", "Nagi No Asukara", "Kimi no Na Wa", "中二病でも恋がしたい", "Chuunibyou demo koi ga shitai")

class AnimeSearchTest {
    @Test
    internal fun test() {
        val jsonUrl = getResource("/config.json")
        val file = FileInputStream(File(jsonUrl.toURI()))
        val jsonString = String(file.readBytes())
        println("Found config $jsonString")
        val json = JSONParser().parse(jsonString) as JSONObject
        val user = MALUser(json as Map<String, Any>)

        val manager = RequestManager(user)
        for (animeName in animes) {
            println("Searching for '$animeName'")
            val result = manager.request(AnimeSearchRequest(animeName))
            if (result.isEmpty()) {
                println("Couldn't find any anime for '$animeName'")
                continue
            }
            println("Found ${result.size} animes.")
            for (anime in result) {
                println(anime)
            }
        }
    }
}