package com.rest_api.fs14backend.genre.dto;

import java.util.UUID;

public interface GenreGetManyDTO {

    String getGenre();

    UUID getGenreId();

    Integer getAlbums();


    String[] getArtists();
}
