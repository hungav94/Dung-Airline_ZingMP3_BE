package com.zingmp3.controller;

import com.zingmp3.model.Song;
import com.zingmp3.service.ServiceSong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RestController
public class ControllerSong {
    @Autowired
    private ServiceSong serviceSong;
    @GetMapping("api/song")
    public ResponseEntity<Iterable<Song>> getListSong() {
        Iterable<Song> listSong = serviceSong.findAll();
        return new ResponseEntity<>(listSong, HttpStatus.OK);
    }

    @PostMapping("api/song")
    public ResponseEntity<Void> createNewSong(@RequestBody Song song) {
        serviceSong.save(song);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("api/song")
    public ResponseEntity<Song> updateSong(@RequestBody Song song) {
        serviceSong.save(song);
        return new ResponseEntity<>(song, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("api/song/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable long id) {
        serviceSong.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
