/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Danielsilvadelima.CrudProduto.repository;
import com.Danielsilvadelima.CrudProduto.model.ProductModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long>{
 /* @Query(value = "SELECT * FROM TB_ORDER_ITEMS WHERE ID_ORDER=:orderId AND ID_PRODUCT=:productId", nativeQuery = true)
    Optional<OrderItemsModel> findByOrderIdAndProductId(@Param("orderId") long orderId, @Param("productId") long productId);*/
    
    Optional<ProductModel> findByName(String name);
           
}

