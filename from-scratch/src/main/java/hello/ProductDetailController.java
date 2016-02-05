package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/products")
public class ProductDetailController {
    private final ProductDetailRepository repository;
    @Autowired
    public ProductDetailController(ProductDetailRepository repository) {
        this.repository = repository;
    }
    @RequestMapping(method = RequestMethod.GET)
    public Iterable findAll() {
        return repository.findAll();
    }
    @RequestMapping(method = RequestMethod.POST)
    public ProductDetail create(@RequestBody ProductDetail detail) {
        return repository.save(detail);
    }
}