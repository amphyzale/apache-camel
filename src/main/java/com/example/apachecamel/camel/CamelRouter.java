package com.example.apachecamel.camel;

import com.example.apachecamel.model.Info;
import com.example.apachecamel.model.Model;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Locale;

@Slf4j
@Component
public class CamelRouter extends RouteBuilder {

    public static final String REQUEST_BODY = "{\"stringData\": \"%s\", \"longData\": %d, \"numberData\": %.2f, \"dateTimeData\": \"%s\"}";
    public static final String RESPONSE_BODY = "{\"id\": %d, \"message\": \"%s\"}";

    @Override
    public void configure() {
        from("activemq:topic:another")
                .log("Message from another topic: ${body}")
                .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                .process(e -> {
                    final Info in = e.getIn().getBody(Info.class);
                    e.getIn().setBody(String.format(Locale.ROOT, RESPONSE_BODY, in.getLongData(), in.getStringData()));
                })
                .toD("http://localhost:9090/api/send/default")
                .process(e -> log.info("The response code is: {}", e.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE)));

        from("activemq:topic:default")
                .routeId("HTTP Route")
                .log("Message from default topic: ${body}")
                .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                .process(e -> {
                    final Model in = e.getIn().getBody(Model.class);
                    e.getIn().setBody(String.format(Locale.ROOT, REQUEST_BODY, in.getMessage(), in.getId(), BigDecimal.TEN, LocalDateTime.now()));
                })
                .toD("http://localhost:8080/service/1/v1/post_info")
                .process(e -> log.info("The response code is: {}", e.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE)));

    }
}
