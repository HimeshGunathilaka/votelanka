package com.techgenie.demo.service.imp;

import com.techgenie.demo.repository.AreaRepository;
import com.techgenie.demo.service.inf.IAreaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService implements IAreaService {
    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public com.techgenie.demo.dto.model.Area findAreaByName(String name) {
        return areaRepository.findByareaName(name);
    }

    @Override
    public List<com.techgenie.demo.dto.model.Area> findAllAreas() {
        return areaRepository.findAll();
    }


}
