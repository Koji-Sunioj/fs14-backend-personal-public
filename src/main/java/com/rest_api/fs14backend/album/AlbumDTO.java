package com.rest_api.fs14backend.album;
import java.util.UUID;

public record AlbumDTO(String title,Double price,String description,Integer stock,String[] tags,UUID artistId) {
}
