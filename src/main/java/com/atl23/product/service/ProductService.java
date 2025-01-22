package com.atl23.product.service;

import com.atl23.product.dao.entity.ProductEntity;
import com.atl23.product.dto.ProductRequestDto;
import com.atl23.product.dto.ProductResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface ProductService {
    void addProduct(ProductRequestDto dto);
    List<ProductResponseDto> getProdut();
    ProductResponseDto getbyId(Long id) throws Exception;
    ProductRequestDto updateProduct(ProductRequestDto dto,Long id);
    String deleteProductById(Long id) throws Exception;
    public List<ProductResponseDto> getByPrice(BigDecimal price);
    public List<ProductResponseDto> getByName(String name);

}
