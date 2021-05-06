package org.xjosiah.mylittleairplay.Service;

import org.xjosiah.mylittleairplay.mybatis.entity.Album;
import org.xjosiah.mylittleairplay.mybatis.entity.Song;

import java.util.List;

public interface AlbumService {
    Album getAlbumByName(String name);

    Album getAlbumById(int id);

    byte[] getAlbumImageById(int id);

    List<Song> getAlbumSongsById(int albumId);

    List<Album> getAlbums();
}
