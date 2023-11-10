package com.techgenie.demo.service.imp;

import com.techgenie.demo.repository.AreaRepository;
import com.techgenie.demo.service.inf.IAreaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AreaService implements IAreaService {
    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public com.techgenie.demo.dto.domain.Area findAreaByName(String name) {
        try {
            com.techgenie.demo.dto.model.Area area = areaRepository.findByareaName(name);
            return com.techgenie.demo.dto.domain.Area.builder()
                    .name(area.getAreaName())
                    .no(Long.parseLong(area.getAreaNo()))
                    .id(area.getAreaId())
                    .build();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<com.techgenie.demo.dto.domain.Area> findAllAreas() {
        try {
            List<com.techgenie.demo.dto.domain.Area> list = new ArrayList<>();
            areaRepository.findAll().forEach(area -> {
                list.add(com.techgenie.demo.dto.domain.Area.builder()
                        .id(area.getAreaId())
                        .no(Long.parseLong(area.getAreaNo()))
                        .name(area.getAreaName())
                        .build());
            });
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public com.techgenie.demo.dto.domain.Area findAreaById(int id) {
        try {
            com.techgenie.demo.dto.model.Area area = areaRepository.findById(id).get();
            return com.techgenie.demo.dto.domain.Area.builder()
                    .id(area.getAreaId())
                    .name(area.getAreaName())
                    .no(Long.parseLong(area.getAreaNo()))
//                .candidates(area.getCandidates())
//                .voters(area.getVoters())
                    .build();
        } catch (Exception e) {
            return null;
        }
    }

}
