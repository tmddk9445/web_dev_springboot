package com.example.vsc_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.vsc_springboot.common.constant.ApiMappingPattern;
import com.example.vsc_springboot.service.FileService;

@RestController
@RequestMapping(ApiMappingPattern.FILE)
public class FileController {

  @Autowired private FileService fileService;

  private static final String UPLOAD = "/upload";
  private static final String GET_IMAGE_FILE = "/image/{imageName}";

  //# File Upload
  @PostMapping(UPLOAD)
  //? Post http://localhost:4080/file/upload
  public String upload(@RequestParam("file") MultipartFile file) {
    String fileUrl = fileService.upload(file);
    return fileUrl;
  }

  //# Image 출력
  @GetMapping(value = GET_IMAGE_FILE, produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE})
  //? Get http://localhost:4080/file/image/{imageName}
  public Resource getImageFile(@PathVariable("imageName") String imageName){
    Resource resource = fileService.getImageFile(imageName);
    return resource;
  }

}
