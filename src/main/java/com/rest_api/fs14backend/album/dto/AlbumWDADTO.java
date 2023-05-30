package com.rest_api.fs14backend.album.dto;

import com.rest_api.fs14backend.artist.Artist;
import lombok.Data;

import java.util.UUID;

@Data
public class AlbumWDADTO {

    private String title;
    private String name;
    private String description;
    private Integer released;
    private Integer stock;
    private Double price;
    private String[] tags;
    private UUID albumId;

    public AlbumWDADTO(UUID albumId, String description, Integer released, String title, Artist artist, Integer stock, Double price, String[] tags)
    {
        this.albumId = albumId;
        this.title = title;
        this.description = description;
        this.released = released;
        this.name = artist.getName();
        this.stock = stock;
        this.price = price;
        this.tags = tags;
    }
}
