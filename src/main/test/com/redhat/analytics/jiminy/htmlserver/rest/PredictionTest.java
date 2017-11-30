package com.redhat.analytics.jiminy.htmlserver.rest;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
public class PredictionTest {

	@Test
	public void test() {
		try {

			ClientConfig clientConfig = new DefaultClientConfig();              
			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, true);
			
			Client client = Client.create(clientConfig);


			WebResource webResource = client
			   .resource("http://predictor-jiminy2.e8ca.engint.openshiftapps.com/predictions/ranks");

			Map<String,Object> input = new HashMap<String,Object>();
			input.put("user", "1");
			input.put("topk", 5);
			ClientResponse response = webResource.accept("application/json")
	                .type("application/json").post(ClientResponse.class, input);
			

			if (response.getStatus() != 201) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);
			
			ObjectMapper mapper= new ObjectMapper();
			PredictionType pr=mapper.readValue(output, PredictionType.class);
			
			
			System.out.println(pr);

		  } catch (Exception e) {

			e.printStackTrace();

		  }
		
		
		
//		Map<String,String> vars= new HashMap<String,String>();
//		vars.put("user", "1");
//		vars.put("topk", "5");
//		
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.getForObject("http://predictor-jiminy2.e8ca.engint.openshiftapps.com/predictions/ranks", PredictionType.class, vars);
		
	}

}
