package com.abhishek.project.uber.uberApp.entities;


import com.abhishek.project.uber.uberApp.entities.enums.PaymentMethod;
import com.abhishek.project.uber.uberApp.entities.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Enumerated(EnumType.STRING)

    private PaymentMethod paymentMethod;

    @OneToOne(fetch = FetchType.LAZY)
    private Ride ride;

    private Double amount;
   @Enumerated(EnumType.STRING)

    private PaymentStatus paymentStatus;

    @CreationTimestamp
    private LocalDateTime paymentTime;

}
