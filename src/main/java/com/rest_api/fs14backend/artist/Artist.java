package com.rest_api.fs14backend.artist;

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
    private UUID artistId;

    /*@JsonIgnore*/
    //cannot add join here because it's already defined in other class
    /*@JoinColumn(name="artist_id", nullable=false)*/
    @OneToMany(mappedBy="artist",cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Album> albums = new ArrayList<>();

    @Column(name="name",length=50,unique=true)
    private String name;
}
