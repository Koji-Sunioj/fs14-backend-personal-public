package com.rest_api.fs14backend.album.dto;

import java.util.UUID;

public class AlbumGenre {
    public String genreName;

    public UUID genreId;

    public void setGenreName(String inputGenre) {
        this.genreName = inputGenre;
    }

    public void setGenreId(UUID inputId)
    {
        this.genreId = inputId;
    }

}
