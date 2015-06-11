package io.giraffa.websocketexample;

import org.apache.camel.builder.RouteBuilder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by akoufoudakis on 11/06/15.
 */
public class WebSocketRouteBuilder extends RouteBuilder {

    private static DateFormat df = new SimpleDateFormat("ddMMyyyy hhmmss");

    public void configure() {
        from("timer:websockettimer?period=3000")
                .setBody().simple("Date from websocket is: ${date:now:dd-MM-yyyy HH:mm:ss}")
                .to("websocket://localhost:9000/something?sendToAll=true");
    }

}
