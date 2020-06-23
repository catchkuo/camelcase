package com.camel.demo;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class CallRestProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		Object inBody = exchange.getIn().getBody();
		// out.setHeader("CamelHttpMethod", "GET");

		if (inBody.getClass().isAssignableFrom(byte[].class)) {
			String doc2 = new String((byte[]) inBody, "UTF-8");
			exchange.getOut().setBody(doc2);
		}

	}

}
