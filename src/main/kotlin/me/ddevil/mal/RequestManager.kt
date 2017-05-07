package me.ddevil.mal

import me.ddevil.mal.request.Request
import org.apache.http.client.HttpClient
import org.apache.http.impl.client.HttpClientBuilder

class RequestManager
@JvmOverloads
constructor(
        val user: MALUser,
        val client: HttpClient = HttpClientBuilder.create().build()
) {

    fun <R> request(request: Request<R>): R = request.execute(client, user)

}