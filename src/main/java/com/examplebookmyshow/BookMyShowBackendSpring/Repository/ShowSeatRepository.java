package com.examplebookmyshow.BookMyShowBackendSpring.Repository;

import com.examplebookmyshow.BookMyShowBackendSpring.Model.ShowSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatRepository extends JpaRepository<ShowSeatsEntity,Integer> {
}
