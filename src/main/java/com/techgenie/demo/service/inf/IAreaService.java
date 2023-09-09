package com.techgenie.demo.service.inf;

import com.techgenie.demo.dto.model.Area;

import java.util.List;

public interface IAreaService {
    Area findAreaByName(String name);

    List<com.techgenie.demo.dto.model.Area> findAllAreas();
}
