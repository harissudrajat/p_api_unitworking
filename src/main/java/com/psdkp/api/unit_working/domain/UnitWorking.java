package com.psdkp.api.unit_working.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class UnitWorking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String name;
    private String address;
    private String phone;
    private String facsimile;
    private String email;
    private String latitude;
    private String longitude;
    private Integer cityId;

    @ManyToOne
    @JoinColumn(name = "typeUnitId", referencedColumnName = "id", updatable = false)
    private TypeUnit typeUnit;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "sarana_unitWorking",
            joinColumns = @JoinColumn(name = "unitWorking_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "facilities_id", referencedColumnName = "id"))
    private Set<Facilities> facilities;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "infrastructure_unitWorking",
            joinColumns = @JoinColumn(name = "unitWorking_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "infrastructure_id", referencedColumnName = "id"))
    private Set<Infrastructure> infrastructures;

}
