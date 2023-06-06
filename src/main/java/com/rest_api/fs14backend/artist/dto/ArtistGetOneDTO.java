package com.rest_api.fs14backend.artist.dto;

import java.util.LinkedHashMap;
import java.util.List;

public interface ArtistGetOneDTO {
    String getName();
    List<LinkedHashMap> getAlbums();
}
