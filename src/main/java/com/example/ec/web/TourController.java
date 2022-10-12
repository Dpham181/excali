package com.example.ec.web;

import com.example.ec.domain.*;
import com.example.ec.repo.*;
import com.example.ec.service.TourPackageService;
import com.example.ec.service.TourService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.*;

/**
 * Tour Controller
 *
 */
@RestController
@RequestMapping(path = "/tours")
public class TourController {
  // auto wire all required objects here..
	  @Autowired
      TourPackageService TourPackageService;
      @Autowired
      TourService   TourService;

	// design and implement all end points, update service,repo and entity classes if required.
	
	/*
     * Lookup up for a Tour for give id
     */
    @RequestMapping(path ="/{id}" , method = RequestMethod.GET)
	// design end point that returns a tour objects given id...
    public Tour getTour(@Valid @PathVariable int id ) {

        return TourService.getTour(id);
    }
	
	
	/*
     * Lookup up for list of Tour from db
     */
    @RequestMapping(value= "/list",method = RequestMethod.GET)
	// design end point that returns a tour objects given id...
    public List<Tour> getTour() {

        return TourService.getTours();
    }
	
	
	/*
     * Lookup List of Tours for given price range.
     */
   @RequestMapping(value="/price",method = RequestMethod.GET)
	// design end point that returns list of tour objects given price range...
    public List<Tour> getPriceTours(@RequestParam("start") int priceS,@RequestParam("end") int priceE) {

        return TourService.getPriceTours(priceS,priceE);
    }
	
	/*
     * Lookup List of Tours whose travel duration(which is integer value) is given in uri
     */
   @RequestMapping(value="/limit/{day}" , method = RequestMethod.GET)
	// design end point that returns list of tour objects whose travel duration is more than given days
    public List<Tour> getToursLimitDays(@PathVariable int day) {
        return TourService.getToursLimitDays(day);
    }
	


/*
     * Lookup List of Tours whose travel difficulty is difficult, for example: "difficulty": "Difficult",
     */
   @RequestMapping(value = "/level" , method = RequestMethod.GET)
    public List<Tour> getToursDifficulty() {
        return TourService.getToursDifficulty();
    }
}
