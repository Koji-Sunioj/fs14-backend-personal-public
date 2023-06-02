package com.rest_api.fs14backend.album.dto;
import com.rest_api.fs14backend.genre.Genre;

import java.util.List;
import java.util.UUID;

public record AlbumDTO(Integer released, String title, Double price,
                       String description, Integer stock, UUID artistId, List<UUID> genre) {
}

