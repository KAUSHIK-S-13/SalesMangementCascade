package com.sales.management.Model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@SQLDelete(sql = "UPDATE spareparts SET is_delete = 1 WHERE spareparts_id = ? ")

@Table(name="spareparts")
public class Spareparts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="spareparts_id")
    private Integer sparepartsId;

    @NotEmpty
    @Size(min = 3, message = "sparepartsName should have at least 3 characters")
    @Column(name="spareparts_name")
    private String sparepartsName;

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

    @OneToOne
    @JoinColumn(name ="fk_sparepartstype_id")
    private Sparepartstype sparepartstypeId;

    /*@OneToMany(mappedBy = "sparepartss")
    private List<Order> order;*/

}
