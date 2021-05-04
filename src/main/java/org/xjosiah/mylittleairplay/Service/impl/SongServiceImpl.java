package org.xjosiah.mylittleairplay.Service.impl;

import cn.hutool.core.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xjosiah.mylittleairplay.Service.SongService;
import org.xjosiah.mylittleairplay.mybatis.entity.Song;
import org.xjosiah.mylittleairplay.mybatis.mapper.SongMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    SongMapper songMapper;

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
}
