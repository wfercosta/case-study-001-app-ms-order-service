package com.wfercosta.ms.order.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Builder(toBuilder = true)
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private LocalDate date;

    private BigDecimal valueTotal;

    private BigDecimal valueShipment;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "order")
    private List<OrderItem> items;

    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "order")
    private Recipient recipient;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

}

