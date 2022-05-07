package nhom26.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nhom26.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>  {

}
