package com.onehundreddaysofcode

import com.google.cloud.functions.{HttpFunction, HttpRequest, HttpResponse}
import com.google.gson.{Gson, JsonElement, JsonObject, JsonParseException}
import com.github.redouane59.twitter.TwitterClient
import com.github.redouane59.twitter.signature.TwitterCredentials
import io.circe._
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._

class Gateway extends HttpFunction {
  //  override def service(httpRequest: HttpRequest, httpResponse: HttpResponse): Unit = {
  //    httpResponse.getWriter.write("Hello World!")
  //  }

  // config the following runtime env var to Cloud Functions
  val apiKey:            String = System.getenv("API_KEY")
  val apiSecretKey:      String = System.getenv("API_SECRET_KEY")
  val accessTokeyKey:    String = System.getenv("ACCESS_TOKEN_KEY")
  val accessTokenSecret: String = System.getenv("ACCESS_TOKEN_SECRET")

  // use to parse JSON content
  //  val gson: Gson = new Gson()

  override def service(request: HttpRequest, response: HttpResponse) = {
    val twitter: TwitterClient = new TwitterClient(TwitterCredentials.builder()
      .apiKey(apiKey)
      .apiSecretKey(apiSecretKey)
      .accessToken(apiKey)
      .accessTokenSecret(apiSecretKey)
      .build())

    val gson: Gson = new Gson()

    try {
      // parse json of pushed tweet info
      val requestParsed: Option[JsonElement] = Some(gson.fromJson(request.getReader, Class[JsonElement]))
      val requestJson: JsonObject = requestParsed match {
        case Some(v) if v.isJsonObject => requestParsed
        case _ =>
      }

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

  def buildResponse(response: HttpResponse): HttpResponse = {
    response.setStatusCode(200)
    response.setContentType("application/json")
    response.getWriter.write("")

    response
  }
}
