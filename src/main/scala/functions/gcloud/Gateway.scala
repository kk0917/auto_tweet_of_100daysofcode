package functions.gcloud

import com.google.cloud.functions.{HttpFunction, HttpRequest, HttpResponse}

class Gateway extends HttpFunction {
  override def service(httpRequest: HttpRequest, httpResponse: HttpResponse): Unit = {
    httpResponse.getWriter.write("Hello World!")
  }
}
