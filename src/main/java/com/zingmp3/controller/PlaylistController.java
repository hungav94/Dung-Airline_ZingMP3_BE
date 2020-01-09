package com.zingmp3.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zingmp3.model.PlayList;
import com.zingmp3.model.PlayListForm;
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
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class PlaylistController {
    @Autowired
    private Environment evn;
    @Autowired
    private IPlaylistService playlistService;

    @GetMapping("api/playlist")
    public ResponseEntity<Iterable<PlayList>> getAllPlayList() {
        Iterable<PlayList> playLists = playlistService.findAll();
        return new ResponseEntity<>(playLists, HttpStatus.OK);
    }

    @PostMapping("api/playlist")
    public ResponseEntity<PlayList> createNewPlaylist(@RequestParam String playList_form, @RequestParam("avatarPlaylist") Optional<MultipartFile> avatarPlaylist) throws IOException {
        PlayListForm playListForm = new ObjectMapper().readValue(playList_form, PlayListForm.class);
        PlayList playList = new PlayList();
        playList.setPlaylistName(playListForm.getPlaylistName());
        playList.setPlaylistDescription(playListForm.getPlaylistDescription());
        playList.setSongs(playListForm.getSongs());
        doUpload(avatarPlaylist, playList);
        playlistService.save(playList);
        return new ResponseEntity<>(playList, HttpStatus.CREATED);
    }

    @PutMapping("api/playlist")
    public ResponseEntity<PlayList> updateNewPlaylist(@RequestParam String playList_form, @RequestParam("avatarPlaylist") Optional<MultipartFile> avatarPlaylist) throws IOException {
        PlayListForm playListForm = new ObjectMapper().readValue(playList_form, PlayListForm.class);
        PlayList playList = playlistService.findById(playListForm.getId());

        playList.setId(playListForm.getId());
        playList.setPlaylistName(playListForm.getPlaylistName());
        playList.setPlaylistDescription(playListForm.getPlaylistDescription());
        playList.setSongs(playListForm.getSongs());
        doUpload(avatarPlaylist, playList);
        playlistService.save(playList);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
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
