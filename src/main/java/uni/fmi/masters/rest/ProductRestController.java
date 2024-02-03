package uni.fmi.masters.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uni.fmi.masters.dto.ProductDTO;
import uni.fmi.masters.models.Product;
import uni.fmi.masters.models.Reservation;
import uni.fmi.masters.models.User;
import uni.fmi.masters.services.ProductService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/product")
public class ProductRestController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<ProductDTO> findAll() {
        List<Product> products = productService.findAll();
        return products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ProductDTO convertToDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

//    @PostMapping(path = "/save")
//    public String saveProduct(  @RequestParam(value="title") String title,
//                                    @RequestParam(value="price") BigDecimal price,
//                                    @RequestParam(value = "description") String description,
//                                    Model model){
//
//        Product product = new Product();
//        product.setTitle(title);
//        product.setPrice(price);
//        product.setDescription(description);
//        productService.create(product);
//
//        return getAllProducts(model);
//    }
//    @GetMapping(path = "/all")
//    private String getAllProducts(Model model) {
//        List<Product> products = productService.findAll();
//        model.addAttribute("getProducts", products);
//        return "redirect:/all";
//    }


    @PostMapping()
    public ProductDTO create(@RequestBody ProductDTO productDTO) {
        Product product = convertToModel(productDTO);
        product.setId(null);
        return convertToDTO(productService.create(product));
    }

    private Product convertToModel(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }

    @PutMapping()
    public ProductDTO update(@RequestBody ProductDTO productDTO) {
        Product updated = productService.update(convertToModel(productDTO));
        return convertToDTO(updated);
    }

    @DeleteMapping(path = "/{productId}")
    public ResponseEntity<String> remove(@PathVariable(name = "productId") long productId) {

        boolean isRemoved = productService.remove(productId);

        String deletedMessage = "Product with id: '" + productId + "' was deleted!";
        String notDeletedMessage = "Product with id: '" + productId + "' does not exists!";
        return isRemoved ?
                new ResponseEntity<>(deletedMessage, HttpStatusCode.valueOf(200)) :
                new ResponseEntity<>(notDeletedMessage, HttpStatusCode.valueOf(404));
    }


}
