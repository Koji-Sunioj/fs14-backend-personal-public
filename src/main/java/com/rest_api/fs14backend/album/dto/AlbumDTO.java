package com.rest_api.fs14backend.album.dto;
import java.util.UUID;

public record AlbumDTO(Integer released, String title,Double price,String description,Integer stock,String[] tags,UUID artistId) {
}
