package org.xjosiah.mylittleairplay.Service;

import org.xjosiah.mylittleairplay.mybatis.entity.Song;

import java.util.List;

public interface SongService {
    List<Song> getRandomSongs(int limit);
}
