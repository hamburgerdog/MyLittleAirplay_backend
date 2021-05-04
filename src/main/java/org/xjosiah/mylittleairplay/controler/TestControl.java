package org.xjosiah.mylittleairplay.controler;

import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xjosiah.mylittleairplay.mybatis.mapper.AlbumMapper;
import org.xjosiah.mylittleairplay.utils.db.CreateTable;

//@RestController
//@RequestMapping("test")
public class TestControl {

    @Autowired
    AlbumMapper albumMapper;

    @Autowired
    CreateTable createTable;

    @GetMapping("/get")
    String getAlbum(){
        return JSONUtil.toJsonStr(albumMapper.getAlbumById(1));
    }

    @GetMapping("/create")
    void createTable(){
//        createTable.createSongTableFromFiles();
    }

    @GetMapping("/updata")
    @Transactional
    void updata(){
        createTable.removeSongNameExt();
    }
}
