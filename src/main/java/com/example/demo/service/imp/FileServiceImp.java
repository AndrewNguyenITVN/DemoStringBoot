package com.example.demo.service.imp;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileServiceImp {
    boolean savefile(MultipartFile file);
    Resource loadFile(String filename);

}
