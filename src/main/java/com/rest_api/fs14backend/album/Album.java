package com.rest_api.fs14backend.album;

import com.rest_api.fs14backend.artist.Artist;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "album")
@Data
@NoArgsConstructor
public class Album {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name="album_id")
    private UUID albumId;

    @ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.REMOVE})
    @JoinColumn(name="artist_id")
    private Artist artist;

    @Column(name="title",length=100)
    private String title;

    @Column(name="price")
    private Double price;

    @Column(name="description",length=800)
    private String description;

    @Column(name="stock")
    private Integer stock;

    @Column(name="tags",length=50)
    private String[] tags;

    public Album(String title,Double price,String description,Integer stock,String[] tags)
    {
        this.title = title;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.tags = tags;
    }
}
