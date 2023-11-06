package com.techgenie.demo.service.inf;

import com.techgenie.demo.dto.domain.Area;

import java.util.List;

public interface IAreaService {
    Area findAreaByName(String name);

    List<com.techgenie.demo.dto.domain.Area> findAllAreas();

    Area findAreaById(int id);
}
