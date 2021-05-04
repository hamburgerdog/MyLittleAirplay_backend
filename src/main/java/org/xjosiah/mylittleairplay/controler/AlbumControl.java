package org.xjosiah.mylittleairplay.controler;

import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.xjosiah.mylittleairplay.Service.AlbumService;

import javax.websocket.server.PathParam;

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
}
