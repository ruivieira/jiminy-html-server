package io.radanalytics.jiminy;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.radanalytics.jiminy.model.ColumnHeader;
import io.radanalytics.jiminy.model.PredictionType;
import io.radanalytics.jiminy.model.ReportDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.radanalytics.jiminy.model.RankType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;


/**
 * PredictorUtils<br>
 * Simple utility class to proxy predictor service and get recommendations from the trained model
 * 
 * @author Zak Hassan <zhassan@redhat.com>
 */
public class PredictorUtils {
	 
	private static final Logger LOGGER = LoggerFactory.getLogger(PredictorUtils.class);
	public static ReportDAO fetchPredictions(String uid, int topk, String predictorURL) throws InterruptedException, JsonParseException, JsonMappingException, IOException {
		ReportDAO report=null;
		Client client = createJSONRestClient();
		WebResource webResource = client.resource(predictorURL);
		PredictionType pr;
		try {
			pr = fetchPrediction(webResource, new HashMap<String, Object>() {
				{
					put("user", uid);
					put("topk", topk);
				}
			});
			TimeUnit.SECONDS.sleep(1);
			String rec = predictorURL + "/" + pr.getPrediction().getId();
			ClientResponse response = getTopRatedProducts(rec);
			String output = response.getEntity(String.class);
		 
			ObjectMapper mapper = new ObjectMapper();
			RankType rank = mapper.readValue(output, RankType.class);
			 
			report = new ReportDAO("OK",
					Arrays.asList(new ColumnHeader("id", "ID"), new ColumnHeader("rating", "Rating")),
					rank.getProducts());
		 
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return report;
	}

	// TODO: Need to move the functions below into utility class
	public static ClientResponse getTopRatedProducts(String rec) {
		LOGGER.info(rec);
		Client secondReq = Client.create();

		WebResource secondResource = secondReq.resource(rec);
		ClientResponse response = secondResource.accept("application/json").get(ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		return response;
	}

	public static PredictionType fetchPrediction(WebResource webResource, Map<String, Object> input)
			throws IOException, JsonParseException, JsonMappingException {
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.post(ClientResponse.class, input);

		if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}

		String output = response.getEntity(String.class);

		 

		ObjectMapper mapper = new ObjectMapper();
		PredictionType pr = mapper.readValue(output, PredictionType.class);
		return pr;
	}

	public static Client createJSONRestClient() {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, true);

		Client client = Client.create(clientConfig);
		return client;
	}

}