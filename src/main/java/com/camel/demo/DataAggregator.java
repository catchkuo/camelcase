package com.camel.demo;

import java.util.ArrayList;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class DataAggregator implements AggregationStrategy {

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		Object newBody = newExchange.getIn().getBody();

		ArrayList list = null;
		if (oldExchange == null) {
			list = new ArrayList();
			list.add(newBody);
			if (newBody == null) {
				newExchange.setProperty("isExchangeNull", true);
			}
			newExchange.getIn().setBody(list);
			return newExchange;
		} else {
			list = oldExchange.getIn().getBody(ArrayList.class);
			list.add(newBody);
			if (newBody == null) {
				oldExchange.setProperty("isExchangeNull", true);
			}
			return oldExchange;
		}

	}

}
