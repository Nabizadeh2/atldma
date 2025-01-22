package com.atl23.product.controller;


import com.atl23.product.dao.entity.ProductEntity;
import com.atl23.product.dto.ProductRequestDto;
import com.atl23.product.dto.ProductResponseDto;
import com.atl23.product.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Data
@RequestMapping("api/v2/product")

public class ProductController {

    private final ProductService productService;


    @PostMapping("/post")
    public void addProduct(@RequestBody ProductRequestDto dto){
        productService.addProduct(dto);
    }
    @GetMapping("/get")
    public List<ProductResponseDto> getProduct(){
        return productService.getProdut();
    }

    @GetMapping("/get/{id}")
    public ProductResponseDto getById(@PathVariable Long id) throws Exception{
        return productService.getbyId(id);
    }
    @PostMapping("/update/{id}")
    public ProductRequestDto updateById(@RequestBody ProductRequestDto dto,@PathVariable Long id){
        return productService.updateProduct(dto,id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProductId(@PathVariable Long id) throws Exception{
        return productService.deleteProductById(id);
    }

    @GetMapping("/get")
    public List<ProductResponseDto> getByPrice(@RequestParam BigDecimal price){
        return productService.getByPrice(price);
    }
    @GetMapping("/get")
    public List<ProductResponseDto> getByName(@RequestParam String name){
        return productService.getByName(name);
    }
}
