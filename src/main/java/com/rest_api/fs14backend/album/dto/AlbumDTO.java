package com.rest_api.fs14backend.album.dto;
import java.util.UUID;

public interface AlbumDTO {

    UUID artistId();

    String title();

    Integer released();

    Double price();

    String description();

    Integer stock();

    UUID[] genre();
}
