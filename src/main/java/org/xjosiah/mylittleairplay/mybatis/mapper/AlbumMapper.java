package org.xjosiah.mylittleairplay.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xjosiah.mylittleairplay.mybatis.entity.Album;

import java.util.List;

@Repository
public interface AlbumMapper {
    Album getAlbumById(@Param("id") int id);
    Album getAlbumByName(String name);

    List<Album> getAlbums();

    Boolean insertCollectedAlbum(@Param("userId") String userId, @Param("albumId") int albumId);

    Boolean deleteCollectedAlbum(@Param("userId") String userId, @Param("albumId") int albumId);

    List<Album> selectAlbumCollection(@Param("userId") String userId);
}
