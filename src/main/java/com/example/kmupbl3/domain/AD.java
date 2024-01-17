package com.example.kmupbl3.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "ad")
@NoArgsConstructor
public class AD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "shortheading", length = 200, nullable = false)
    private String shortHeading;

    @Column(name = "category", length = 10, nullable = false)
    private String category;

    @Column(name = "start_exposure", nullable = false)
    private Timestamp start_exposure;

    @Column(name = "end_exposure", nullable = false)
    private Timestamp end_exposure;

    @Column(name = "count", nullable = false)
    private int count;

    @Column(name = "reg_date", nullable = false, updatable = false, columnDefinition = "TIMESTAMP")
    @CreationTimestamp
    private Timestamp reg_date;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "content", columnDefinition = "TEXT")  // Content URL
    private String content;

    public AD(String title, String shortHeading, String category, Timestamp start_exposure, Timestamp end_exposure, int count, String description) {
        this(title, shortHeading, category, start_exposure, end_exposure, count, description, null);
    }

    public AD(String title, String shortHeading, String category, Timestamp start_exposure, Timestamp end_exposure, int count, String description, String content) {
        this.title = title;
        this.shortHeading = shortHeading;
        this.category = category;
        this.start_exposure = start_exposure;
        this.end_exposure = end_exposure;
        this.count = count;
        this.description = description;
        this.content = content;
    }
}
