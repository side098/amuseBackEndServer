package com.example.amusetravelproejct.controller.admin.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.example.amusetravelproejct.domain.Item;
import com.example.amusetravelproejct.domain.ItemCourse;
import com.example.amusetravelproejct.domain.ItemImg;
import com.example.amusetravelproejct.repository.ItemCourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ItemCourseService {
    private final ItemCourseRepository itemCourseRepository;
    private final AmazonS3 amazonS3Client;

    static String bucketName = "amuse-img";

    public Optional<ItemCourse> saveItemCourse(ItemCourse itemCourse) {
        return Optional.of(itemCourseRepository.save(itemCourse));
    }

    public String getCourseImgUrl(String base64Img, String key) {
        // TODO
        // 멀티파트, base64로 받은 이미지 S3로 보내어 이미지 저장
        // S3로 보내어 저장한 이미지의 url을 받아와서 List<String>에 저장
        // 반환

        byte[] imageBytes = Base64.getDecoder().decode(base64Img);
        InputStream inputStream = new ByteArrayInputStream(imageBytes);

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType("image/jpeg");
        metadata.setContentLength(imageBytes.length);
        amazonS3Client.putObject(bucketName, "images/" + key, inputStream, metadata);
        String s3Url = amazonS3Client.getUrl(bucketName, key).toString();

        return s3Url;
    }
}
