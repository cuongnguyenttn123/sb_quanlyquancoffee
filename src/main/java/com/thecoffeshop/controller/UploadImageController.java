package com.thecoffeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@Controller
@RequestMapping("/api")
public class UploadImageController {
    @Autowired
    ServletContext context;
    @PostMapping("upload")
    @ResponseBody
    public String upLoadHinhAnh(MultipartHttpServletRequest request){
        String path_file_save = context.getRealPath("/resources/images/my-images/");
        Iterator<String> listName = request.getFileNames();
        MultipartFile mpf = request.getFile(listName.next());
        File file_name = new File(path_file_save + mpf.getOriginalFilename());
        String nameImage = mpf.getOriginalFilename();
        try {
            mpf.transferTo(file_name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nameImage;
    }
}
