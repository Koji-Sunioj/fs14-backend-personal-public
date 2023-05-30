package com.rest_api.fs14backend.album;

import com.rest_api.fs14backend.album.dto.AlbumWDADTO;
import com.rest_api.fs14backend.album.dto.AlbumWODTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;

@Repository
public interface AlbumRepository extends JpaRepository<Album,UUID> {

    AlbumWDADTO findByAlbumId(UUID albumId);
    List<AlbumWODTO> findBy();
    List<Album> findByArtistArtistId(UUID artistID);


}


