package com.zingmp3.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zingmp3.model.*;
import com.zingmp3.service.playlist.PlayListLikeService;
import com.zingmp3.service.playlist.PlaylistService;
import com.zingmp3.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class PlayListLikeController {

    @Autowired
    private PlayListLikeService playListLikeService;

    @Autowired
    private PlaylistService playlistService;

    @Autowired
    private UserService userService;

    @GetMapping("api/playlistService")
    public ResponseEntity<List<PlayListLike>> getAll() {
        List<PlayListLike> playListLikes = playListLikeService.findAll();
        return new ResponseEntity<>(playListLikes, HttpStatus.OK);
    }

    @GetMapping("api/playlist-like/{id}")
    public ResponseEntity<Iterable<PlayListLike>> findByPlayList(@PathVariable("id") long playList_id) {
        PlayList playList = playlistService.findById(playList_id);
        Iterable<PlayListLike> playListLikes = playListLikeService.findByPlayList(playList);
        System.out.println("PlaylistLike: " + playListLikes);
        return new ResponseEntity<>(playListLikes, HttpStatus.OK);
    }

    @PostMapping("api/playlist-like")
    public ResponseEntity<PlayListLike> addLikes(@RequestParam("playlist") String playList_form,
                                          @RequestParam("username") String username) throws JsonProcessingException {
        PlayListFormID playListFormID = new ObjectMapper().readValue(playList_form, PlayListFormID.class);
        PlayList playList = playlistService.findById(playListFormID.getId());
        Optional<User> user = userService.findByUsername(username);
        PlayListLike playListLike = new PlayListLike();
        playListLike.setPlayList(playList);
        playListLike.setUser(user.get());
        playlistService.save(playList);
        return new ResponseEntity<>(playListLike, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("api/playlist-like/{id}")
    public ResponseEntity<Void> deleteLike(@PathVariable("id") long id){
        playListLikeService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
