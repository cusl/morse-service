package lunarfactories.morse.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class IntegrationTests {

    final static String ENDPOINT = "/";
    final static ResultMatcher GOOD_RESPONSE_STATUS = MockMvcResultMatchers.status().isOk(); //200
    final static String GOOD_RESPONSE_ANSWER = ".----..-----....-.-.------.-.-.------.-.-.-.----";

    @Autowired
    MockMvc mockMvc;

    @Test
    void getClientIp() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(ENDPOINT);

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(GOOD_RESPONSE_STATUS)
                .andExpect(content().string(GOOD_RESPONSE_ANSWER))
                .andDo(print());
    }
}