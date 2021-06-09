package org.xjosiah.mylittleairplay.controler;

import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.xjosiah.mylittleairplay.Service.SongService;

@Controller
@CrossOrigin
@RequestMapping("song")
public class SongControl {
    @Autowired
    SongService songService;

    @GetMapping("/random")
    @ResponseBody
    ResponseEntity<String> getRandomSongs() {
        return ResponseEntity.ok(JSONUtil.toJsonStr(songService.getRandomSongs(10)));
    }

    @GetMapping("/random/{limit}")
    @ResponseBody
    ResponseEntity<String> getRandomSongsByLimit(@PathVariable("limit") int limit) {
        return ResponseEntity.ok(JSONUtil.toJsonStr(songService.getRandomSongs(limit)));
    }

    @GetMapping("/name/{songName}")
    ResponseEntity<String> searchSongByName(@PathVariable("songName") String songName){
        return ResponseEntity.ok(JSONUtil.toJsonStr(songService.searchSongsByName(songName)));
    }

    @PutMapping("/like/{userId}/{songId}")
    ResponseEntity<String> collectSong(@PathVariable("userId") String userId, @PathVariable("songId") int songId) {
        return ResponseEntity.ok(JSONUtil.toJsonStr(songService.collectSong(userId,songId)));
    }

    @DeleteMapping("/like/{userId}/{songId}")
    ResponseEntity<String> removeCollectedSong(@PathVariable("userId") String userId, @PathVariable("songId") int songId) {
        return ResponseEntity.ok(JSONUtil.toJsonStr(songService.delCollectedSong(userId,songId)));
    }

    @GetMapping("/like/{userId}")
    ResponseEntity<String> getSongCollection(@PathVariable String userId){
        return ResponseEntity.ok(JSONUtil.toJsonStr(songService.getSongCollection(userId)));
    }
}
