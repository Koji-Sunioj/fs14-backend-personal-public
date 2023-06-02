package com.rest_api.fs14backend.artist;

import com.rest_api.fs14backend.artist.dto.ArtistGetManyDTO;
import com.rest_api.fs14backend.artist.dto.ArtistGetOneDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ArtistService {

    @Autowired ArtistRepository artistRepository;

    /*public List<Artist> getArtists(){
        return artistRepository.findAll();
    }
*/
    public List<ArtistGetManyDTO> getArtists(){
        return artistRepository.findAllWithCount();
    }
    public void removeArtist(UUID artistId) { artistRepository.deleteById(artistId);}


    public ArtistGetOneDTO findOneArtist(UUID artistId)
    {
        return artistRepository.findByArtistId(artistId);
    }

    public Artist findArtist(UUID artistId)
    {
        return artistRepository.findById(artistId).orElse(null);
    }

  /*  public ArtistDTO findArtistTest(UUID artistId) {
        return artistRepository.findByArtistId(artistId);
    };*/

    public Artist createArtist(Artist newArtist)
    {
        return artistRepository.save(newArtist);
    }
}
