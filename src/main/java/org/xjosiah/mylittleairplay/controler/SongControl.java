package org.xjosiah.mylittleairplay.controler;

import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xjosiah.mylittleairplay.Service.SongService;

@Controller
@CrossOrigin
@RequestMapping("song")
public class SongControl {
    @Autowired
    SongService songService;

    @GetMapping("/random")
    @ResponseBody
    ResponseEntity<String> getRandomSongs(){
        return ResponseEntity.ok(JSONUtil.toJsonStr(songService.getRandomSongs(10)));
    }

}
