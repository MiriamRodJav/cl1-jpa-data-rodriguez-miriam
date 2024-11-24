package pe.edu.i202331451.cl1_jpa_data_rodriguez_miriam.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Country {

    @Id
    private String code;
    private String name;
    private String continent;
    private String region;
    private Double surfaceArea;
    private Integer indepYear;
    private Integer population;
    private Double lifeExpectancy;
    private Double gnp;
    private Double gnpOld;
    private String localName;
    private String governmentForm;
    private String headOfState;
    private Integer capital;
    private String code2;

    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE,
            CascadeType.PERSIST}, orphanRemoval = true)
    private List<City> city;

    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE,
            CascadeType.PERSIST}, orphanRemoval = true)
    private List<CountryLanguage> countryLanguage;
}
