package com.rest_api.fs14backend.album.mapper;

import com.rest_api.fs14backend.album.Album;
import com.rest_api.fs14backend.album.dto.AlbumWODTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper 
public interface AlbumMapper {

   /* AlbumMapper INSTANCE = Mappers.getMapper( AlbumMapper.class );*/

    @Mapping(source = "numberOfSeats", target = "seatCount")
    AlbumWODTO albumDTO(Album album);
}