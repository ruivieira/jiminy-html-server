package com.redhat.analytics.jiminy.htmlserver.controller;


import com.redhat.analytics.jiminy.htmlserver.model.RatingsDAO;
import com.redhat.analytics.jiminy.htmlserver.model.ReportDAO;
import com.redhat.analytics.jiminy.htmlserver.model.UserDAO;
import com.redhat.analytics.jiminy.htmlserver.service.MockPGReportService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import io.swagger.annotations.ApiOperation;

@RestController
public class MockController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MockController.class);

    @Autowired
    MockPGReportService service;

    @ApiOperation(value = "getAllRecommendations", produces="application/json",
            notes="Provides list of recommendations for movie recommender.")
    @RequestMapping(method = RequestMethod.GET, path="/api/mock/recommend")
    public ReportDAO getAllRecommendations() {
        LOGGER.info("get all ratings");
        return service.findAll();
    }

    @ApiOperation(value = "getAllUsers", produces="application/json",
            notes="Provides a list of users in the movie recommendation application")
    @RequestMapping(method = RequestMethod.GET, path = "/api/mock/users")
    public UserDAO getAllUsers() {
        LOGGER.info("get all ratings");
        return service.findAllUsers();
    }


    @ApiOperation(value = "createRating", produces="application/json", consumes = "application/json",
            notes="Inserts a new rating entry in the database")
    @RequestMapping(method = RequestMethod.POST, path="/api/mock/rating")
    @ResponseStatus(HttpStatus.CREATED)
    public RatingsDAO createRating(@RequestBody RatingsDAO rating) {
        LOGGER.info("create rating entry: {} ", rating);
        //TODO: Persist ratings to postgres
        return rating;
    }

    @ApiOperation(value = "getPrediction", produces="application/json", consumes = "application/json",
            notes="Inserts a new rating entry in the database")
    @RequestMapping(method = RequestMethod.GET, path="/api/mock/predictor/{userid}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ReportDAO getPrediction(@PathVariable("userid") String userid) {

        LOGGER.info("Getting prediction report: {} ",userid);
        //TODO: Get request from predictor service VIA http.
        return service.findAll();
    }

}

