package com.github.liquidjoo.placesearch.search.kakao.address.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.liquidjoo.placesearch.search.kakao.address.domain.ApiRequest;
import com.github.liquidjoo.placesearch.search.kakao.address.domain.Documents;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class KakaoAddressServiceTest {

    @Mock
    private ApiRequest apiRequest;

    @InjectMocks
    private KakaoAddressService kakaoAddressService;

    private ObjectMapper objectMapper;
    private String json;

    private Documents documents;

    @Test
    void searchTest() throws JsonProcessingException {
        documents = objectMapper.readValue(json, Documents.class);
        given(apiRequest.request("전북 삼성동 100"))
                .willReturn(documents);

        final Documents actual = kakaoAddressService.search("전북 삼성동 100");

        assertThat(actual.getDocuments().size()).isEqualTo(documents.getDocuments().size());
    }

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        json = "{\n" +
                "    \"documents\": [\n" +
                "        {\n" +
                "            \"address\": {\n" +
                "                \"address_name\": \"전북 익산시 부송동 100\",\n" +
                "                \"b_code\": \"4514013400\",\n" +
                "                \"h_code\": \"4514069000\",\n" +
                "                \"main_address_no\": \"100\",\n" +
                "                \"mountain_yn\": \"N\",\n" +
                "                \"region_1depth_name\": \"전북\",\n" +
                "                \"region_2depth_name\": \"익산시\",\n" +
                "                \"region_3depth_h_name\": \"삼성동\",\n" +
                "                \"region_3depth_name\": \"부송동\",\n" +
                "                \"sub_address_no\": \"\",\n" +
                "                \"x\": \"126.99597495347\",\n" +
                "                \"y\": \"35.9766482774579\"\n" +
                "            },\n" +
                "            \"address_name\": \"전북 익산시 부송동 100\",\n" +
                "            \"address_type\": \"REGION_ADDR\",\n" +
                "            \"road_address\": {\n" +
                "                \"address_name\": \"전북 익산시 망산길 11-17\",\n" +
                "                \"building_name\": \"\",\n" +
                "                \"main_building_no\": \"11\",\n" +
                "                \"region_1depth_name\": \"전북\",\n" +
                "                \"region_2depth_name\": \"익산시\",\n" +
                "                \"region_3depth_name\": \"부송동\",\n" +
                "                \"road_name\": \"망산길\",\n" +
                "                \"sub_building_no\": \"17\",\n" +
                "                \"underground_yn\": \"N\",\n" +
                "                \"x\": \"126.995995793098\",\n" +
                "                \"y\": \"35.97675110933\",\n" +
                "                \"zone_no\": \"54547\"\n" +
                "            },\n" +
                "            \"x\": \"126.99597495347\",\n" +
                "            \"y\": \"35.9766482774579\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": {\n" +
                "                \"address_name\": \"전북 익산시 임상동 100\",\n" +
                "                \"b_code\": \"4514013200\",\n" +
                "                \"h_code\": \"4514069000\",\n" +
                "                \"main_address_no\": \"100\",\n" +
                "                \"mountain_yn\": \"N\",\n" +
                "                \"region_1depth_name\": \"전북\",\n" +
                "                \"region_2depth_name\": \"익산시\",\n" +
                "                \"region_3depth_h_name\": \"삼성동\",\n" +
                "                \"region_3depth_name\": \"임상동\",\n" +
                "                \"sub_address_no\": \"\",\n" +
                "                \"x\": \"126.980268573424\",\n" +
                "                \"y\": \"35.9816612949055\"\n" +
                "            },\n" +
                "            \"address_name\": \"전북 익산시 임상동 100\",\n" +
                "            \"address_type\": \"REGION_ADDR\",\n" +
                "            \"road_address\": null,\n" +
                "            \"x\": \"126.980268573424\",\n" +
                "            \"y\": \"35.9816612949055\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": {\n" +
                "                \"address_name\": \"전북 익산시 정족동 100\",\n" +
                "                \"b_code\": \"4514013100\",\n" +
                "                \"h_code\": \"4514069000\",\n" +
                "                \"main_address_no\": \"100\",\n" +
                "                \"mountain_yn\": \"N\",\n" +
                "                \"region_1depth_name\": \"전북\",\n" +
                "                \"region_2depth_name\": \"익산시\",\n" +
                "                \"region_3depth_h_name\": \"삼성동\",\n" +
                "                \"region_3depth_name\": \"정족동\",\n" +
                "                \"sub_address_no\": \"\",\n" +
                "                \"x\": \"127.002020445866\",\n" +
                "                \"y\": \"35.9829740190924\"\n" +
                "            },\n" +
                "            \"address_name\": \"전북 익산시 정족동 100\",\n" +
                "            \"address_type\": \"REGION_ADDR\",\n" +
                "            \"road_address\": null,\n" +
                "            \"x\": \"127.002020445866\",\n" +
                "            \"y\": \"35.9829740190924\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"meta\": {\n" +
                "        \"is_end\": true,\n" +
                "        \"pageable_count\": 3,\n" +
                "        \"total_count\": 3\n" +
                "    }\n" +
                "}";
    }
}