package org.xjosiah.mylittleairplay.Service;

import org.xjosiah.mylittleairplay.mybatis.entity.Song;

import java.io.File;
import java.util.List;

public interface SongService {
    List<Song> getRandomSongs(int limit);

    Song getSongEntityById(int id);

    File getSongById(int id);

    Song getSongEntityByName(String name);

    File getSongByUrl(String url);

    int countSongs();

    List<Song> searchSongsByName(String songName);

    Boolean collectSong(String userId, int songId);

    Boolean delCollectedSong(String userId, int songId);

    List<Song> getSongCollection(String userId);
}
