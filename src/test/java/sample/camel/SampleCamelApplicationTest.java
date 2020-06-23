///**
// * Licensed to the Apache Software Foundation (ASF) under one or more
// * contributor license agreements.  See the NOTICE file distributed with
// * this work for additional information regarding copyright ownership.
// * The ASF licenses this file to You under the Apache License, Version 2.0
// * (the "License"); you may not use this file except in compliance with
// * the License.  You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
package sample.camel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.awt.print.Book;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.NotifyBuilder;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;

import co.rh.beans.model.Groups;
import co.rh.camel.Application;

@RunWith(CamelSpringBootRunner.class)
@SpringBootTest(classes = Application.class,webEnvironment = WebEnvironment.RANDOM_PORT)
public class SampleCamelApplicationTest {

    @Autowired
    private CamelContext camelContext;
    
    
    

    @Autowired
    private TestRestTemplate restTemplate;

//    @Test
    public void shouldProduceMessages() throws Exception {
         
         NotifyBuilder notify = new NotifyBuilder(camelContext).whenDone(1).create();
         assertTrue(notify.matches(40, TimeUnit.SECONDS));
         
         
    }
    
    @Test
    public void booksTest() {
    	
        ResponseEntity<Groups> response = restTemplate.exchange("http://localhost:8080/case/api/selectByBean/1",
            HttpMethod.GET, null, new ParameterizedTypeReference<Groups>() {
            });
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Groups g = response.getBody();
        System.out.println(g.getId());
        
        assertThat(g.getId()).isEqualTo(1);

    }
}
