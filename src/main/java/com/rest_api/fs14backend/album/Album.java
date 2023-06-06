package com.rest_api.fs14backend.album;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rest_api.fs14backend.album.dto.AlbumGenre;
import com.rest_api.fs14backend.artist.Artist;
import com.rest_api.fs14backend.genre.Genre;
import com.rest_api.fs14backend.order_bridge.OrderQuantity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
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

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "album_genre",
            joinColumns = @JoinColumn(name = "album_album_id")
            )
    List<Genre> genre;

    @ManyToOne
    @JoinColumn(name="artist_id", nullable=false)
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

    @Transient
    private ArrayList<AlbumGenre> genres = new ArrayList<AlbumGenre>();;

    public ArrayList<AlbumGenre> getGenres()
    {
        ArrayList<AlbumGenre> tags = new ArrayList<AlbumGenre>();
        for (Genre o: this.getGenre())
        {
            AlbumGenre albumGenre = new AlbumGenre();
            albumGenre.setGenreId(o.getGenreId());
            albumGenre.setGenreName(o.getGenre());
            tags.add(albumGenre);
        }

        return tags;
    }
}
