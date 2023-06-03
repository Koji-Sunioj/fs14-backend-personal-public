package com.rest_api.fs14backend.album.dto;
import com.rest_api.fs14backend.genre.Genre;

import java.util.List;
import java.util.UUID;

/*
public record AlbumDTO(Integer released, String title, Double price,
                       String description, Integer stock, UUID artistId, List<UUID> genre) {
}
*/

public interface AlbumDTO {
   /* Integer getReleased();
    String getTitle();
    Double getPrice();
    String getDescription();
    Integer getStock();
    UUID getArtistId();
    List<UUID> getGenres();*/

    UUID artistId();

    String title();

    Integer released();

    Double price();

    String description();

    Integer stock();

    UUID[] genre();
}
