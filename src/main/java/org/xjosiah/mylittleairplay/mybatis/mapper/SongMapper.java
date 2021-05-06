package org.xjosiah.mylittleairplay.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xjosiah.mylittleairplay.mybatis.entity.Song;

import java.util.List;

@Repository
public interface SongMapper {
    int addSong(Song song);

    void updateSongName(int songId, String songName);

    Song getSongById(@Param("songId") int id);

    Song getSongByName(@Param("songName") String name);

    int countSong();

    List<Song> getSongByAlbumId(int albumId);
}
