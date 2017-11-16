package com.redhat.analytics.jiminy.htmlserver.controller;

import com.redhat.analytics.jiminy.htmlserver.model.RatingsDAO;
import com.redhat.analytics.jiminy.htmlserver.service.RatingService;

import java.util.List;
import javax.validation.Valid;
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
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/ratings")
public class RatingsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RatingsController.class);

    private final RatingService service;

    @Autowired
    public RatingsController(RatingService service) {
        this.service = service;
    }

    @ApiOperation(value = "getAllRatings", produces="application/json",
            notes="Provides list of notifications that monitord is managing")
    @RequestMapping(method = RequestMethod.GET)
    public List<RatingsDAO> getAllRatings() {
        LOGGER.info("get all ratings");
        return service.findAll();
    }

    @ApiOperation(value = "getRatingById", produces="application/json",
            notes="Query the database for rating entry with the id provided in the url path")
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public RatingsDAO getOneRating(@PathVariable("id") String id) {
        LOGGER.info("find rating by id: {}",id);
        return service.findById(id);
    }

    @ApiOperation(value = "createRating", produces="application/json", consumes = "application/json",
            notes="Inserts a new rating entry in the database")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public RatingsDAO createRating(@RequestBody @Valid RatingsDAO rating) {
        LOGGER.info("create rating entry: {} ", rating);
        return service.create(rating);
    }

    @ApiOperation(value = "updateRatingById", produces="application/json",
            notes="Update rating entry with the id provided in the url")
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public RatingsDAO updateRating(@RequestBody @Valid RatingsDAO rating) {
        LOGGER.info("update rating entry: {}", rating);
        return service.update(rating);
    }

    @ApiOperation(value = "deleteRatingById", produces="application/json",
            notes="Delete rating from database with the id provided in the url")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public RatingsDAO deleteRating(@PathVariable("id") String id) {
        LOGGER.info("delete rating entry with id: {}", id);
        return service.delete(id);
    }
}
