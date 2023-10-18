package com.examplebookmyshow.BookMyShowBackendSpring.Model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.examplebookmyshow.BookMyShowBackendSpring.Enum.TheaterType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "theaters")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheaterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "address",nullable = false)
    private String address;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowEntity> shows;

    TheaterType type;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TheaterSeatsEntity> seats = new ArrayList<>();
}
