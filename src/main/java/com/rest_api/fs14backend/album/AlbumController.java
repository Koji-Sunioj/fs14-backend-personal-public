package com.rest_api.fs14backend.album;

import com.rest_api.fs14backend.artist.Artist;
import com.rest_api.fs14backend.artist.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.Optional;

@RestController
@RequestMapping("albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/")
    public HashMap<String,Object> getAlAlbums()
    {
        HashMap<String,Object> response = new HashMap<String,Object>();
        List<Album> albums = albumService.getAlbums();
        response.put("albums",albums);
        return response;
    }

    @PostMapping(value ="/",consumes ={"application/json"})
    public HashMap<String,Object> createAlbum(@RequestBody AlbumDTO requestAlbum)
    {
        HashMap<String,Object> response = new HashMap<String,Object>();
        Album createdAlbum = albumService.createAlbum(requestAlbum);
        response.put("message",String.format("successfully created album: %s",createdAlbum.getTitle()));
        response.put("album",createdAlbum);
        return response;
    }

    @GetMapping("{albumId}")
    public HashMap<String,Object> getAlbum(@PathVariable UUID albumId) {
        HashMap<String,Object> response = new HashMap<String,Object>();
        Album existingAlbum = albumService.getAlbum(albumId);
        response.put("album",existingAlbum);
        return response;
    }

}
