package cn.visionliu.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by VisionLiu on 2017/12/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void findAllGirls() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/girls"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("[{\"id\":1,\"cupSize\":\"f\",\"age\":22},{\"id\":2,\"cupSize\":\"d\",\"age\":33},{\"id\":4,\"cupSize\":\"d\",\"age\":19},{\"id\":5,\"cupSize\":\"d\",\"age\":19},{\"id\":6,\"cupSize\":\"d\",\"age\":10},{\"id\":7,\"cupSize\":\"d\",\"age\":19},{\"id\":8,\"cupSize\":\"d\",\"age\":15},{\"id\":10,\"cupSize\":\"d\",\"age\":19},{\"id\":11,\"cupSize\":\"B\",\"age\":19},{\"id\":12,\"cupSize\":null,\"age\":null},{\"id\":13,\"cupSize\":\"d\",\"age\":19},{\"id\":14,\"cupSize\":\"d\",\"age\":19},{\"id\":15,\"cupSize\":\"d\",\"age\":19},{\"id\":16,\"cupSize\":\"C\",\"age\":18}]"));

    }

}