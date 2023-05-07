package com.rest_api.fs14backend.artist;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import java.util.UUID;
@Entity
@Table(name = "artist")
@Data
@NoArgsConstructor
public class Artist {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name="artist_id")
    private UUID artistID;

    @Column(name="name",length=50,unique=true)
    private String name;

    public Artist(String name)
    {
        this.name = name;
    }
}
