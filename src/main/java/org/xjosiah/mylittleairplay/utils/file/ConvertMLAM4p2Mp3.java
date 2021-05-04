package org.xjosiah.mylittleairplay.utils.file;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.List;
import java.util.concurrent.*;

public class ConvertMLAM4p2Mp3 {
    public static void main(String[] args) {
        int corePoolSize = 8;
        int maximumPoolSize = 8;
        long keepAliveTime = 100L;
        TimeUnit unit = TimeUnit.SECONDS;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                new ArrayBlockingQueue<>(1000),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        List<File> files = FileUtil.loopFiles("/Volumes/文档/my_little_airport_全辑");
        files.stream().
                filter(file -> {
                    String fileName = FileUtil.getName(file);
                    return (!fileName.startsWith("._")) && fileName.endsWith(".m4a");
                })
                .forEach(source -> {
                    String targetUrl = FileUtil.getAbsolutePath(source).replace(".m4a", ".mp3");
                    File target = FileUtil.file(targetUrl);
                    MyRunnable convertTask = new MyRunnable(target, source);
                    executor.execute(convertTask);
                });
    }

    private static class MyRunnable implements Runnable {
        File target;
        File source;

        public MyRunnable(File target, File source) {
            this.target = target;
            this.source = source;
        }

        @Override
        public void run() {
            ConvertAny2Mp3Util.ConvertAnyToMp3(source, target);
            FileUtil.del(source);
        }
    }
}
