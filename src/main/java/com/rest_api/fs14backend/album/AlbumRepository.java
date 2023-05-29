package com.rest_api.fs14backend.album;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rest_api.fs14backend.artist.Artist;
import lombok.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;

@Repository
public interface AlbumRepository extends JpaRepository<Album,UUID> {
    List<AlbumWODTO> findBy();
    List<Album> findByArtistArtistId(UUID artistID);
}


