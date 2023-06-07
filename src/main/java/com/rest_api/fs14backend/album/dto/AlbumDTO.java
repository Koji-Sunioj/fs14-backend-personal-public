package com.rest_api.fs14backend.album.dto;
import lombok.Data;

import java.util.UUID;

@Data
public class AlbumDTO {
    private UUID artistId;
    private String title;
    private Integer released;
    private Double price;
    private String description;
    private Integer stock;
    private UUID[] genre;

    public AlbumDTO(UUID artistId,String title,Integer released
    ,Double price,String description, Integer stock, UUID[] genre)

    {
        this.artistId = artistId;
        this.title = title;
        this.released = released;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.genre = genre;
    }

}
/*

public interface AlbumDTO {

    UUID artistId();

    String title();

    Integer released();

    Double price();

    String description();

    Integer stock();

    UUID[] genre();
}
*/
