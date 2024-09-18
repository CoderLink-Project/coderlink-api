package org.project.coderlinkapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.EnableMBeanExport;

@Data
@Entity
@Table(name = "client")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @Column(name = "first_name", nullable = false, length = 30)
    private String firstname;
    @Column(name = "last_name", nullable = false, length = 30)
    private String lastname;
    @Column(name = "nameCompany", nullable = false, length = 20)
    private String nameCompany;
    @Column(name = "ruc", nullable = false, length = 11)
    private int ruc;
    @Column(name = "phone", nullable = false, length = 9)
    private int phone;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id",foreignKey = @ForeignKey(name ="FK_user_id"))
    private User user;
}
