package com.rest_api.fs14backend.genre;

import com.rest_api.fs14backend.album.Album;
import com.rest_api.fs14backend.album.dto.AlbumDTO;
import com.rest_api.fs14backend.album.dto.AlbumWDADTO;
import com.rest_api.fs14backend.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("genres")
public class GenreController {

    @Autowired
    GenreService genreService;

    @GetMapping("/")
    public HashMap<String,Object> getAllGenres()
    {
        HashMap<String,Object> response = new HashMap<String,Object>();
        List<Genre> genres = genreService.getGenres();
        response.put("genres",genres);
        return response;
    }

    @GetMapping("{genreId}")
    public HashMap<String,Object> getGenre(@PathVariable UUID genreId) {
        HashMap<String,Object> response = new HashMap<String,Object>();
        Genre existingGenre = genreService.getGenre(genreId);
        response.put("genre",existingGenre);
        return response;
    }

    @DeleteMapping("{genreId}")
    public HashMap<String,Object> removeGenre(@PathVariable UUID genreId) {
        HashMap<String,Object> response = new HashMap<String,Object>();
        genreService.deleteGenre(genreId);
        response.put("genre",String.format("successfully deleted genre %s",genreId));
        return response;
    }

    @PostMapping(value ="/",consumes ={"application/json"})
    public HashMap<String,Object> createGenre(@RequestBody Genre newGenre)
    {
        HashMap<String,Object> response = new HashMap<String,Object>();
        Genre createdGenre = genreService.createGenre(newGenre);
        response.put("message",String.format("successfully created genre: %s",createdGenre.getGenre()));
        response.put("genre",createdGenre);
        return response;
    }
}
