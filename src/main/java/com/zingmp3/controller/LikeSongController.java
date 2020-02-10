package com.zingmp3.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zingmp3.model.*;
import com.zingmp3.service.ServiceLikeSong;
import com.zingmp3.service.ServiceSong;
import com.zingmp3.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class LikeSongController {

    @Autowired
    private ServiceLikeSong serviceLikes;

    @Autowired
    private ServiceSong serviceSong;

    @Autowired
    private UserService userService;

    @GetMapping("api/likes")
    public ResponseEntity<List<LikeSong>> getAll() {
        List<LikeSong> likeSongList = serviceLikes.findAll();
        return new ResponseEntity<>(likeSongList, HttpStatus.OK);
    }

    @GetMapping("api/likes/{id}")
    public ResponseEntity<Iterable<LikeSong>> findBySong(@PathVariable("id") long song_id) {
        Song song = serviceSong.findById(song_id);
        Iterable<LikeSong> likesList = serviceLikes.findBySong(song);
        return new ResponseEntity<>(likesList, HttpStatus.OK);
    }

    @PostMapping("api/likes")
    public ResponseEntity<LikeSong> addLikes(@RequestParam("song") String song_form,
                                             @RequestParam("username") String username) throws JsonProcessingException {
        System.out.println("username: " + username);
        SongFormId songFormId = new ObjectMapper().readValue(song_form, SongFormId.class);
        Song song = serviceSong.findById(songFormId.getId());
        Optional<User> user = userService.findByUsername(username);
        System.out.println("user: " + user);
        LikeSong likeSong = new LikeSong();
        likeSong.setSong(song);
        likeSong.setUser(user.get());
        serviceLikes.save(likeSong);
        return new ResponseEntity<>(likeSong, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("api/likes/{id}")
    public ResponseEntity<Void> deleteLike(@PathVariable("id") long id){
        serviceLikes.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
