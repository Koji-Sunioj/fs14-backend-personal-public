package com.rest_api.fs14backend.artist.dto;

import com.rest_api.fs14backend.album.Album;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//can't do this! to many
@Data
public class ArtistGetOneDTO {

    private String name;
    private List<Album> albums;

    public ArtistGetOneDTO(String name,List<Album> albums)
    {
        this.name = name;
        this.albums = getAlbums();
    }
}
