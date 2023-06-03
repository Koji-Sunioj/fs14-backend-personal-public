package com.rest_api.fs14backend.artist.dto;

import com.rest_api.fs14backend.album.Album;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

//can't do this! to many
/*
public record ArtistGetOneDTO(String name, List<Album> albums) {
}

*/

public interface ArtistGetOneDTO {

    List<Album> getAlbums();
    String getName();
    /*UUID getArtistId();
    Integer getAlbums();
    String[] getGenres();*/
}
