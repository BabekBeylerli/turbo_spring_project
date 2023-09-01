package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.entity.PictureEntity;
import com.example.turbospringproject.dao.repository.PicturesRepository;
import com.example.turbospringproject.mapper.PictureMapper;
import com.example.turbospringproject.model.PictureDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PictureService {
    private final PicturesRepository picturesRepository;

    public PictureService(PicturesRepository picturesRepository) {
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

}
