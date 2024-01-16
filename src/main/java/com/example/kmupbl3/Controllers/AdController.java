package com.example.kmupbl3.Controllers;

import com.example.kmupbl3.Domain.AD;
import com.example.kmupbl3.Services.AdService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/neighbor-ad")
@RequiredArgsConstructor
public class AdController {

    private final AdService adService;

    @GetMapping
    public String getAdPage() {
        return "react/index";  // TODO merge with react(frontend)
    }

    @ResponseBody
    @GetMapping("/ad-list")
    public String getAdList() {
        List<AD> adList = adService.findAds();

        // Jackson ObjectMapper를 사용하여 JSON으로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = null;
        try {
            jsonResult = objectMapper.writeValueAsString(adList);
        } catch (IOException e) {
            log.error("Error occured whilst parsing json from adList:", e);
        }

        return jsonResult;
    }


}
