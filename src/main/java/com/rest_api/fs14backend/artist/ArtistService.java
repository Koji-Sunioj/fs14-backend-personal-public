package com.rest_api.fs14backend.artist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

    @Autowired ArtistRepository artistRepository;

    public List<Artist> getArtists(){
        return artistRepository.findAll();
    }

    public Artist createArtist(Artist newArtist)
    {
        return artistRepository.save(newArtist);
    }
}
