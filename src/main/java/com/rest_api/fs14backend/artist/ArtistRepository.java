package com.rest_api.fs14backend.artist;

import com.rest_api.fs14backend.artist.dto.ArtistDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ArtistRepository  extends JpaRepository<Artist, UUID> {

    List<ArtistDTO> findBy();

    @Query(value="SELECT artist_id,name from artist",
            nativeQuery = true)
    List<ArtistDTO> findByPublishedNative();
}
