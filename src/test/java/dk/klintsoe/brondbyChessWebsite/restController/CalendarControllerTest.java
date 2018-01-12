package dk.klintsoe.brondbyChessWebsite.restController;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CalendarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getNoCalendar() throws Exception {

        this.mockMvc.perform(get("/calendar/2000")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"content\":null}")))
        //.andExpect(jsonPath("$.name").value("Søren"))
        //	.andExpect(jsonPath("$.playerId").value("1"))
        ;

    }

    @Test
    public void get2016Calendar() throws Exception {

        this.mockMvc.perform(get("/calendar/2016-2017"))
                .andExpect(MockMvcResultMatchers.content().contentType("application/hal+json;charset=UTF-8"))
                .andExpect(status().isOk())
            	.andExpect(jsonPath("content.season").value("2016-2017"))
                .andExpect(jsonPath("content.entryList").isArray())
                .andExpect(jsonPath("content.entryList[0].id").isNumber())
                .andExpect(jsonPath("content.entryList[0].id").value("27"))


                .andDo(print())
        ;

    }


}