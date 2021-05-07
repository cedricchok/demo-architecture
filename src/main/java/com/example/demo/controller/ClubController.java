package com.example.demo.controller;

import com.example.demo.models.request.ClubDetailsRequestModel;
import com.example.demo.models.response.ClubRest;
import com.example.demo.service.IClubService;
import com.example.demo.shared.dto.ClubDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/club") // http://localhost:8080/club
public class ClubController {
    @Autowired
    IClubService clubService;

    @GetMapping
    public String getClub() {
        return "get club was called";
    }

    @PostMapping()
    public ClubRest createClub(@RequestBody ClubDetailsRequestModel clubDetails) {
        ClubRest returnValue = new ClubRest();

        ClubDto clubDto = new ClubDto();
        BeanUtils.copyProperties(clubDetails, clubDto);

        ClubDto createdClub = clubService.createClub(clubDto);
        BeanUtils.copyProperties(createdClub, returnValue);

        return returnValue;
    }

    @PutMapping
    public String updateClub() {
        return "club is update";
    }

    @DeleteMapping
    public String deleteClub() {
        return "club is delete";
    }

}
