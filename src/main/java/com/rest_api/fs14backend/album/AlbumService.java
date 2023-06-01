package com.rest_api.fs14backend.album;

import com.rest_api.fs14backend.album.dto.AlbumDTO;
import com.rest_api.fs14backend.album.dto.AlbumWDADTO;
import com.rest_api.fs14backend.album.dto.AlbumWODTO;
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

    /*public AlbumWDADTO getAlbum(UUID albumId)
    {
        return albumRepository.findByAlbumId(albumId);
    }*/

    /*public List<AlbumWODTO> getAlbums(){
        return albumRepository.findBy();
    }*/

    public List<Album> getAlbums(){
        return albumRepository.findAll();
    }

    public void removeAlbum(UUID albumId)
    {
        albumRepository.deleteById(albumId);
    }

    public List<Album> findAlbumsByArtistId(UUID artistId) {
        return albumRepository.findByArtistArtistId(artistId);
    }

    public Album createAlbum(AlbumDTO newAlbum)
    {
        Artist existingArtist = artistService.findArtist(newAlbum.artistId());
        Album createdAlbum = new Album();
        createdAlbum.setTitle(newAlbum.title());
        createdAlbum.setReleased(newAlbum.released());
        createdAlbum.setPrice(newAlbum.price());
        createdAlbum.setDescription(newAlbum.description());
        createdAlbum.setStock(newAlbum.stock());
        createdAlbum.setArtist(existingArtist);
        createdAlbum.setGenre(newAlbum.genre());
        return albumRepository.save(createdAlbum);
    }

    public Album updateAlbum(AlbumDTO patchAlbum,UUID albumId)
    {
        Artist existingArtist = artistService.findArtist(patchAlbum.artistId());
        Album existingAlbum = albumRepository.findById(albumId).orElse(null);
        existingAlbum.setTitle(patchAlbum.title());
        existingAlbum.setReleased(patchAlbum.released());
        existingAlbum.setPrice(patchAlbum.price());
        existingAlbum.setDescription(patchAlbum.description());
        existingAlbum.setStock(patchAlbum.stock());
        existingAlbum.setArtist(existingArtist);
        existingAlbum.setGenre(patchAlbum.genre());
        return albumRepository.save(existingAlbum);
    }

}
