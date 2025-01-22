package com.atl23.product.service.impl;

import com.atl23.product.dao.entity.ProductEntity;
import com.atl23.product.dao.repository.ProductRepository;
import com.atl23.product.dto.ProductRequestDto;
import com.atl23.product.dto.ProductResponseDto;
import com.atl23.product.mapper.ProductMapper;
import com.atl23.product.service.ProductService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Data
@Builder
@Service
public class ProductServiceimpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public void addProduct(ProductRequestDto dto) {
        ProductEntity entity = ProductEntity.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .build();
        productRepository.save(entity);
    }

    @Override
    public List<ProductResponseDto> getProdut() {
        List<ProductEntity> entity = productRepository.findAll();

        return productMapper.getProduct(entity);
    }


    @Override
    public ProductResponseDto getbyId(Long id) throws Exception {
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        ProductEntity entity = ProductEntity.builder().build();
        if (optionalProductEntity.isPresent()) {
            entity = optionalProductEntity.get();
            return productMapper.getById(entity);
        }

        throw new Exception("bele bir id yoxdur!!!");
    }

    @Override
    public ProductRequestDto updateProduct(ProductRequestDto dto, Long id) {
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        if(optionalProductEntity.isPresent()){
            ProductEntity  productEntity= optionalProductEntity.get();
            productEntity.setName(dto.getName());
            productEntity.setPrice(dto.getPrice());
            productRepository.save(productEntity);
        }
        return ProductRequestDto.builder()
                .name(dto.getName())
                .price(dto.getPrice()).
                updated_at(dto.getUpdated_at())
                .created_at(dto.getCreated_at())
                .build();
    }

    @Override
    public String deleteProductById(Long id)throws Exception {
        Optional<ProductEntity> entity = productRepository.findById(id);

        if(entity.isPresent()) {
            productRepository.deleteById(id);
            return "row is deleted";
        }
        throw new Exception("Id not found!!!");
    }

    public List<ProductResponseDto> getByPrice(BigDecimal price){
        List<ProductEntity> entity = productRepository.findByPrice(price);
        return productMapper.getProduct(entity);

    }

    @Override
    public List<ProductResponseDto> getByName(String name) {
        List<ProductEntity> entities = productRepository.findByName(name);
        return productMapper.getProduct(entities);
    }

}
