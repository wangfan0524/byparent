package com.study.cloud.microserviceupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public @ResponseBody String handlleUpload(@RequestParam(value = "file",required = true)MultipartFile file) throws IOException {
        String path="H:\\testupload";
        byte [] bytes=file.getBytes();
        File fileToSave=new File(path+File.separator+file.getOriginalFilename());
        if (!fileToSave.exists()){
            fileToSave.createNewFile();
        }
        FileCopyUtils.copy(bytes,fileToSave);
        return fileToSave.getAbsolutePath();
    }
}
