package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.PicturesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PictureService {
private final PicturesRepository picturesRep;

    public PictureService(PicturesRepository picturesRep) {
        this.picturesRep = picturesRep;
    }
}
