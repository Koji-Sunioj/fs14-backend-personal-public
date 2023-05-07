package com.rest_api.fs14backend.artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping("/")
    public List<Artist> getAllArtists()
    {
        return artistService.getArtists();
    }

    @PostMapping(value="/",consumes = {"application/json"})
    public HashMap<String,Object> createArtist(@RequestBody Artist newArtist)
    {
        System.out.println(newArtist.getName());
        Artist createdArtist = artistService.createArtist(newArtist);
        HashMap<String,Object> response = new HashMap<String,Object>();
        response.put("message",String.format("successfull created artist %s",newArtist.getName()));
        response.put("artist",createdArtist);
        return response;
    }


}
