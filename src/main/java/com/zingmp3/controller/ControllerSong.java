package com.zingmp3.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zingmp3.model.Song;
import com.zingmp3.model.SongForm;
import com.zingmp3.model.SongFormId;
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
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class ControllerSong {
    @Autowired
    private ServiceSong serviceSong;

    @Autowired
    Environment env;

    @GetMapping("api/song-search/{name}")
    public ResponseEntity<List<Song>> searchByNameSong(@PathVariable("name") String name){
        List<Song> songs;
        songs = serviceSong.findByName(name);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("api/song")
    public ResponseEntity<Iterable<Song>> getListSong() {
        Iterable<Song> listSong = serviceSong.findAll();
        return new ResponseEntity<>(listSong, HttpStatus.OK);
    }

    @GetMapping("api/song/{id}")
    public ResponseEntity<Song> findById(@PathVariable Long id) {
        Song song = serviceSong.findById(id);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @GetMapping("api/song-sort-desc")
    public ResponseEntity<List<Song>> getListByIdDesc(){
        List<Song> listSong = serviceSong.findAllByOrderByIdDesc();
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
        song.setDateUpLoad("" + new Date());
        doUpload(avatar, fileMp3, song);
        serviceSong.save(song);
        return new ResponseEntity<>(song, HttpStatus.CREATED);

    }

    @PutMapping("api/song")
    public ResponseEntity<Void> updateSong(@RequestParam("song") String song_form,
                                           @RequestParam("avatar") Optional<MultipartFile> avatar) throws IOException {
        System.out.println(song_form);
        SongFormId songFormId = new ObjectMapper().readValue(song_form, SongFormId.class);

        Song song = serviceSong.findById(songFormId.getId());
        song.setId(songFormId.getId());
        song.setName(songFormId.getName());
        song.setDescription(songFormId.getDescription());
        song.setDateUpLoad(songFormId.getDateUpload());
        doUploadAvatar(avatar, song);
        serviceSong.save(song);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    private void doUploadAvatar(Optional<MultipartFile> avatar, Song song) throws IOException {
        if (avatar.isPresent()) {
            String fileUploadFileAvatar = env.getProperty("uploadPath").toString();
            String fileNameAvatar = avatar.get().getOriginalFilename();
            if (!fileNameAvatar.equals("")) {
                FileCopyUtils.copy(avatar.get().getBytes(), new File(fileUploadFileAvatar + fileNameAvatar));
                song.setAvatar(fileNameAvatar);
            }
        }
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
                FileCopyUtils.copy(fileMp3.get().getBytes(), new File(fileUploadFileMp3 + fileNameMp3));
                song.setFileMp3(fileNameMp3);
            }
        }
    }

}
