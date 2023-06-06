package com.rest_api.fs14backend.album;

import com.rest_api.fs14backend.album.dto.AlbumDTO;
import com.rest_api.fs14backend.album.dto.AlbumGetOneDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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
        AlbumGetOneDTO existingAlbum = albumService.getAlbum(albumId);
        response.put("album",existingAlbum);
        return response;
    }

    @PatchMapping("{albumId}")
    public  HashMap<String,Object> updateAlbum(@PathVariable UUID albumId,@RequestBody  AlbumDTO patchAlbum)
    {
        HashMap<String,Object> response = new HashMap<>();
        Album updatedAlbum = albumService.updateAlbum(patchAlbum, albumId);
        response.put("album",updatedAlbum);
        response.put("message",String.format("successfully updated album %s",albumId));
        return  response;
    }

    @DeleteMapping("{albumId}")
    public HashMap<String,String> deleteAlbum(@PathVariable UUID albumId)
    {
        albumService.removeAlbum(albumId);
        HashMap<String,String> response = new HashMap<String,String>();
        response.put("message",String.format("album %s successfully deleted",albumId));
        return response;
    }

}
