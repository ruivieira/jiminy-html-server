package com.redhat.analytics.jiminy.htmlserver.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
//import io.swagger.annotations.ApiOperation;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redhat.analytics.jiminy.htmlserver.model.ColumnHeader;
import com.redhat.analytics.jiminy.htmlserver.model.PredictionType;
import com.redhat.analytics.jiminy.htmlserver.model.RankType;
import com.redhat.analytics.jiminy.htmlserver.model.RatingsDAO;
import com.redhat.analytics.jiminy.htmlserver.model.ReportDAO;
import com.redhat.analytics.jiminy.htmlserver.service.RatingService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import io.swagger.annotations.ApiOperation;

/**
 * RatingsController<br>
 * 
 * Spring controller which will serve requests for CRUD operations against the ratings database.
 * 
 * @author zhassan
 */
@RestController
@RequestMapping()
public class RatingsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RatingsController.class);

	@Value("${openshift.config.predictor.url}")
	String predictorURL;

	@Autowired
	RatingService service;
	 
	
	@ApiOperation(value = "getAllRatings", produces = "application/json", notes = "Querythe database to fetch full list of ratings from the postgres db")
	@RequestMapping(method = RequestMethod.GET, path = "/api/ratings")
	public List<RatingsDAO> getAllRatings() {
		LOGGER.info("get all ratings");
		return service.findAll();
	}

	@ApiOperation(value = "getRatingById", produces = "application/json", notes = "Query the database for rating entry with the id provided in the url path")
	@RequestMapping(method = RequestMethod.GET, path = "/api/ratings/{id}")
	public RatingsDAO getOneRating(@PathVariable("id") Integer id) {
		LOGGER.info("find rating by id: {}", id);
		return service.findById(id);
	}

	@ApiOperation(value = "createRating", produces = "application/json", consumes = "application/json", notes = "Inserts a new rating entry in the database")
	@RequestMapping(method = RequestMethod.POST, path = "/api/ratings")
	@ResponseStatus(HttpStatus.CREATED)
	public RatingsDAO createRating(@RequestBody @Valid RatingsDAO rating) {
		LOGGER.info("create rating entry: {} ", rating);
		return service.create(rating);
	}

	@ApiOperation(value = "updateRatingById", produces = "application/json", notes = "Update rating entry with the id provided in the url")
	@RequestMapping(  method = RequestMethod.PUT, path = "/api/ratings/{id}")
	public RatingsDAO updateRating(@RequestBody @Valid RatingsDAO rating) {
		LOGGER.info("update rating entry: {}", rating);
		return service.update(rating);
	}

	@ApiOperation(value = "deleteRatingById", produces = "application/json", notes = "Delete rating from database with the id provided in the url")
	@RequestMapping(method = RequestMethod.DELETE, path = "/api/ratings/{id}")
	public RatingsDAO deleteRating(@PathVariable("id") Integer id) {
		LOGGER.info("delete rating entry with id: {}", id);
		return service.delete(id);
	}

	@ApiOperation(value = "getPrediction", produces = "application/json", consumes = "application/json", notes = "Inserts a new rating entry in the database")
	@RequestMapping(method = RequestMethod.GET, path = "/api/predictor/{userid}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ReportDAO getPrediction(@PathVariable("userid") String userid) {
		LOGGER.info("Getting prediction report: {} ", userid);
		ReportDAO report = null;
		try {
			report = PredictorUtils.fetchPredictions(userid,5, predictorURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return report;
		}

}
