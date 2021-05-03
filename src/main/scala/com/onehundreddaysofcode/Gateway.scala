package com.onehundreddaysofcode

import com.google.cloud.functions.{HttpFunction, HttpRequest, HttpResponse}
import com.github.redouane59.twitter.TwitterClient
import com.github.redouane59.twitter.signature.TwitterCredentials

class Gateway extends HttpFunction {
//  override def service(httpRequest: HttpRequest, httpResponse: HttpResponse): Unit = {
//    httpResponse.getWriter.write("Hello World!")
//  }

  // config to runtime env var on Cloud Functions
  val API_KEY:             String = API_KEY
  val API_SECRET_KEY:      String = API_SECRET_KEY
  val ACCESS_TOKEN_KEY:    String = ACCESS_TOKEN_KEY
  val ACCESS_TOKEN_SECRET: String = ACCESS_TOKEN_SECRET

  override def service(request: HttpRequest, response: HttpResponse): Unit = {
    val twitter: TwitterClient = new TwitterClient(TwitterCredentials.builder()
      .accessToken(ACCESS_TOKEN_KEY)
      .accessTokenSecret(ACCESS_TOKEN_SECRET)
      .apiKey(API_KEY)
      .apiSecretKey(API_SECRET_KEY)
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
