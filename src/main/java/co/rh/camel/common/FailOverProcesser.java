package co.rh.camel.common;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class FailOverProcesser implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

	
		final ObjectMapper mapper = new ObjectMapper();
	
		

		exchange.getOut().setHeader(Exchange.CONTENT_TYPE, "application/json");
		exchange.getOut().setBody(mapper.writeValueAsString("err0r"));

	}

}
