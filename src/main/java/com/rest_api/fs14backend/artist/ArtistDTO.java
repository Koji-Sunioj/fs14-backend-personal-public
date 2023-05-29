package com.rest_api.fs14backend.artist;

import com.rest_api.fs14backend.album.Album;
import com.rest_api.fs14backend.album.AlbumRepository;
import com.rest_api.fs14backend.album.AlbumService;
import com.rest_api.fs14backend.album.AlbumWODTO;
import com.rest_api.fs14backend.artist.Artist;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;
import java.util.List;

@Data
public class ArtistDTO {


    private String name;
    private UUID artistId;
    private List<Album> albums;

    public ArtistDTO(UUID artistId, String name,List<Album> albums)
    {
        this.artistId = artistId;
        this.name = name;
        this.albums = albums;
        /*this.albums = albumService.findAlbumsByArtistId(artistId);*/
    }
}
