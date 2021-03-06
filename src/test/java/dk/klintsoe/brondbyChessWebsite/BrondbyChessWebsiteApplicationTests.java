package dk.klintsoe.brondbyChessWebsite;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BrondbyChessWebsiteApplicationTests {


    @Autowired
    private MockMvc mockMvc;

//    @Test
//    public void testOne() throws Exception {
//        this.mockMvc.perform(get("/")).andDo(print())
//                .andExpect(status().isOk())
//        //.andExpect(jsonPath("$.name").value("Søren"))
//        	.andExpect(jsonPath("$.playerId").value("1"))
//        ;
//    }
}
