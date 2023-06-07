package com.rest_api.fs14backend.album;

import com.rest_api.fs14backend.album.dto.AlbumDTO;
import com.rest_api.fs14backend.album.dto.AlbumGetOneDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping()
    public HashMap<String,Object> getAlAlbums(@RequestParam(required = false) String sort,
                                              @RequestParam(required = false) String direction,
                                              @RequestParam(required = false) String page)
    {
        String[] fields = new String[] { "title", "price", "stock", "released","artist"};
        String[] directions = new String[] { "ascending", "descending"};
        String sortBy = sort != null && Arrays.asList(fields).contains(sort)
                ? sort : "price";
        String byDirection = direction != null  && Arrays.asList(directions).contains(direction)
                ? direction : "descending";
        Integer pageRquest = null;
        try{
            pageRquest = Integer.parseInt(page);
            /*pageRquest = pageRquest > 0 ? pageRquest : 1;*/
        }
        catch (Exception e)
        {
            pageRquest = 1;
        }
        Page<Album> albums = albumService.getAlbums(sortBy,byDirection,pageRquest);
        HashMap<String,Object> response = new HashMap<String,Object>();
        response.put("albums",albums.getContent());
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
