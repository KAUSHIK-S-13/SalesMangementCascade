package com.sales.management.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SQLDelete(sql = "UPDATE user SET is_delete = 1 WHERE user_id = ? ")
@Table(name="user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int id;


    @NotEmpty
    @Size(min = 2, message = "user name should have at least 2 characters")
    @Column(name="user_name")
    private String name;

    @NotEmpty
    @Size(min = 5, message = "password should have at least 5 characters")
    @Column(name="password")
    private String password;

    @Column(name="is_active",columnDefinition = "integer default 0")
    private int isActive;

    @Column(name="is_delete",columnDefinition = "integer default 0")
    private int isDelete;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "modified_at")
    private LocalDateTime updateDateTime;


    @OneToMany(cascade =CascadeType.ALL)
    @JoinTable(name="userrole", joinColumns={@JoinColumn(name="user_id_fk", referencedColumnName="user_id")}
            , inverseJoinColumns={@JoinColumn(name="role_id_fk", referencedColumnName="id")})
    private List<Role> listofrole;




    public User(User user) {
        this.id = user.getId();
        this.listofrole = user.getListofrole();
        this.name = user.getName();
    }


}


