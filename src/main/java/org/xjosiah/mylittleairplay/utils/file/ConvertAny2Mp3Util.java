package org.xjosiah.mylittleairplay.utils.file;

import ws.schild.jave.Encoder;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.encode.AudioAttributes;
import ws.schild.jave.encode.EncodingAttributes;

import java.io.File;

public class ConvertAny2Mp3Util {
    /**
     * 任意格式转换成Mp3 默认质量为 立体声-224kbps
     *
     * @param source 源文件
     * @param target 转换的文件（为空则默认创建）
     * @return 转换成功与否
     */
    public static boolean ConvertAnyToMp3(File source, File target) {
        boolean success = true;
        try {
            //Audio Attributes
            AudioAttributes audio = new AudioAttributes();
            audio.setCodec("libmp3lame");
            audio.setBitRate(224000);
            audio.setChannels(2);
            audio.setSamplingRate(44100);

            //Encoding attributes
            EncodingAttributes attrs = new EncodingAttributes();
            attrs.setOutputFormat("mp3");
            attrs.setAudioAttributes(audio);

            //Encode
            Encoder encoder = new Encoder();
            encoder.encode(new MultimediaObject(source), target, attrs);

        } catch (Exception ex) {
            ex.printStackTrace();
            success = false;
        }
        return success;
    }
}
