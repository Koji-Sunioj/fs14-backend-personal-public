package com.rest_api.fs14backend.artist;

import com.rest_api.fs14backend.artist.dto.ArtistGetManyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ArtistService {
    @Autowired ArtistRepository artistRepository;
    public List<ArtistGetManyDTO> getArtists(){
        return artistRepository.findAllWithCount();
    }
    public void removeArtist(UUID artistId) { artistRepository.deleteById(artistId);}
    public Artist findArtist(UUID artistId)
    {
        return artistRepository.findById(artistId).orElse(null);
    }
    public Artist createArtist(Artist newArtist)
    {
        return artistRepository.save(newArtist);
    }
}
