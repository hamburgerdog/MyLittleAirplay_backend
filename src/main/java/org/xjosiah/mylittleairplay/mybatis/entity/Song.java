package org.xjosiah.mylittleairplay.mybatis.entity;

import lombok.Data;

@Data
public class Song {
    private int songId;
    private String songName;
    private int albumId;
    private String url;
    private String songCoverUrl;
}
