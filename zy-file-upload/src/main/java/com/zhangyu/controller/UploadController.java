package com.zhangyu.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class UploadController {
    private static String UPLOADED_FOLDER = System.getProperty("user.dir") + "/zy-file-upload/src/main/resources/files/";

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        Path dir = Paths.get(UPLOADED_FOLDER);
        Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
        if(!Files.exists(dir)) {
            Files.createDirectories(dir);
        }
//        以下两种都可以保存
        Files.write(path, bytes);
//        Files.copy(file.getInputStream(), path);
        System.out.println("路径：" + path);
        System.out.println("内容：" + bytes);
        return "写入完成";
    }

}
