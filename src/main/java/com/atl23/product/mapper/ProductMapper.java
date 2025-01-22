package com.atl23.product.mapper;

import com.atl23.product.dao.entity.ProductEntity;
import com.atl23.product.dao.repository.ProductRepository;
import com.atl23.product.dto.ProductResponseDto;
import com.atl23.product.util.DateUtil;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
@Builder
public class ProductMapper {

    public List<ProductResponseDto> getProduct(List<ProductEntity> entities){
        List<ProductResponseDto> dtos = new ArrayList<>();
        for(ProductEntity e : entities) {
            ProductResponseDto dto = ProductResponseDto.builder()
                    .name(e.getName())
                    .price(e.getPrice())
                    .created_at(DateUtil.getFormatter(e.getCreated_at(),true))
                    .updated_at(DateUtil.getFormatter(e.getUpdated_at(),false)).build();

            dtos.add(dto);
        }
        return dtos;
    }
    public ProductResponseDto getById(ProductEntity e){
        ProductResponseDto dto = ProductResponseDto.builder()
                .name(e.getName())
                .price(e.getPrice())
                .build();
        return dto;
    }
}
