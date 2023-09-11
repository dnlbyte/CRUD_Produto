
package com.Danielsilvadelima.CrudProduto.rest.form;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductForm {
   @NotEmpty(message = "O campo Nome não pode ser nulo")
   @NotBlank(message = "O nome não pode pode ser vazio")
   @Size(max = 100)
   private String name;
   
   @NotNull(message = "O campo unidade de preço não pode ser nulo")
   @DecimalMax(value = "99999999.99")
   @DecimalMin(value = "0.01")
   @Digits(integer = 16, fraction = 2)
   private BigDecimal unitPrice;
   
   @NotNull(message = "O campo Quantidade em stoque não pode ser nulo")
   @DecimalMax(value = "999999")
   @DecimalMin(value = "1")
   private Integer stockQuantity;
   
}
