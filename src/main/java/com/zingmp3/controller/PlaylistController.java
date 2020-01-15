package com.zingmp3.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zingmp3.model.PlayList;
import com.zingmp3.model.PlayListForm;
import com.zingmp3.model.Song;
import com.zingmp3.model.SongForm;
import com.zingmp3.service.IServiceSong;
import com.zingmp3.service.playlist.IPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class PlaylistController {
    @Autowired
    private Environment evn;
    @Autowired
    private IPlaylistService playlistService;

    @Autowired
    private IServiceSong serviceSong;

    @GetMapping("api/playlist")
    public ResponseEntity<Iterable<PlayList>> getAllPlayList() {
        Iterable<PlayList> playLists = playlistService.findAll();
        return new ResponseEntity<>(playLists, HttpStatus.OK);
    }

    @GetMapping("api/playlist/{id}")
    public ResponseEntity<PlayList> findById(@PathVariable long id) {
        PlayList playList = playlistService.findById(id);
        System.out.println("playlist: " + playList);
        return new ResponseEntity<>(playList, HttpStatus.OK);
    }

    @PostMapping("api/playlist")
    public ResponseEntity<PlayList> createNewPlaylist(@RequestParam("playlist") String playList_form, @RequestParam("avatar") Optional<MultipartFile> avatarPlaylist) throws IOException {
        PlayListForm playListForm = new ObjectMapper().readValue(playList_form, PlayListForm.class);
        System.out.println("playList_form: " + playList_form);
        PlayList playList = new PlayList();
        playList.setPlaylistName(playListForm.getPlaylistName());
        playList.setPlaylistDescription(playListForm.getPlaylistDescription());
//        playList.setSongs(songs);
        doUpload(avatarPlaylist, playList);
        playlistService.save(playList);
        return new ResponseEntity<>(playList, HttpStatus.CREATED);
    }

    @PutMapping("api/playlist")
    public ResponseEntity<PlayList> updateNewPlaylist(@RequestParam("playlist") String playList_form, @RequestParam("avatarPlaylist") Optional<MultipartFile> avatarPlaylist) throws IOException {
        PlayListForm playListForm = new ObjectMapper().readValue(playList_form, PlayListForm.class);
        PlayList playList = playlistService.findById(playListForm.getId());
        List<Song> songs = serviceSong.findAllById(playListForm.getSongs());

        playList.setId(playListForm.getId());
        playList.setPlaylistName(playListForm.getPlaylistName());
        playList.setPlaylistDescription(playListForm.getPlaylistDescription());
        playList.setSongs(songs);
        doUpload(avatarPlaylist, playList);
        playlistService.save(playList);
        return new ResponseEntity<>(playList, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("api/playlist/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable long id) {
        playlistService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void doUpload(Optional<MultipartFile> avatarPlaylist, PlayList playList) throws IOException {
        if (avatarPlaylist.isPresent()) {
            String fileUploadAvatarPlaylist = evn.getProperty("uploadPath").toString();
            String fileNameAvatarPlaylist = avatarPlaylist.get().getOriginalFilename();
            if (!fileNameAvatarPlaylist.equals("")) {
                FileCopyUtils.copy(avatarPlaylist.get().getBytes(), new File(fileUploadAvatarPlaylist + fileNameAvatarPlaylist));
                playList.setAvatarPlaylist(fileNameAvatarPlaylist);
            }
        }
    }
}
