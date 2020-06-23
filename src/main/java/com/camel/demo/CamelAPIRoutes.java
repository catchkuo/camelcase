package com.camel.demo;

import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CamelAPIRoutes extends RouteBuilder {
	

	@Value("${mockservice.host}")
	private String host;
	@Value("${mockservice.port}")
	private int port;

	@Override
	public void configure() throws Exception {

		Processor msgOut = new CallRestProcessor();

		from("direct:callGet").removeHeaders("CamelHttp*")
				.setHeader("CamelHttpMethod", simple("POST"))
				.inOut("jetty:http://"+host+":"+port+"/camel/users/getOne").process(msgOut).end();

	}
}