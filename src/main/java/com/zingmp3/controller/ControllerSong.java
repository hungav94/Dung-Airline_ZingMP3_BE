package com.zingmp3.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.zingmp3.model.Song;
import com.zingmp3.model.SongForm;
import com.zingmp3.service.ServiceSong;
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
@CrossOrigin("*")
@RestController
public class ControllerSong {
    @Autowired
    private ServiceSong serviceSong;

    @Autowired
    Environment env;

    @GetMapping("api/song")
    public ResponseEntity<Iterable<Song>> getListSong() {
        Iterable<Song> listSong = serviceSong.findAll();
        return new ResponseEntity<>(listSong, HttpStatus.OK);
    }


    @PostMapping("api/song")
    public ResponseEntity<Song> createNewSong(@RequestParam("song") String song_form,
                                              @RequestParam("avatar") Optional<MultipartFile> avatar,
                                              @RequestParam("fileMp3") Optional<MultipartFile> fileMp3) throws IOException {
        SongForm songForm = new ObjectMapper().readValue(song_form, SongForm.class);

        Song song = new Song();
        song.setName(songForm.getName());
        song.setDescription(songForm.getDescription());
        song.setDateUpLoad(songForm.getDateUpload());
        doUpload(avatar, fileMp3, song);
        serviceSong.save(song);
            return new ResponseEntity<>(song, HttpStatus.CREATED);

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

    private void doUpload(Optional<MultipartFile> fileAvatar, Optional<MultipartFile> fileMp3, Song song) throws IOException {
        if (fileAvatar.isPresent() && fileMp3.isPresent()) {
            String fileUploadFileAvatar = env.getProperty("uploadPath").toString();
            String fileUploadFileMp3 = env.getProperty("uploadPath").toString();
            String fileNameAvatar = fileAvatar.get().getOriginalFilename();
            String fileNameMp3 = fileMp3.get().getOriginalFilename();
            if (!fileNameAvatar.equals("")) {
                FileCopyUtils.copy(fileAvatar.get().getBytes(), new File(fileUploadFileAvatar + fileNameAvatar));
                song.setAvatar(fileNameAvatar);
            }
            if (!fileNameMp3.equals("")) {
                FileCopyUtils.copy(fileAvatar.get().getBytes(), new File(fileUploadFileMp3 + fileNameMp3));
                song.setFileMp3(fileNameMp3);
            }
        }
    }
}
