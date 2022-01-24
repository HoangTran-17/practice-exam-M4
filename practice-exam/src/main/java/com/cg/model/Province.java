package com.cg.model;

import javax.persistence.*;


@Entity
@Table(name = "province")
public class Province{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String country;
    private Long area;
    private Long population;
    private Double gdp;
    private String description;

    public Province() {
    }

    public Province( String name, String country, Long area, Long population, Double gdp, String description) {
        this.name = name;
        this.country = country;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public void setGdp(Double gdp) {
        this.gdp = gdp;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public Long getArea() {
        return area;
    }

    public Long getPopulation() {
        return population;
    }

    public Double getGdp() {
        return gdp;
    }

    public String getDescription() {
        return description;
    }
}

