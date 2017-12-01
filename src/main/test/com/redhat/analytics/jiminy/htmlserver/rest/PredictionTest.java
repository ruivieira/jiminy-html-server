package com.redhat.analytics.jiminy.htmlserver.rest;

//import static org.junit.Assert.*;
//
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
//import org.junit.Test;
//import org.springframework.web.client.RestTemplate;
//
//import com.fasterxml.jackson.core.JsonParseException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.redhat.analytics.jiminy.htmlserver.model.ColumnHeader;
//import com.redhat.analytics.jiminy.htmlserver.model.MovieDataSet;
//import com.redhat.analytics.jiminy.htmlserver.model.ReportDAO;
//import com.sun.jersey.api.client.Client;
//import com.sun.jersey.api.client.ClientResponse;
//import com.sun.jersey.api.client.WebResource;
//import com.sun.jersey.api.client.config.ClientConfig;
//import com.sun.jersey.api.client.config.DefaultClientConfig;
//import com.sun.jersey.api.json.JSONConfiguration;

public class PredictionTest {
//
//	@Test
//	public void test() {
//		try {
//
//			Client client = createJSONRestClient();
//			String uri = "http://predictor-jiminy2.e8ca.engint.openshiftapps.com/predictions/ranks";
//			WebResource webResource = client.resource(uri);
//			PredictionType pr = fetchPrediction(webResource, new HashMap<String, Object>() {
//				{
//					put("user", "1");
//					put("topk", 5);
//				}
//			});
//			TimeUnit.SECONDS.sleep(10);
//			String rec = "http://predictor-jiminy2.e8ca.engint.openshiftapps.com/predictions/ranks/"
//					+ pr.getPrediction().getId();
//			ClientResponse response = getTopRatedProducts(rec);
//
//			String output = response.getEntity(String.class);
//
//			System.out.println("Final Output from Server .... \n");
//			
//			ObjectMapper mapper = new ObjectMapper();
//			RankType rank = mapper.readValue(output, RankType.class);
//			System.out.println(rank);
//			
//			
//			 ReportDAO report= new ReportDAO("OK",
//		                Arrays.asList(
//		                    new ColumnHeader("id","ID"),
//		                    new ColumnHeader("rating","Rating")  ),
//	                    rank.products);
//			 
//			 System.out.println(report);
//			 
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	private ClientResponse getTopRatedProducts(String rec) {
//		System.out.println(rec);
//		Client secondReq = Client.create();
//
//		WebResource secondResource = secondReq.resource(rec);
//		ClientResponse response = secondResource.accept("application/json").get(ClientResponse.class);
//		if (response.getStatus() != 200) {
//			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
//		}
//		return response;
//	}
//
//	private PredictionType fetchPrediction(WebResource webResource, Map<String, Object> input)
//			throws IOException, JsonParseException, JsonMappingException {
//		ClientResponse response = webResource.accept("application/json").type("application/json")
//				.post(ClientResponse.class, input);
//
//		if (response.getStatus() != 201) {
//			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
//		}
//
//		String output = response.getEntity(String.class);
//
//		System.out.println("Output from Server .... \n");
//		System.out.println(output);
//
//		ObjectMapper mapper = new ObjectMapper();
//		PredictionType pr = mapper.readValue(output, PredictionType.class);
//		return pr;
//	}
//
//	private Client createJSONRestClient() {
//		ClientConfig clientConfig = new DefaultClientConfig();
//		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, true);
//
//		Client client = Client.create(clientConfig);
//		return client;
//	}

}
