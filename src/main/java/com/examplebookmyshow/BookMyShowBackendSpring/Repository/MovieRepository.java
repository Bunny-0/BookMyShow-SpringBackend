package com.examplebookmyshow.BookMyShowBackendSpring.Repository;

import com.examplebookmyshow.BookMyShowBackendSpring.Model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {
}
