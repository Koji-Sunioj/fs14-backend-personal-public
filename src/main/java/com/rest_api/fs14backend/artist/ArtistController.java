package com.rest_api.fs14backend.artist;
import com.rest_api.fs14backend.album.Album;
import com.rest_api.fs14backend.album.AlbumService;
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
        List<Artist> artists = artistService.getArtists();
        response.put("artists",artists);
        System.out.println(artists.get(0).getName());
        return response;
    }

    @GetMapping("{artistId}")
    public ArtistDTO getArtist(@PathVariable UUID artistId) {
        Artist artist = artistService.findArtist(artistId);
        List<Album> albums = albumService.findAlbumsByArtistId(artistId);
        ArtistDTO withAlbums = new ArtistDTO(artist.getArtistId(),artist.getName(),albums);


        System.out.println(albums.get(0).getTitle());
        /*ArtistDTO artist = artistService.findArtistTest(artistId);*/
        return withAlbums;
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
