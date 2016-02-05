package hello;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        System.out.println("Hello sir I am server");

        /*String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }*/
        //ApplicationContext ctx = SpringApplication.run(Main.class);
        ProductDetail detail = new ProductDetail();
        detail.setProductId("ABCD1234");
        detail.setProductName("Dan's Book of Writing");
        detail.setShortDescription("A book about writing books.");
        detail.setLongDescription("In this book about writing books, Dan will show you how to write a book.");
        detail.setInventoryId("009178461");
        ProductDetailRepository repository = ctx.getBean(ProductDetailRepository.class);
        repository.save(detail);
        for (ProductDetail productDetail : repository.findAll()) {
            System.out.println(productDetail.getProductId());
        }
    }
}