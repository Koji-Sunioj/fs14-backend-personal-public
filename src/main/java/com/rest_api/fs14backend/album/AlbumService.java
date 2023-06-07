package com.rest_api.fs14backend.album;

import com.rest_api.fs14backend.album.dto.AlbumDTO;
import com.rest_api.fs14backend.album.dto.AlbumGetOneDTO;
import com.rest_api.fs14backend.artist.ArtistService;
import com.rest_api.fs14backend.genre.Genre;
import com.rest_api.fs14backend.genre.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public AlbumGetOneDTO getAlbum(UUID albumId) { return albumRepository.findOneAlbum(albumId);};
    public Page<Album> getAlbums(String sortBy,String byDirection,Integer pageRequest)
    {
        Integer start = pageRequest -1;
        Sort.Direction sortParam = byDirection.contains("descending")
                ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable filterParams = PageRequest.of(start,5, Sort.by(sortParam,sortBy));
        Page<Album> albums =  albumRepository.findAll(filterParams);
        return albums;
    }
    public void removeAlbum(UUID albumId)
    {
        albumRepository.deleteById(albumId);
    }
    public Album createAlbum(AlbumDTO newAlbum)

    {
        Artist existingArtist = artistService.findArtist(newAlbum.getArtistId());
        Album createdAlbum = new Album();
        createdAlbum.setTitle(newAlbum.getTitle());
        createdAlbum.setReleased(newAlbum.getReleased());
        createdAlbum.setPrice(newAlbum.getPrice());
        createdAlbum.setDescription(newAlbum.getDescription());
        createdAlbum.setStock(newAlbum.getStock());
        createdAlbum.setArtist(existingArtist);
        ArrayList<Genre> genres = new ArrayList<Genre>();
        for(UUID o: newAlbum.getGenre())
        {
            Genre foundGenre = genreService.getGenre(o);
            genres.add(foundGenre);
        }
        createdAlbum.setGenre(genres);
        return albumRepository.save(createdAlbum);
    }
    public Album updateAlbum(AlbumDTO patchAlbum,UUID albumId)
    {

        Artist existingArtist = artistService.findArtist(patchAlbum.getArtistId());
        Album existingAlbum = albumRepository.findById(albumId).orElse(null);
        existingAlbum.setTitle(patchAlbum.getTitle());
        existingAlbum.setReleased(patchAlbum.getReleased());
        existingAlbum.setPrice(patchAlbum.getPrice());
        existingAlbum.setDescription(patchAlbum.getDescription());
        existingAlbum.setStock(patchAlbum.getStock());
        existingAlbum.setArtist(existingArtist);
        ArrayList<Genre> genres = new ArrayList<Genre>();
        for(UUID o: patchAlbum.getGenre())
        {
            Genre foundGenre = genreService.getGenre(o);
            genres.add(foundGenre);
        }
        existingAlbum.setGenre(genres);
        return albumRepository.save(existingAlbum);
    }

}
