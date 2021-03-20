package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Entity(name = "category")
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity extends BaseEntity {
    @Id
    @SequenceGenerator(name = "category_seq", sequenceName = "category_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private List<ProductEntity> products = new ArrayList<>();

}
