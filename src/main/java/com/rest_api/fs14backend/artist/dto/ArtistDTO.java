package com.rest_api.fs14backend.artist.dto;

import com.rest_api.fs14backend.album.Album;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class ArtistDTO {

    private String name;
    private UUID artistId;

    public ArtistDTO(UUID artistId, String name)
    {

        this.artistId = artistId;
        this.name = name;

    }
}
