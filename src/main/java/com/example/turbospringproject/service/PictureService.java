package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.PicturesRep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PictureService {
private final PicturesRep picturesRep;

    public PictureService(PicturesRep picturesRep) {
        this.picturesRep = picturesRep;
    }
}
