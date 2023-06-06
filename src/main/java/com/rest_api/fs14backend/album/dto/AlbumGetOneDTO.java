package com.rest_api.fs14backend.album.dto;

import com.rest_api.fs14backend.album.Album;
import com.rest_api.fs14backend.artist.Artist;
import com.rest_api.fs14backend.genre.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


public interface AlbumGetOneDTO {
    String getTitle();
    LinkedHashMap getArtist();
    Integer getReleased();
    Double getPrice();
    Integer getStock();
    String getDescription();
    List<LinkedHashMap> getGenres();

}