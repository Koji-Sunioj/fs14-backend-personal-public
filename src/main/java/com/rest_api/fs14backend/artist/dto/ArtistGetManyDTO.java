
package com.rest_api.fs14backend.artist.dto;
import java.util.UUID;

public interface ArtistGetManyDTO {
    String getName();
    UUID getArtistId();
    Integer getAlbums();
    String[] getGenres();
}
