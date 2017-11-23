package com.redhat.analytics.jiminy.htmlserver.controller;


import com.redhat.analytics.jiminy.htmlserver.model.ReportDAO;
import com.redhat.analytics.jiminy.htmlserver.model.UserDAO;
import com.redhat.analytics.jiminy.htmlserver.service.MockPGReportService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}

