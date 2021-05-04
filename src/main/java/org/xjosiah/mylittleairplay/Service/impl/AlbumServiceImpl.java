package org.xjosiah.mylittleairplay.Service.impl;

import cn.hutool.core.io.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xjosiah.mylittleairplay.Service.AlbumService;
import org.xjosiah.mylittleairplay.mybatis.entity.Album;
import org.xjosiah.mylittleairplay.mybatis.mapper.AlbumMapper;
import org.xjosiah.mylittleairplay.utils.properties.ResourceProperties;

@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    AlbumMapper albumMapper;
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
        String albumCoverUrl = resourceProperties.getAlbumcoverpath()+ album.getAlbumCoverUrl();
        return FileUtil.readBytes(albumCoverUrl);
    }
}
