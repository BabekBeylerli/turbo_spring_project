package com.example.turbospringproject.service;

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


    public List<PictureDto> getAllPictures() {
        return PictureMapper.mapper.mapEntityToDtos(picturesRepository.findAll());
    }

    public PictureDto getPicture(Integer pictureId) {
        return PictureMapper.mapper.mapEntityToDto(picturesRepository.findById(pictureId).orElseThrow(() ->
                new RuntimeException("Not Found")
        ));
    }

    public void savePicture(PictureDto pictureDto) {
        picturesRepository.save(PictureMapper.mapper.mapDtoToEntity(pictureDto));
    }

    public void editPicture(PictureDto pictureDto, Integer pictureId) {
        picturesRepository.save(PictureMapper.mapper.mapDtoToEntity(pictureDto, pictureId));
    }

    public void deletePicture(Integer pictureId) {
        picturesRepository.deleteById(pictureId);
    }

}
