package com.rest_api.fs14backend.artist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rest_api.fs14backend.album.Album;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.*;

@Entity
@Table(name = "artist")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Artist {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name="artist_id")
    /*@JsonIgnore*/
    private UUID artistId;

    @JsonIgnore
    @OneToMany(mappedBy="artist",cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Album> albums;

    @Column(name="name",length=50,unique=true)
    private String name;

    @JsonIgnore
    @Transient
    private String[] genres;
}
