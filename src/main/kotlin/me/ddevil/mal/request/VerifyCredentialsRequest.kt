package me.ddevil.mal.request

import me.ddevil.mal.MALUser
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet


const val VERIFY_CREDENTIALS_PREFIX = "https://myanimelist.net/api/account/verify_credentials.xml"

class VerifyCredentialsRequest(val user: MALUser) : Request<Boolean> {
    override fun execute(client: HttpClient, user: MALUser): Boolean {
        val get = HttpGet(VERIFY_CREDENTIALS_PREFIX)
        get.addHeader("Authorization", "Basic ${user.authorization}")
        val s = client.execute(get)

        return s.statusLine.statusCode == 200
    }
}