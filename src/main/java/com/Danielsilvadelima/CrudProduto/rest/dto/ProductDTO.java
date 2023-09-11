/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Danielsilvadelima.CrudProduto.rest.dto;

import java.math.BigDecimal;
import lombok.Data;
@Data
public class ProductDTO {
    
   
   private String name;
   
   private BigDecimal unitPrice;
   
   private Integer stockQuantity;
    
}
