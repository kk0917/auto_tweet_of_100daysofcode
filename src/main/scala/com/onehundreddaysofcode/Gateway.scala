package com.onehundreddaysofcode

import com.google.cloud.functions.{HttpFunction, HttpRequest, HttpResponse}
import com.github.redouane59.twitter.TwitterClient
import com.github.redouane59.twitter.signature.TwitterCredentials

class Gateway extends HttpFunction {
//  override def service(httpRequest: HttpRequest, httpResponse: HttpResponse): Unit = {
//    httpResponse.getWriter.write("Hello World!")
//  }

  // config to runtime env var on Cloud Functions
  val apiKey:            String = System.getenv("API_KEY")
  val apiSecretKey:      String = System.getenv("API_SECRET_KEY")
  val accessTokeyKey:    String = System.getenv("ACCESS_TOKEN_KEY")
  val accessTokenSecret: String = System.getenv("ACCESS_TOKEN_SECRET")

  override def service(request: HttpRequest, response: HttpResponse): Unit = {
    val twitter: TwitterClient = new TwitterClient(TwitterCredentials.builder()
      .apiKey(apiKey)
      .apiSecretKey(apiSecretKey)
      .accessToken(apiKey)
      .accessTokenSecret(apiSecretKey)
      .build())

    try {
//      twitter.postTweet()...
      // status=200

      response.getWriter.write("Hello, world!")

    } catch {
      // status=500
      case e: Exception => println(e.getMessage)
    }
  }
}
