package com.muvit.MUVIT.domain.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 20, nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false, length = 10)
    private String phoneNumber;

    /* Foreign Key */
    @OneToMany(mappedBy = "id_user", cascade = CascadeType.PERSIST, orphanRemoval = false, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<ServiceEntity> userService;

    @OneToMany(mappedBy = "idUser", cascade = CascadeType.PERSIST, orphanRemoval = false, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Payment> paymentMethods;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user_rol", referencedColumnName = "id_rol")
    private Rol rol;

    public User orElseThrow(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'orElseThrow'");
    }

}
