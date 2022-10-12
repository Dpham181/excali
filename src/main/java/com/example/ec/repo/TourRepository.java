package com.example.ec.repo;

import com.example.ec.domain.Difficulty;
import com.example.ec.domain.Region;
import com.example.ec.domain.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.QueryHint;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Tour Repository Interface
 *
 */
public interface TourRepository extends PagingAndSortingRepository<Tour,Integer> {
   @Query(value = "Select * from Tour T where T.price between :start and :end", nativeQuery=true)
   List<Tour> tourPrices(@Param("start") Integer start, @Param("end") Integer end);

   @Query(value = "Select * from Tour T where CAST(Replace(Replace(T.duration,'day',''),'s','') as int) > :day", nativeQuery=true)
   List<Tour> tourduration(@Param("day") Integer day);
   @Query(value = "Select * from Tour T where T.difficulty=2", nativeQuery=true)
   List<Tour> getToursDifficulty();
}
