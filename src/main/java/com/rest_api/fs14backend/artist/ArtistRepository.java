package com.rest_api.fs14backend.artist;

import com.rest_api.fs14backend.artist.dto.ArtistGetManyDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ArtistRepository  extends JpaRepository<Artist, UUID> {

    @Query(value="select artist.name,artist.artist_id as artistId," +
            "count(distinct(album.album_id)) as albums, " +
            "coalesce(json_agg(json_build_object('genreId',genre.genre_id,'genreName',genre.genre)) " +
            "filter (where genre.genre_id is not null),'[]') as genres " +
            "from artist " +
            "left join album on album.artist_id = artist.artist_id " +
            "left join album_genre on album.album_id = album_genre.album_album_id " +
            "left join genre on genre.genre_id = album_genre.genre_genre_id " +
            "group by artist.name,artistId",
            nativeQuery = true)
    List<ArtistGetManyDTO> findAllWithCount();
}
