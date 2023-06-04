package com.rest_api.fs14backend.album;

import com.rest_api.fs14backend.album.dto.AlbumDTO;
import com.rest_api.fs14backend.artist.ArtistService;
import com.rest_api.fs14backend.genre.Genre;
import com.rest_api.fs14backend.genre.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rest_api.fs14backend.artist.Artist;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AlbumService {
    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    GenreService genreService;

    @Autowired
    ArtistService artistService;

    public Album getAlbum(UUID albumId)
    {
        return albumRepository.findById(albumId).orElse(null);
    }

    public List<Album> getAlbums(){
        return albumRepository.findAll();
    }

    public void removeAlbum(UUID albumId)
    {
        albumRepository.deleteById(albumId);
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
        ArrayList<Genre> genres = new ArrayList<Genre>();
        for(UUID o: newAlbum.genre())
        {
            Genre foundGenre = genreService.getGenre(o);
            genres.add(foundGenre);
        }
        createdAlbum.setGenre(genres);
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
        return albumRepository.save(existingAlbum);
    }

}
