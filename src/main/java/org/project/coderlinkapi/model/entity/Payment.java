package org.project.coderlinkapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    @Column(name = "transactionDate", nullable = false, length = 10)
    private LocalDateTime transactionDate;
    @Column(name = "total", nullable = false, length = 20)
    private float Total;
    @Column(name = "totalDate", nullable = false, length = 20)
    private LocalDateTime totalDate;
    @Column(name = "paymentMethod", nullable = false, length = 30)
    private String paymentMethod;
    @Column(name = "facturation", nullable = false, length = 50)
    private String facturation;
    @Column(name = "createdAt")
    private LocalDateTime createdAt;
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_payment"))
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_purchase_customer"))
    private User customer;

}
