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
        System.out.println(songService.searchSongsByName(songName));
        return ResponseEntity.ok(JSONUtil.toJsonStr(songService.searchSongsByName(songName)));
    }
}
