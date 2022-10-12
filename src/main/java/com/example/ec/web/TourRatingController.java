package com.example.ec.web;

import com.example.ec.domain.*;
import com.example.ec.repo.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.*;

/**
 * Tour Rating Controller
 *
 */
@RestController
@RequestMapping(path = "/tours/{tourId}/ratings")
public class TourRatingController {
  // auto wire all required objects here..
    /**
     * Create a Tour Rating.
     *
     * @param tourId
     * @param ratingDto
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createTourRating(@PathVariable(value = "tourId") int tourId, @RequestBody @Validated RatingDto ratingDto) {
       
    }

    /**
     * Lookup a the Ratings for a tour.
     *
     * @param tourId
     * @param pageable
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Page<RatingDto> getAllRatingsForTour(@PathVariable(value = "tourId") int tourId, Pageable pageable) {
        return null;
    }

    /**
     * Calculate the average Score of a Tour.
     *
     * @param tourId
     * @return Tuple of "average" and the average value.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/average")
    public AbstractMap.SimpleEntry<String, Double> getAverage(@PathVariable(value = "tourId") int tourId) {

        return null;
    }

    /**
     * Update score and comment of a Tour Rating
     *
     * @param tourId
     * @param ratingDto
     * @return The modified Rating DTO.
     */
    @RequestMapping(method = RequestMethod.PUT)
    public RatingDto updateWithPut(@PathVariable(value = "tourId") int tourId, @RequestBody @Validated RatingDto ratingDto) {
        return  null;
    }
    /**
     * Update score or comment of a Tour Rating
     *
     * @param tourId
     * @param ratingDto
     * @return The modified Rating DTO.
     */
    @RequestMapping(method = RequestMethod.PATCH)
    public RatingDto updateWithPatch(@PathVariable(value = "tourId") int tourId, @RequestBody @Validated RatingDto ratingDto) {
       return null;
    }

    /**
     * Delete a Rating of a tour made by a customer
     *
     * @param tourId
     * @param customerId
     */
    @RequestMapping(method = RequestMethod.DELETE, path = "/{customerId}")
    public void delete(@PathVariable(value = "tourId") int tourId, @PathVariable(value = "customerId") int customerId) {
      
    }

    /**
     * Convert the TourRating entity to a RatingDto
     *
     * @param tourRating
     * @return RatingDto
     */
    private RatingDto toDto(TourRating tourRating) {
        return null;
    }

    /**
     * Verify and return the TourRating for a particular tourId and Customer
     * @param tourId
     * @param customerId
     * @return the found TourRating
     * @throws NoSuchElementException if no TourRating found
     */
    private TourRating verifyTourRating(int tourId, int customerId) throws NoSuchElementException {

        return null;
    }

    /**
     * Verify and return the Tour given a tourId.
     *
     * @param tourId
     * @return the found Tour
     * @throws NoSuchElementException if no Tour found.
     */
    private Tour verifyTour(int tourId) throws NoSuchElementException {
        return null;
    }

    /**
     * Exception handler if NoSuchElementException is thrown in this Controller
     *
     * @param ex
     * @return Error message String.
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex) {
        return ex.getMessage();
    }
	

}
