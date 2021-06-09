package org.xjosiah.mylittleairplay.Service.impl;

import cn.hutool.core.io.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xjosiah.mylittleairplay.Service.AlbumService;
import org.xjosiah.mylittleairplay.mybatis.entity.Album;
import org.xjosiah.mylittleairplay.mybatis.entity.Song;
import org.xjosiah.mylittleairplay.mybatis.mapper.AlbumMapper;
import org.xjosiah.mylittleairplay.mybatis.mapper.SongMapper;
import org.xjosiah.mylittleairplay.utils.properties.ResourceProperties;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    AlbumMapper albumMapper;
    @Autowired
    SongMapper songMapper;

    @Autowired
    ResourceProperties resourceProperties;

    @Override
    public Album getAlbumByName(String name) {
        return albumMapper.getAlbumByName(name);
    }

    @Override
    public Album getAlbumById(int id) {
        return albumMapper.getAlbumById(id);
    }

    @Override
    public byte[] getAlbumImageById(int id) {
        Album album = albumMapper.getAlbumById(id);
        String albumCoverUrl = resourceProperties.getAlbumcoverpath() + album.getAlbumCoverUrl();
        return FileUtil.readBytes(albumCoverUrl);
    }

    @Override
    public List<Song> getAlbumSongsById(int albumId) {
        return songMapper.getSongByAlbumId(albumId);
    }

    @Override
    public List<Album> getAlbums() {
        return albumMapper.getAlbums();
    }

    @Override
    public Boolean collectAlbum(String userId, int albumId) {
        return albumMapper.insertCollectedAlbum(userId,albumId);
    }

    @Override
    public Boolean removeCollectedAlbum(String userId, int albumId) {
        return albumMapper.deleteCollectedAlbum(userId,albumId);
    }

    @Override
    public List<Album> getAlbumCollection(String userId) {
        return albumMapper.selectAlbumCollection(userId);
    }
}
