package com.rest_api.fs14backend.album.dto;

import com.rest_api.fs14backend.artist.Artist;
import com.rest_api.fs14backend.genre.Genre;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumWDADTO {

    private String title;
    private String name;
    private String description;
    private Integer released;
    private Integer stock;
    private Double price;
    private UUID albumId;
    @ManyToMany
    private List<Genre> genre;

    public AlbumWDADTO(UUID albumId, String description,
                       Integer released, String title,
                       Artist artist, Integer stock, Double price, List<Genre> genre)
    {
        this.albumId = albumId;
        this.title = title;
        this.description = description;
        this.released = released;
        this.name = artist.getName();
        this.stock = stock;
        this.price = price;
        this.genre = genre; ;
    }
}
