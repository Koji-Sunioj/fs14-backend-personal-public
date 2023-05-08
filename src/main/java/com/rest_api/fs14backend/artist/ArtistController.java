package com.rest_api.fs14backend.artist;
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

    @GetMapping("/")
    public HashMap<String,Object> getAllArtists()
    {
        HashMap<String,Object> response = new HashMap<String,Object>();
        List<Artist> artists = artistService.getArtists();
        response.put("artists",artists);
        System.out.println(artists.get(0).getName());
        return response;
    }

    @GetMapping("{artistId}")
    public Artist getArtist(@PathVariable UUID artistId) {
        Artist artist = artistService.findArtist(artistId);
        return artist;
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
