package com.examplebookmyshow.BookMyShowBackendSpring.Repository;

import com.examplebookmyshow.BookMyShowBackendSpring.Model.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<TheaterEntity,Integer> {
}
