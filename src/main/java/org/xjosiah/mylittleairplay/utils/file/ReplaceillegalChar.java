package org.xjosiah.mylittleairplay.utils.file;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.List;

public class ReplaceillegalChar {
    public static void main(String[] args) {
        List<File> files = FileUtil.loopFiles("/Volumes/doc/MyLittleAirplay_backend/src/main/resources/static/my_little_airplay_resource/催泪的滋味音乐会");
        files.stream().filter(f -> !FileUtil.getName(f).startsWith("._")).forEach(file -> {
            String newName = FileUtil.getName(file).replace('[', '(').replace(']', ')');
            FileUtil.rename(file, newName, false);
        });
    }
}
