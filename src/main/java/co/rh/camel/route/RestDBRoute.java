package co.rh.camel.route;

import org.springframework.stereotype.Component;

import co.rh.camel.process.SysoutProcessor;

@Component
public class RestDBRoute extends BaseRouteBuilder {
	
	@Override
	public void configure() throws Exception {
		
		super.init();
//		 #access formatting http://localhost:8080/case/api/selectByBean
//		# http://localhost:8080/case/api-doc
		
		
		rest("/api/").description("Case REST service").consumes("application/json").produces("application/json")
//		.get("/select-acc-all").description("Find all users").to("mybatis-bean:IGroupDAO:selectById")
			
//		.get("/select-acc/{id}").description("Find a user").to("direct:mylog");
		.get("/pending").description("wait a minute").to("direct:pending");
//		
		
//		.get("/selectById").to("mybatis:selectGroups?statementType=SelectOne");
//		
		SysoutProcessor s = new SysoutProcessor();
		from("direct:pending").process(s);
//		from("direct:mylog").log("Processing $simple{in.header.id}").to("mybatis-bean:IGroupDAO:selectId?inputHeader=id");
		 
	
		
	
	}

}