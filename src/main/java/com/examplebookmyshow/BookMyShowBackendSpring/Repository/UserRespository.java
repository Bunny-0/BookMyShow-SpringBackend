package com.examplebookmyshow.BookMyShowBackendSpring.Repository;

import com.examplebookmyshow.BookMyShowBackendSpring.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<UserEntity,Integer> {
}
