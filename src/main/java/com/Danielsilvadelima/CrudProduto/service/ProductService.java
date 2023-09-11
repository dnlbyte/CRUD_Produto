package com.Danielsilvadelima.CrudProduto.service;

import com.Danielsilvadelima.CrudProduto.model.ProductModel;
import com.Danielsilvadelima.CrudProduto.repository.ProductRepository;
import com.Danielsilvadelima.CrudProduto.rest.dto.ProductDTO;
import com.Danielsilvadelima.CrudProduto.rest.form.ProductForm;
import com.Danielsilvadelima.CrudProduto.rest.form.ProductUpdateForm;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public ProductDTO findProductByName(String name) {
        Optional<ProductModel> produto = productRepository.findByName(name);
        
        return convertModelToDTO(produto.get());
    }
    
    private ProductDTO convertModelToDTO(ProductModel produtoModel) {
        ProductDTO produtoDTO = new ProductDTO();
        produtoDTO.setName(produtoModel.getName());
        produtoDTO.setStockQuantity(produtoModel.getStockQuantity());
        produtoDTO.setUnitPrice(produtoModel.getUnitPrice());
        
        return produtoDTO;
    }

    public ProductDTO createNewProduct(ProductForm produtoForm) {
        ProductModel produtoModel = new ProductModel();
        
        produtoModel.setName(produtoForm.getName());
        produtoModel.setStockQuantity(produtoForm.getStockQuantity());
        produtoModel.setUnitPrice(produtoForm.getUnitPrice());
        produtoModel.setIsActive(true);
        
        productRepository.save(produtoModel);
        
        return convertModelToDTO(produtoModel);
    }
    
    private List<ProductDTO> convertListToDto(List<ProductModel> list) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (ProductModel productModel : list) {
            ProductDTO productDTO = this.convertModelToDTO(productModel);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }
    
    public List<ProductDTO> getAllProducts() {
        List<ProductModel> productModelList = productRepository.findAll();
        return convertListToDto(productModelList);
    }
    
    public void deleteProduct(String productName) {
        Long byId = productRepository.findByName(productName).get().getId();
        productRepository.deleteById(byId);
        
    }
    
    public ProductDTO updateProduct(String productName, ProductUpdateForm productUpdateForm) {
        Optional<ProductModel> productModel = productRepository.findByName(productName);
        
        if (!productModel.isPresent()) {
            System.out.println("Erro de atualização: PRODUTO NÃO ENCONTRADO");            
        }
        ProductModel updatedModel = productModel.get();
        updatedModel.setName(productUpdateForm.getName());
        updatedModel.setStockQuantity(productUpdateForm.getStockQuantity());
        updatedModel.setUnitPrice(productUpdateForm.getUnitPrice());
        updatedModel.setIsActive(productUpdateForm.getIsActive());
        
        productRepository.save(updatedModel);
        
        return convertModelToDTO(updatedModel);
    }
}
