package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Entity(name = "product")
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity extends BaseEntity {
    @Id
    @SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private CategoryEntity category;
}
