package com.rest_api.fs14backend.genre;

import com.rest_api.fs14backend.album.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class GenreService {
    @Autowired
    GenreRepository genreRepository;

    public void deleteGenre(UUID genreId) { genreRepository.deleteById(genreId);}
    public Genre getGenre(UUID genreId){
        return genreRepository.findById(genreId).orElse(null);
    }

    public List<Genre> getGenres(){
        return genreRepository.findAll();
    }

    public Genre createGenre(Genre newGenre)
    {
        return genreRepository.save(newGenre);
    }
}
