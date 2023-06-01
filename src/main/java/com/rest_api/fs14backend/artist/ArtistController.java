package com.rest_api.fs14backend.artist;
import com.rest_api.fs14backend.album.AlbumService;
import com.rest_api.fs14backend.artist.dto.ArtistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private AlbumService albumService;

    @GetMapping("/")
    public HashMap<String,Object> getAllArtists()
    {
        HashMap<String,Object> response = new HashMap<String,Object>();
        /*List<Artist> artists = artistService.getArtists();*/
        List<ArtistDTO> artists = artistService.getArtists();
        response.put("artists",artists);
        return response;
    }

    @GetMapping("{artistId}")
    public HashMap<String,Object> getArtist(@PathVariable UUID artistId) {
        HashMap<String,Object> response = new HashMap<String,Object>();
        Artist artist =artistService.findArtist(artistId);
        response.put("artist",artist);
        return response;
    }

    @DeleteMapping("{artistId}")
    public HashMap<String,String> deleteArtist(@PathVariable UUID artistId){
        artistService.removeArtist(artistId);
        HashMap<String,String> response = new HashMap<String,String>();
        response.put("message",String.format("artist %s successfully deleted",artistId));
        return response;
    }

    @PostMapping(value="/",consumes = {"application/json"})
    public HashMap<String,Object> createArtist(@RequestBody Artist newArtist)
    {
        Artist createdArtist = artistService.createArtist(newArtist);
        HashMap<String,Object> response = new HashMap<String,Object>();
        response.put("message",String.format("successfull created artist %s",newArtist.getName()));
        response.put("artist",createdArtist);
        return response;
    }


}
