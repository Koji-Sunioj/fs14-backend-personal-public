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
    @Column(name="genre_id")
    private UUID genreId;

    @Column(name="genre",length=100)
    private String genre;

    /*@ManyToMany*/
    /*@JoinTable(
            name = "album_genre",
            joinColumns = @JoinColumn(name = "genre_genre_id"),
            inverseJoinColumns = @JoinColumn(name = "album_album_id"))*/
    @JsonIgnore
    @ManyToMany(mappedBy = "genre")
    List<Album> albums;
}
