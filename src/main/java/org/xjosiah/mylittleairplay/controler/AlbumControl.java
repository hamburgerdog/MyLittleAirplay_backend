package org.xjosiah.mylittleairplay.controler;

import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.xjosiah.mylittleairplay.Service.AlbumService;

@Controller
@RequestMapping("album")
@CrossOrigin
public class AlbumControl {
    @Autowired
    AlbumService albumService;

    @GetMapping("/albumName/{name}")
    @ResponseBody
    String getAlbumByName(@PathVariable("name") String albumName) {
        return JSONUtil.toJsonStr(albumService.getAlbumByName(albumName));
    }

    @GetMapping("/{id}")
    @ResponseBody
    String getAlbumById(@PathVariable("id") int albumId) {
        return JSONUtil.toJsonStr(albumService.getAlbumById(albumId));
    }

    @GetMapping("/img/{id}")
    ResponseEntity<byte[]> getImage(@PathVariable("id") int albumId) {
        byte[] image = albumService.getAlbumImageById(albumId);
        return ResponseEntity.ok(image);
    }

    @GetMapping("/name/{id}")
    ResponseEntity<String> getAlbumName(@PathVariable("id") int albumId) {
        return ResponseEntity.ok(albumService.getAlbumById(albumId).getAlbumName());
    }

    @GetMapping("/albumSongs/{id}")
    ResponseEntity<String> getAlbumSongsById(@PathVariable("id") int albumId) {
        return ResponseEntity.ok(JSONUtil.toJsonStr(albumService.getAlbumSongsById(albumId)));
    }

    @GetMapping("/albums")
    ResponseEntity<String> getAlbums() {
        return ResponseEntity.ok(JSONUtil.toJsonStr(albumService.getAlbums()));
    }

    @PutMapping("/like/{userId}/{albumId}")
    ResponseEntity<String> collectAlbum(@PathVariable("userId") String userId, @PathVariable("albumId") int albumId) {
        return ResponseEntity.ok(JSONUtil.toJsonStr(albumService.collectAlbum(userId,albumId)));
    }

    @DeleteMapping("/like/{userId}/{albumId}")
    ResponseEntity<String> removeCollectedAlbum(@PathVariable("userId") String userId, @PathVariable("albumId") int albumId) {
        return ResponseEntity.ok(JSONUtil.toJsonStr(albumService.removeCollectedAlbum(userId,albumId)));
    }

    @GetMapping("/like/{userId}")
    ResponseEntity<String> getAlbumCollection(@PathVariable String userId){
        return ResponseEntity.ok(JSONUtil.toJsonStr(albumService.getAlbumCollection(userId)));
    }
}
