package com.lsh.ssyx.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author shaohua.liu
 * Create at 2023/8/1
 */
public interface FileUploadService {

    /**
     * 图片上传的方法
     * @param file
     * @return
     */
    String uploadFile(MultipartFile file);
}
