package com.example.kmupbl3.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "AD")
@NoArgsConstructor
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "shortheading", length = 200, nullable = false)
    private String shortHeading;

    @Column(name = "startExposure", nullable = false)
    private Timestamp startExposure;

    @Column(name = "endExposure", nullable = false)
    private Timestamp endExposure;

    @Column(name = "count", nullable = false)
    private int count;

    @Column(name = "regDate", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp regDate;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public Ad(String title, String shortHeading, Timestamp startExposure, Timestamp endExposure, int count, String description) {
        this.title = title;
        this.shortHeading = shortHeading;
        this.startExposure = startExposure;
        this.endExposure = endExposure;
        this.count = count;
        this.description = description;
    }
}
