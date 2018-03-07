package io.radanalytics.jiminy;

import io.radanalytics.jiminy.model.ProductDAO;
import io.radanalytics.jiminy.model.ProductType;
import io.radanalytics.jiminy.model.RatingsDAO;
import io.radanalytics.jiminy.model.ReportDAO;
import io.radanalytics.jiminy.service.ProductService;
import io.radanalytics.jiminy.service.RatingService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * RatingsController<br>
 * 
 * Spring controller which serves requests for CRUD operations against the ratings database.
 * In this controller there is a method that will proxy the predictor when users provide a userid
 * and it will provide the top 5 recommended products. To get more than 5 predictions change the
 * NUM_PREDICTIONS constant.
 * 
 * @author Zak Hassan <zhassan@redhat.com>
 */
@RestController
@RequestMapping()
public class RatingsController {

	private static final int NUM_PREDICTIONS = 5;

	private static final Logger LOGGER = LoggerFactory.getLogger(RatingsController.class);

	@Value("${openshift.config.predictor.url}")
	String predictorURL;

	@Autowired
	RatingService ratingService;

	@Autowired
    ProductService productService;

	@ApiOperation(value = "getAllRatings", produces = "application/json", notes = "Querythe database to fetch full list of ratings from the postgres db")
	@RequestMapping(method = RequestMethod.GET, path = "/api/ratings")
	public List<RatingsDAO> getAllRatings() {
		LOGGER.info("get all ratings");
		return ratingService.findAll();
	}

	@ApiOperation(value = "getRatingById", produces = "application/json", notes = "Query the database for rating entry with the id provided in the url path")
	@RequestMapping(method = RequestMethod.GET, path = "/api/ratings/{id}")
	public RatingsDAO getOneRating(@PathVariable("id") Integer id) {
		LOGGER.info("find rating by id: {}", id);
		return ratingService.findById(id);
	}

	@ApiOperation(value = "createRating", produces = "application/json", consumes = "application/json", notes = "Inserts a new rating entry in the database")
	@RequestMapping(method = RequestMethod.POST, path = "/api/ratings")
	@ResponseStatus(HttpStatus.CREATED)
	public RatingsDAO createRating(@RequestBody @Valid RatingsDAO rating) {
		LOGGER.info("create rating entry: {} ", rating);
		return ratingService.create(rating);
	}

	@ApiOperation(value = "updateRatingById", produces = "application/json", notes = "Update rating entry with the id provided in the url")
	@RequestMapping(  method = RequestMethod.PUT, path = "/api/ratings/{id}")
	public RatingsDAO updateRating(@RequestBody @Valid RatingsDAO rating) {
		LOGGER.info("update rating entry: {}", rating);
		return ratingService.update(rating);
	}

	@ApiOperation(value = "deleteRatingById", produces = "application/json", notes = "Delete rating from database with the id provided in the url")
	@RequestMapping(method = RequestMethod.DELETE, path = "/api/ratings/{id}")
	public RatingsDAO deleteRating(@PathVariable("id") Integer id) {
		LOGGER.info("delete rating entry with id: {}", id);
		return ratingService.delete(id);
	}

	@ApiOperation(value = "getPrediction", produces = "application/json", consumes = "application/json", notes = "Inserts a new rating entry in the database")
	@RequestMapping(method = RequestMethod.GET, path = "/api/predictor/{userid}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ReportDAO getPrediction(@PathVariable("userid") String userid) {
		LOGGER.info("Getting prediction report: {} ", userid);
		ReportDAO report = null;
		try {
			report = PredictorUtils.fetchPredictions(userid,NUM_PREDICTIONS, predictorURL);
			final List<ProductType> dataset = report.getDataSet();

			List<Long> ids = dataset.stream().map(ProductType::getId).collect(Collectors.toList());

            Map<Long, String> descriptions = productService.findAllById(ids).stream().collect(Collectors.toMap(ProductDAO::getId, ProductDAO::getDescriptions));

            for (ProductType pt : dataset) {
                pt.setDescription(descriptions.get(pt.getId()));
            }

		} catch (Exception e) {
			e.printStackTrace();
		}
		return report;
		}

}
