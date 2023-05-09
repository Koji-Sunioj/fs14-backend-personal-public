package com.rest_api.fs14backend.album;

import com.rest_api.fs14backend.artist.ArtistRepository;
import com.rest_api.fs14backend.artist.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rest_api.fs14backend.artist.Artist;

import java.util.List;
import java.util.UUID;

@Service
public class AlbumService {
    @Autowired
    AlbumRepository albumRepository;


    @Autowired
    ArtistService artistService;

    public Album getAlbum(UUID albumId)
    {
        return albumRepository.findById(albumId).orElse(null);
    }

    public List<AlbumWODTO> getAlbums(){
        return albumRepository.findBy();
    }



    public Album createAlbum(AlbumDTO newAlbum)
    {
        Artist existingArtist = artistService.findArtist(newAlbum.artistId());
        Album createdAlbum = new Album();
        createdAlbum.setTitle(newAlbum.title());
        createdAlbum.setPrice(newAlbum.price());
        createdAlbum.setDescription(newAlbum.description());
        createdAlbum.setStock(newAlbum.stock());
        createdAlbum.setTags(newAlbum.tags());
        createdAlbum.setArtist(existingArtist);
        return albumRepository.save(createdAlbum);
    }
}
