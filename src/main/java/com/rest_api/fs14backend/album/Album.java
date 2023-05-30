package com.rest_api.fs14backend.album;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rest_api.fs14backend.artist.Artist;
import com.rest_api.fs14backend.order_bridge.OrderQuantity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "album")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name="album_id")
    private UUID albumId;

    /*@OneToMany(mappedBy = "album")
    Set<OrderQuantity> albums;*/

    @ManyToOne
    @JoinColumn(name="artist_id", nullable=false)
    @JsonIgnore
    private Artist artist;

    @Column(name="title",length=100)
    private String title;

    @Column(name="price")
    private Double price;

    @JsonIgnore
    @Column(name="description",length=800)
    private String description;

    @Column(name="stock")
    private Integer stock;

    @Column(name="released")
    private Integer released;

    @Column(name="tags",length=50)
    private String[] tags;

    /*public String getArtistName() {
        return this.artist.getName();
    }*/
}
