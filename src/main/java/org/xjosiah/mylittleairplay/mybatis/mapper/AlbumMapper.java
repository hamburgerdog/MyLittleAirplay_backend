package org.xjosiah.mylittleairplay.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xjosiah.mylittleairplay.mybatis.entity.Album;

@Repository
public interface AlbumMapper {
    Album getAlbumById(@Param("id") int id);
    Album getAlbumByName(String name);
}