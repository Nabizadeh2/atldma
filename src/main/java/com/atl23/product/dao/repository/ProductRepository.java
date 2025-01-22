package com.atl23.product.dao.repository;

import com.atl23.product.dao.entity.ProductEntity;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
