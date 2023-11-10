package com.techgenie.demo.controller;

import com.techgenie.demo.dto.domain.Area;
import com.techgenie.demo.service.inf.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/area")
@CrossOrigin
public class AreaController {
    @Autowired
    private IAreaService areaService;

    @GetMapping("/*")
    public List<Area> findAllAreas() {
        try {
            return areaService.findAllAreas();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/area_name")
    public Area findAreaByName(String name) {
        try {
            return areaService.findAreaByName(name);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/area_id")
    public Area findByAreaId(int id) {
        try {
            return areaService.findAreaById(id);
        } catch (Exception e) {
            return null;
        }

    }
}
