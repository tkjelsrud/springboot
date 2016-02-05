package hello;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class ProductDetailControllerTest {
    private MockMvc mvc;
    //@Autowired
    //ProductDetailRepository repository;

    @Before
    public void setUp() throws Exception {
        //ApplicationContext ctx = SpringApplication.run(this);
        ApplicationContext ctx = SpringApplication.run(Application.class, new String[]{});
        ProductDetailRepository repository = ctx.getBean(ProductDetailRepository.class);

        mvc = MockMvcBuilders.standaloneSetup(new ProductDetailController(repository)).build();
    }
    //@Ignore
    @Test
    public void newProduct() throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(new ProductDetail("TEST123øæå"), ProductDetail.class);

        mvc.perform(MockMvcRequestBuilders.post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }
}
