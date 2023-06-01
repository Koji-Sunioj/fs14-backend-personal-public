package com.rest_api.fs14backend.album.dto;

import com.rest_api.fs14backend.artist.Artist;
import lombok.Data;
import java.util.UUID;

@Data
public class AlbumWODTO {

    private String title;
    private String name;
    private Integer released;
    private Integer stock;
    private Double price;
    private UUID albumId;

    public AlbumWODTO(UUID albumId, Integer released,String title, Artist artist,Integer stock,Double price)
    {
        this.albumId = albumId;
        this.title = title;
        this.released = released;
        this.name = artist.getName();
        this.stock = stock;
        this.price = price;
    }
}
