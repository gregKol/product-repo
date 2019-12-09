package pl.product.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import pl.product.model.*;


public interface ProductRepository extends JpaRepository<Product, Long>{

}
