package com.examplebookmyshow.BookMyShowBackendSpring.Repository;

import com.examplebookmyshow.BookMyShowBackendSpring.Model.TheaterSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterSeatsRepository extends JpaRepository<TheaterSeatsEntity,Integer> {
}
