package functions

import com.google.cloud.functions.{HttpFunction, HttpRequest, HttpResponse}

class Tweet extends HttpFunction {
  override def service(httpRequest: HttpRequest, httpResponse: HttpResponse): Unit = println("Success!")
}
