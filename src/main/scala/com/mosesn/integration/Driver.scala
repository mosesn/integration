package com.mosesn.integration

import com.twitter.finagle.{Http, Service}
import com.twitter.finagle.http.{Http => HttpCodec}
import com.twitter.finagle.builder.ClientBuilder
import com.twitter.finagle.stats.DefaultStatsReceiver
import com.twitter.server.TwitterServer
import com.twitter.util.{Future, Await}
import org.jboss.netty.handler.codec.http.{HttpRequest, HttpResponse, DefaultHttpResponse}
import org.jboss.netty.handler.codec.http.HttpVersion.HTTP_1_1
import org.jboss.netty.handler.codec.http.HttpResponseStatus.OK

object Driver extends TwitterServer {
  def main() {
    val client = ClientBuilder()
    .codec(HttpCodec())
    .dest("google.com:80,twitter.com:80")
    .hostConnectionLimit(10)
    .reportHostStats(DefaultStatsReceiver)
    .build()
    val server = Http.serve("localhost:8080", client)
    onExit {
      server.close()
      client.close()
    }
    Await.ready(server)
  }
}
