package com.wjx.osiris.hecarim;

import com.alibaba.fastjson.JSON;
import com.wjx.osiris.hecarim.domain.User;
import com.wjx.osiris.hecarim.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Slf4j
@AutoConfigureMockMvc
class HecarimApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {

        User user = userService.getUserById(1L);

        log.info("user is {}", user);
    }

    @Test
    public void test() {
        int i = LocalDateTime.now().compareTo(LocalDateTime.now().minusDays(5));
        System.out.println(i);
    }

    @Test
    public void testMVCGet(@Autowired MockMvc mockMvc) throws Exception {
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/hecarim/list");
        ResultActions perform = mockMvc.perform(mockHttpServletRequestBuilder);

        MvcResult mvcResult = perform.andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        System.out.println(response.getContentAsString());
    }

    @Test
    public void testMVCPost(@Autowired MockMvc mockMvc) throws Exception {
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/hecarim/query")
                .contentType(MediaType.APPLICATION_JSON).content(JSON.toJSONString(User.builder().username("name").build()));
        ResultActions perform = mockMvc.perform(mockHttpServletRequestBuilder);

        MvcResult mvcResult = perform.andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        System.out.println(response.getContentAsString());
    }
}
