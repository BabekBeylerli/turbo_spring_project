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
import java.util.List;

@Service
@Slf4j
public class PictureService {
    private final PictureRepository picturesRepository;

    public PictureService(PictureRepository picturesRepository) {
        this.picturesRepository = picturesRepository;
    }


    public List<PictureDto> getAllPicture() {
        log.info("ActionLog.getAllPicture.start");
        List<PictureDto> pictureDtos = PictureMapper.mapper.mapEntityToDtos(picturesRepository.findAll());
        log.info("ActionLog.getAllPicture.end");
        return pictureDtos;
    }

    public PictureDto getPicture(Integer pictureId) {
        log.info("ActionLog.getPicture.start");
        PictureEntity pictureEntity = picturesRepository.findById(pictureId).orElseThrow(() ->
                new RuntimeException("Not Found")
        );
        log.info("ActionLog.getPicture.end");
        return PictureMapper.mapper.mapEntityToDto(pictureEntity);
    }

    public void savePicture(PictureDto pictureDto) {
        log.info("ActionLog.savePicture.start");
        picturesRepository.save(PictureMapper.mapper.mapDtoToEntity(pictureDto));
        log.info("ActionLog.savePicture.end");
    }

    public void editPicture(PictureDto pictureDto, Integer pictureId) {
        log.info("ActionLog.editPicture.start");
        picturesRepository.save(PictureMapper.mapper.mapDtoToEntity(pictureDto, pictureId));
        log.info("ActionLog.editPicture.end");
    }

    public void deletePicture(Integer pictureId) {
        log.info("ActionLog.deletePicture.start");
        picturesRepository.deleteById(pictureId);
        log.info("ActionLog.deletePicture.end");
    }


    public String convertImageToBase64(String imagePath) throws IOException {
        log.info("ActionLog.Base64.start");
        // Görüntü dosyasını okuyoruz.
        byte[] imageBytes = Files.readAllBytes(Path.of(imagePath));

        // Görüntüyü Base64'e dönüştürüyoruz.
        String base64Image = Base64.encodeBase64String(imageBytes);
        log.info("ActionLog.Base64.end");
        return base64Image;
    }

}
