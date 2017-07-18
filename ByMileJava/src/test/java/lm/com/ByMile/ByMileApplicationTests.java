package lm.com.ByMile;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
//@ContextConfiguration("test-servlet-context.xml")
public class ByMileApplicationTests {

	@Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    
//    @Test
//    public void LoadMovie() throws Exception {
//        Movie m = new Movie("TEST", "1982");
//        String json = new Gson().toJson(m);
//        mockMvc.perform(post("/api/movies/")
//        .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(json))
//        .andExpect(status().isOk());
//        
//    }
//    @Test
//    public void getTest() throws Exception{
//        mockMvc.perform(get("/api/movies/40"))
//        .andExpect(status().isOk())
//        .andExpect(jsonPath("$.movieName").value("TEST"));
	
	@Test
	public void contextLoads() {
	}

}
