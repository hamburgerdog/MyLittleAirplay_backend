package org.xjosiah.mylittleairplay.Service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xjosiah.mylittleairplay.Service.SongService;
import org.xjosiah.mylittleairplay.mybatis.entity.Song;
import org.xjosiah.mylittleairplay.mybatis.mapper.SongMapper;
import org.xjosiah.mylittleairplay.utils.properties.ResourceProperties;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    SongMapper songMapper;
    @Autowired
    ResourceProperties resourceProperties;

    @Override
    public List<Song> getRandomSongs(int limit) {
        if (limit > 10 || limit < 1) limit = 10;
        List<Integer> randomSongsId = new ArrayList<>(10);
        for (int i = 0; i < limit; i++) {
            int id = RandomUtil.randomInt(1, songMapper.countSong());
            if (randomSongsId.contains(id)) {
                i--;
                continue;
            }
            randomSongsId.add(id);
        }
        List<Song> songs = new ArrayList<>();
        for (Integer id : randomSongsId) {
            songs.add(songMapper.getSongById(id));
        }
        return songs;
    }

    @Override
    public Song getSongEntityById(int id) {
        return songMapper.getSongById(id);
    }

    @Override
    public File getSongById(int id) {
        String url = resourceProperties.getPath() + songMapper.getSongById(id).getUrl();
        return getSongByUrl(url);
    }

    @Override
    public Song getSongEntityByName(String name) {
        return songMapper.getSongByName(name);
    }

    @Override
    public File getSongByUrl(String url) {
        return FileUtil.file(url);
    }

    @Override
    public int countSongs() {
        return songMapper.countSong();
    }
}
