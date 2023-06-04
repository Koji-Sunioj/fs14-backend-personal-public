package com.rest_api.fs14backend.genre;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rest_api.fs14backend.album.Album;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Genre {

    @Id
    @GeneratedValue
    @UuidGenerator
    @JsonIgnore
    @Column(name="genre_id")
    private UUID genreId;

    @Column(name="genre",length=100)
    private String genre;

    @ManyToMany(mappedBy = "genre")
    List<Album> albums;

    @JsonIgnore
    @Transient
    private Integer genres;

    @JsonIgnore
    @Transient
    private String[] artists;
}
