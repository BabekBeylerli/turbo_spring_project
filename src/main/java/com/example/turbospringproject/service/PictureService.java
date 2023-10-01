package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.entity.PictureEntity;
import com.example.turbospringproject.dao.repository.PictureRepository;
import com.example.turbospringproject.mapper.PictureMapper;
import com.example.turbospringproject.model.PictureDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class PictureService {
    private final PictureRepository picturesRepository;

    public PictureService(PictureRepository picturesRepository) {
        this.picturesRepository = picturesRepository;
    }


    public List<String> getAllPictures() {
        log.info("ActionLog.getAllPictures.start");
        List<PictureDto> pictureDtos = PictureMapper.mapper.mapEntityToDtos(picturesRepository.findAll());
        List<String> base64Images = new ArrayList<>();

        for (PictureDto picture : pictureDtos) {
            byte[] imageBytes = picture.getImage().getBytes();
            base64Images.add(Base64.encodeBase64String(imageBytes));
        }

        log.info("ActionLog.getAllPictures.end");
        return base64Images;
    }

    public String getPicture(Integer pictureId) {
        log.info("ActionLog.getPicture.start");
        PictureDto pictureDto = PictureMapper.mapper.mapEntityToDto(picturesRepository.findById(pictureId).orElseThrow(() ->
                new RuntimeException("Not Found")
        ));
        log.info("ActionLog.getPicture.end");
        byte[] imageBytes = pictureDto.getImage().getBytes();
        return Base64.encodeBase64String(imageBytes);
    }

    public void savePicture(String base64Image) {
        log.info("ActionLog.savePicture.start");
        String image = Arrays.toString(Base64.decodeBase64(base64Image));
        PictureDto pictureDto = new PictureDto();
        pictureDto.setImage(image);
        picturesRepository.save(PictureMapper.mapper.mapDtoToEntity(pictureDto));
        log.info("ActionLog.savePicture.end");
    }

    public void updatePicture(String base64Image, Integer pictureId) {
        log.info("ActionLog.updatePicture.start");
        String imageBytes = Arrays.toString(Base64.decodeBase64(base64Image));
        PictureDto pictureDto = PictureMapper.mapper.mapEntityToDto(picturesRepository.findById(pictureId).orElseThrow(() ->
                new RuntimeException("Not Found")
        ));
        pictureDto.setImage(imageBytes);
        picturesRepository.save(PictureMapper.mapper.mapDtoToEntity(pictureDto));
        log.info("ActionLog.updatePicture.end");
    }


    public void deletePicture(Integer pictureId) {
        log.info("ActionLog.deletePicture.start");
        picturesRepository.deleteById(pictureId);
        log.info("ActionLog.deletePicture.end");
    }
}
