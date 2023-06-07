package com.rest_api.fs14backend.genre;

import com.rest_api.fs14backend.artist.dto.ArtistGetManyDTO;
import com.rest_api.fs14backend.genre.dto.GenreGetManyDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GenreRepository extends JpaRepository<Genre, UUID> {

    @Query(value="select genre.genre_id as genreId, genre.genre, "+
            "count(album_album_id) as albums, " +
            "array_agg(distinct artist.name) as artists " +
            "from genre " +
            "left join album_genre on genre.genre_id = album_genre.genre_genre_id " +
            "left join album on album.album_id = album_genre.album_album_id " +
            "left join artist on artist.artist_id = album.artist_id " +
            "group by genreId,genre.genre order by albums desc",
            nativeQuery = true)
    List<GenreGetManyDTO> findAllWithCount();
}
