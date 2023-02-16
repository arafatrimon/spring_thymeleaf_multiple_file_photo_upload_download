package com.example.spring_web_thymeleaf_file_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import java.io.File;
@Service
@Transactional
public class UserPathServiceImpl implements UploadPathService {
    @Autowired
    ServletContext context;
    @Override
    public File getFilePath(String modifiedFileName, String path) {
        boolean exists=new File(context.getRealPath("/"+path+"/")).exists();
        if(!exists){
            new File(context.getRealPath("/"+path+"/")).mkdir();
        }
        String modifiedFilePath=context.getRealPath("/"+path+"/"+File.separator+modifiedFileName);
        File file= new File(modifiedFilePath);
        return file;
    }
}
