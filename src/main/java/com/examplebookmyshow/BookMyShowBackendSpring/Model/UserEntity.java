package com.examplebookmyshow.BookMyShowBackendSpring.Model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "mobile", nullable = false)
    private String mobileno;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) //bidirectional mapping
    private List<TicketEntity> ticketEntities;

}