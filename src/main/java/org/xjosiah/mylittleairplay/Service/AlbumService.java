package org.xjosiah.mylittleairplay.Service;

import org.xjosiah.mylittleairplay.mybatis.entity.Album;

public interface AlbumService {
    Album getAlbumByName(String name);

    Album getAlbumById(int id);

    byte[] getAlbumImageById(int id);
}
