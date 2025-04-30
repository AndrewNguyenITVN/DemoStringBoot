package com.example.demo.service.imp;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface MenuServiceImp {
    boolean insertMenu(MultipartFile file,
                        String title,
                        String time_ship,
                        Double price,
                        int cate_id);

}
