package com.rest_api.fs14backend.album;

import com.rest_api.fs14backend.album.dto.AlbumGetOneDTO;
import com.rest_api.fs14backend.artist.dto.ArtistGetManyDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;

@Repository
public interface AlbumRepository extends JpaRepository<Album,UUID> {
    @Query(value="select album.title, " +
            "json_build_object('artistId',artist.artist_id,'name',artist.name) as artist, " +
            "album.price, " +
            "album.stock, " +
            "album.released, " +
            "album.description, " +
            "json_agg(json_build_object('genreId',genre.genre_id,'genreName',genre.genre)) as genres " +
            "from album " +
            "join artist on artist.artist_id = album.artist_id " +
            "join album_genre on album.album_id = album_genre.album_album_id " +
            "join genre on genre.genre_id = album_genre.genre_genre_id " +
            "where album.album_id=:albumId " +
            "group by album.album_id,artist.artist_id;",
            nativeQuery = true)
    AlbumGetOneDTO findOneAlbum(@Param("albumId") UUID albumId);
}


