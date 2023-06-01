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

    /*@Query(value="SELECT artist.artist_id as artistId,artist.name,count(distinct(album.album_id)) as albums " +
            "from artist join album on album.artist_id = artist.artist_id group by artistId,artist.name",
            nativeQuery = true)*/
    @Query(value="select " +
            "artist.name,artist.artist_id as artistId,count(distinct(album.album_id)) as albums,array_agg(genre) as genres " +
            "from artist " +
            "join album on album.artist_id = artist.artist_id " +
            "join album_genre on album.album_id = album_genre.album_album_id " +
            "join genre on genre.genre_id = album_genre.genre_genre_id " +
            "group by artist.name,artistId",
            nativeQuery = true)
    List<ArtistDTO> findByPublishedNative();
}
