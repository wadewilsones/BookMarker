package com.bookmark.models;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="bookmarks")
public class Bookmark {
    @Id
    @SequenceGenerator(name = "bm_id_seq_gen", sequenceName = "bm_id_seq")
    @GeneratedValue(generator = "bm_id_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String url;
    private Instant createdAt;
}
