package com.example.ec.service;

import com.example.ec.domain.TourPackage;
import com.example.ec.repo.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Tour Package Service
 *
 */
@Service
public class TourPackageService {
    private TourPackageRepository tourPackageRepository;
    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    public TourPackage createTourPackage(String code, String name) {
        tourPackageRepository.save(new TourPackage(code,name));

       return new TourPackage(code,name);
    }
    public Iterable<TourPackage> lookup(){
        return null;
    }
    public long total() {
       return  tourPackageRepository.count();
    }
}

