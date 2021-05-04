package org.xjosiah.mylittleairplay.utils.db;

import cn.hutool.core.io.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xjosiah.mylittleairplay.mybatis.entity.Album;
import org.xjosiah.mylittleairplay.mybatis.entity.Song;
import org.xjosiah.mylittleairplay.mybatis.mapper.AlbumMapper;
import org.xjosiah.mylittleairplay.mybatis.mapper.SongMapper;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CreateTable {
    @Autowired
    SongMapper songMapper;

    @Autowired
    AlbumMapper albumMapper;

    public void createSongTableFromFiles() {
        String startPath = "/Volumes/文档/my_little_airport_全辑";
        List<File> mp3Files = FileUtil.loopFiles(startPath).stream()
                .filter(f -> FileUtil.getName(f).endsWith(".mp3") && !(FileUtil.getName(f).startsWith("._")))
                .collect(Collectors.toList());
        mp3Files.forEach(file -> {
            String relativePath = FileUtil.subPath(startPath, file);
            String[] split = relativePath.split("/");
            String albumName = split[0];
            String songName = split[1];

            Album album = albumMapper.getAlbumByName(albumName);

            Song song = new Song();
            song.setSongName(songName.split("\\.")[0]);
            song.setAlbumId(album.getAlbumId());
            song.setUrl(relativePath);
            song.setSongCoverUrl("album_cover/" + album.getAlbumCoverUrl());
            songMapper.addSong(song);
        });
    }

    public void removeSongNameExt(){
        for (int id = 1; id < 315; id++) {
            Song song = songMapper.getSongById(id);
            String songName = song.getSongName();
            songName = songName.substring(0,songName.length()-4).toLowerCase();
            if (songName.startsWith("my little airport - ")){
                songName = songName.substring(20);
            }
            songMapper.updataSongName(id,songName);
        }
    }
}
