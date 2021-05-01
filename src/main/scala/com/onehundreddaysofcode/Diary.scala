package com.onehundreddaysofcode

import com.google.cloud.functions.{HttpFunction, HttpRequest, HttpResponse}

class Diary extends HttpFunction {
  override def service(httpRequest: HttpRequest, httpResponse: HttpResponse): Unit = {
    httpResponse.getWriter.write("Hello World!")
  }
}
