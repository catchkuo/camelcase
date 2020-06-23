package com.camel.demo;

import javax.xml.bind.DatatypeConverter;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class SysoProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		System.out.println(exchange.getIn());
		System.out.println("=============");
		System.out.println(exchange.getIn().getHeaders());
		System.out.println("=============");
		System.out.println(exchange.getIn().getBody().getClass());
		System.out.println("=============");
//		System.out.println(DatatypeConverter.printHexBinary(exchange.getIn().getBody(byte[].class)));
//		System.out.println(new String(exchange.getIn().getBody(byte[].class)));
		System.out.println("=============");
		System.out.println(exchange.getProperties());
		
	}

}
