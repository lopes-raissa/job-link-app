package com.example.joblink.http

import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody

class HttpHelper {

    fun post (json: String): String {

        // Definindo URL do Servidor
        val URL = "http://10.107.134.6:3333/clients"

        // Definindo o header
        val headerHttp = MediaType.parse("application/json; charset=utf-8")

        // Criando Cliente que dispara a requisição
        val client = OkHttpClient()

        // Criando Body da requisição
        val body = RequestBody.create(headerHttp, json)

        // Construir requisição http para o servidor
        var request = Request.Builder().url(URL).post(body).build()

        // Utilizando client para fazer a requisição e receber resposta
        val response = client.newCall(request).execute()

        return response.body().toString()
    }
}