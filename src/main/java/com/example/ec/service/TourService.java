package com.example.ec.service;

import com.example.ec.domain.Difficulty;
import com.example.ec.domain.Region;
import com.example.ec.domain.Tour;
import com.example.ec.domain.TourPackage;
import com.example.ec.repo.TourPackageRepository;
import com.example.ec.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Tour  Service
 *
 */

@Service
public class TourService {
    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    /**
     * Create a new Tour Object and persist it to the Database.
     *
     * @param title
     * @param description
     * @param blurb
     * @param price
     * @param duration
     * @param bullets
     * @param keywords
     * @param tourPackageName
     * @param difficulty
     * @param region
     * @return Tour Entity
     */
    public Tour createTour(String title, String description, String blurb, Integer price,
                           String duration, String bullets,
                           String keywords, String tourPackageName, Difficulty difficulty, Region region ) {

        TourPackage tourPackage = null;
        for( TourPackage t : tourPackageRepository.findAll()){
             if(t.getName().equals(tourPackageName)){
                 tourPackage = t;
             }
         }
        Tour tour = new Tour(title,description,blurb,price,duration,bullets,keywords,tourPackage,difficulty,region);
        tourRepository.save(tour);
       return tour;
    }

    public Tour getTour(int id) {
        System.out.println(tourRepository.findById(id).get());
        return tourRepository.findById(id).get();
    }
    public List<Tour> getTours() {
        return (List<Tour>) tourRepository.findAll();
    }

    public List<Tour> getPriceTours(int start, int end) {

        return tourRepository.tourPrices(start,end);
    }

    public List<Tour> getToursLimitDays(int day) {
        return tourRepository.tourduration(day);
    }
    public  List<Tour> getToursDifficulty() {
        return tourRepository.getToursDifficulty();
    }
    /**
     * Calculate the number of Tours in the Database.
     *
     * @return the total.
     */
    public long total() {
       return  tourRepository.count();
    }

}

