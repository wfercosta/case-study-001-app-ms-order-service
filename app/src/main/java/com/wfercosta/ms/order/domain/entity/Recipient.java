package com.wfercosta.ms.order.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Builder(toBuilder = true)
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recipient")
public class Recipient {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private PersonType typePerson;

    private TaxationType typeTaxation;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "recipient")
    private List<Document> documents;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "recipient")
    private List<Address> addresses;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Order order;

    @CreatedDate
    @EqualsAndHashCode.Exclude
    private LocalDateTime createdAt;

    @LastModifiedDate
    @EqualsAndHashCode.Exclude
    private LocalDateTime updatedAt;
}

