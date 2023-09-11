
package com.Danielsilvadelima.CrudProduto.rest.controller;

import com.Danielsilvadelima.CrudProduto.rest.dto.ProductDTO;
import com.Danielsilvadelima.CrudProduto.rest.form.ProductForm;
import com.Danielsilvadelima.CrudProduto.rest.form.ProductUpdateForm;
import com.Danielsilvadelima.CrudProduto.service.ProductService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService produtoService;
    
    @GetMapping("/{name}")
    public ResponseEntity<ProductDTO> getProductByName(
            @PathVariable("name")String name
    ){
       ProductDTO produtoDTO = produtoService.findProductByName(name);
       
       return ResponseEntity.ok().body(produtoDTO);
        
    }
    
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> produtosDTO = produtoService.getAllProducts();
        return ResponseEntity.ok().body(produtosDTO);
    }

    
    @PostMapping 
    public ResponseEntity<ProductDTO> insertProduct(@Valid @RequestBody ProductForm produtoForm){ 
        System.out.println("Entrou");
        ProductDTO productDTO = produtoService.createNewProduct(produtoForm);
        return ResponseEntity.ok().body(productDTO);
    }
    
    @DeleteMapping("/{name}")
    public  ResponseEntity<Void> deleteProduct (
            @PathVariable("name") String name
    ) {
        produtoService.deleteProduct(name);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{name}")
    public ResponseEntity<ProductDTO> updateProduct(@Valid @RequestBody ProductUpdateForm productForm, @PathVariable("name")String name){
            ProductDTO productDTO = produtoService.updateProduct(name, productForm);
            
         
            return ResponseEntity.ok().body(productDTO);
        
    }
    
}
