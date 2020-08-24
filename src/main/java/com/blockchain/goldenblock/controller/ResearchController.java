package com.blockchain.goldenblock.controller;

import com.blockchain.goldenblock.domain.dto.ResearchDto;
import com.blockchain.goldenblock.service.ResearchService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("researches/*")
public class ResearchController {
    private ResearchService researchService;

    @GetMapping("/list")
    public List<ResearchDto> list() {
        List<ResearchDto> ResearchList = researchService.getResearchList();
        return ResearchList;
    }

    @PostMapping("/post")
    public void postResearch(@RequestBody ResearchDto researchDto){
        researchService.savePost(researchDto);
    }

    @GetMapping("/list/{no}")
    @ResponseBody
    public ResearchDto getResearch(@PathVariable("no") Long no) {
        ResearchDto researchDto = researchService.getPost(no);
        return researchDto;
    }


}
