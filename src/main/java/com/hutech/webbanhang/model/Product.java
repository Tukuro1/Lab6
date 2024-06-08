package com.hutech.webbanhang.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Tên sản product khong duoc de trong")
    private String name;
    @NotNull(message = "Gia san pham ko dc de trong")
    @Min(value = 1, message = "gia san pham ko duoc nho hon 1")
    @Max(value = 999999999, message = "san pham ko duoc lon hon 999999999")
    private double price;
    private String description;
    @Length(min = 0, max = 50, message = "ten hinh ko qua 50 ki tu")
    private String images;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
