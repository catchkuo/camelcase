package co.rh.camel.process;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class SysoutProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		System.out.println("IN:");
		System.out.println(exchange.getIn());
		System.out.println("Header:");
		System.out.println(exchange.getIn().getHeaders());
		System.out.println("Header:data");
		
		System.out.println(exchange.getIn().getHeader("data"));
		System.out.println("Body:");
		Thread.sleep(3000);
//		System.out.println(exchange.getIn().getBody().getClass());
//		System.out.println(exchange.getIn().getBody());
//		System.out.println(DatatypeConverter.printHexBinary(exchange.getIn().getBody(byte[].class)));
//		System.out.println(new String(exchange.getIn().getBody(byte[].class)));
//		System.out.println(exchange.getProperties());
		exchange.getOut().setBody("sorry for letting you wait." );
		
		
	}

}
