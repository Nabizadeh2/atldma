package com.atl23.product.dao.repository;

import com.atl23.product.dao.entity.ProductEntity;
import com.atl23.product.dto.ProductResponseDto;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    List<ProductEntity> findByPrice(BigDecimal price);
    List<ProductEntity> findByName(String name);

}
