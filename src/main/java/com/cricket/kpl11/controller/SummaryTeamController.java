package com.cricket.kpl11.controller;


import com.cricket.kpl11.dto.SummaryTeamDto;
import com.cricket.kpl11.services.SummaryTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/team")
@CrossOrigin("*")
public class SummaryTeamController {

    @Autowired
    private SummaryTeamService summaryTeamService;

    @GetMapping("/summary")
    public ResponseEntity<List<SummaryTeamDto>> allTeamSummary(){
        List<SummaryTeamDto> summaryTeamDto = summaryTeamService.allTeamSummary();
        return ResponseEntity.ok(summaryTeamDto);
    }

}
