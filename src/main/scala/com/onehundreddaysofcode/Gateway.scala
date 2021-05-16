package com.onehundreddaysofcode

import java.io.BufferedWriter
import java.net.HttpURLConnection

import com.google.cloud.functions.{HttpFunction, HttpRequest, HttpResponse}
import com.google.gson.{Gson, JsonElement, JsonObject, JsonParseException}
import com.github.redouane59.twitter.TwitterClient
import com.github.redouane59.twitter.signature.TwitterCredentials

class Gateway extends HttpFunction {
  //  override def service(httpRequest: HttpRequest, httpResponse: HttpResponse): Unit = {
  //    httpResponse.getWriter.write("Hello World!")
  //  }

  // config the following runtime env var to Cloud Functions
  val apiKey:            String = System.getenv("API_KEY")
  val apiSecretKey:      String = System.getenv("API_SECRET_KEY")
  val accessTokeyKey:    String = System.getenv("ACCESS_TOKEN_KEY")
  val accessTokenSecret: String = System.getenv("ACCESS_TOKEN_SECRET")

  override def service(request: HttpRequest, response: HttpResponse) = {
    val twitter: TwitterClient = new TwitterClient(TwitterCredentials.builder()
      .apiKey(apiKey)
      .apiSecretKey(apiSecretKey)
      .accessToken(apiKey)
      .accessTokenSecret(apiSecretKey)
      .build())

    val gson: Gson  = new Gson()
    val contentType = Option(request.getContentType)

    try {
      // parse json of pushed tweet info
      val body: Option[String] = contentType match {
        case Some(t)
          if contentType.getOrElse(None) == "application/json" =>
            gson.fromJson(request.getReader, classOf[Nothing])
        case _ => None
      }

      val buildResp = buildResponse(response)
      buildResp

      // parse json body
      // ...

      // get texts of title and description
      // ...

      // media(picture)
      //...

      // hashtag
      // ...

      // post
      // ...

      // response
      //      val builtResp = buildResponse(response)

    } catch {
      // status=500
      case e: Exception => println(e.getMessage)
    }
  }

  def buildResponse(response: HttpResponse): BufferedWriter = {
    response.setStatusCode(HttpURLConnection.HTTP_OK)
    response.setContentType("application/json")
    response.getWriter.write("")
  }
}
