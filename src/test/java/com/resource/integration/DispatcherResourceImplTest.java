/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2017 VTB Group. All rights reserved.
 */

package com.resource.integration;

import com.Application;
import com.dto.DispatcherDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class DispatcherResourceImplTest {

    @Autowired
    private MockMvc mockMvc;
    private JacksonTester<DispatcherDto> dispatcherMapper;
    private JacksonTester<List<DispatcherDto>> dispatcherListMapper;

    @Before
    public void setup() {
        ObjectMapper objectMappper = new ObjectMapper();
        JacksonTester.initFields(this, objectMappper);
    }

    @Test
    public void getDispatchers() throws Exception {
        List<DispatcherDto> dispatcherDtoList = getDispatchersList();
        dispatcherDtoList.forEach(
                System.out::println
        );
    }

    private List<DispatcherDto> getDispatchersList() throws UnsupportedEncodingException, Exception {
        String dispatchers = mockMvc
                .perform(RestDocumentationRequestBuilders.get("/dispatcher"))
                .andExpect(status().isOk())
                .andDo(document("dispatchers list", responseFields(
                        fieldWithPath("[].dispatcherName").type(JsonFieldType.STRING)
                                .description("Dispatcher name"),
                        fieldWithPath("[].dispatcherFrase").type(JsonFieldType.STRING).description("Dispatcher frase"),
                        fieldWithPath("[].createTime").type(JsonFieldType.NUMBER).optional()
                                .description("Dispatchers creation time"))))
                .andReturn().getResponse().getContentAsString();
        return dispatcherListMapper.parseObject(dispatchers);
    }

}
