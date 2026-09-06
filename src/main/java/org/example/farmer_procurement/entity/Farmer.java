package org.example.farmer_procurement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "farmer")
@Getter
@Setter
@NoArgsConstructor
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private Long farmerId;

    @Column(nullable = false)
    private Long mobileNumber;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String preferredLanguage;
}