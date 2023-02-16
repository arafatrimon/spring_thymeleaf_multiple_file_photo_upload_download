package com.example.spring_web_thymeleaf_file_management.service;

import java.io.File;

public interface UploadPathService {
    File getFilePath(String modifiedFileName,String path);
}
