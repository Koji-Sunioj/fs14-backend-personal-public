package com.rest_api.fs14backend.artist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rest_api.fs14backend.album.Album;
import com.rest_api.fs14backend.album.AlbumDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
    private UUID artistId;

    //remove to get joined list
    @JsonIgnore
    @OneToMany(mappedBy="artist")
    private List<Album> albums = new ArrayList<>();

    @Column(name="name",length=50,unique=true)
    private String name;
}
