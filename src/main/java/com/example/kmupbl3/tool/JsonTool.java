package com.example.kmupbl3.tool;

import com.example.kmupbl3.dto.AdShowDTO;
import com.example.kmupbl3.dto.UserInfoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class JsonTool {

    // todo ApiResponse 필드 리팩토링
    // ObjectMapper를 사용하여 ApiResponse 객체를 JSON 문자열로 변환
    public static String ApiResponseJsonMapper(int code, String errMessage, Integer id) {
        ApiResponse response = new ApiResponse(code, errMessage, id);
        return getJson(response);
    }

    public static String UserInfoJsonMapper(int code, String errMessage, UserInfoDTO dto) {
        UserInfoResponse response = new UserInfoResponse(code, errMessage, dto);
        return getJson(response);
    }

    public static String AdShowListJsonMapper(int code, String errMessage, List<AdShowDTO> dto) {
        AdShowResponse response = new AdShowResponse(code, errMessage, dto);
        return getJson(response);
    }


    public static String getJson(Object from) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse;
        try {
            jsonResponse = objectMapper.writeValueAsString(from);
        } catch (Exception e) {
            log.error("Error converting ApiResponse to JSON", e);
            jsonResponse = "{\"status\":1,\"errMessage\":\"Error converting to JSON\",\"id\":null}";
        }
        return jsonResponse;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    static
    class ApiResponse {
        private int status;
        private String errMessage;
        private Integer id;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    static
    class UserInfoResponse {
        private int status;
        private String errMessage;
        private UserInfoDTO userInfo;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    static
    class AdShowResponse {
        private int status;
        private String errMessage;
        private List<AdShowDTO> adShowDTO;
    }
}
