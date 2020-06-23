package com.camel.demo;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class TestProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		System.out.println(exchange.getIn());
		System.out.println("=============");
		System.out.println(exchange.getIn().getHeaders());
		System.out.println("=============");
		// System.out.println(exchange.getIn().getBody().getClass());
		System.out.println("=============");
		System.out.println(exchange.getIn().getBody());
		System.out.println("=============");
		System.out.println(exchange.getProperties());
		exchange.getIn().setHeader("CamelRedis.Value", "s");
		exchange.getIn().setHeader("CamelRedis.Key", "camel-test");
	}

}
