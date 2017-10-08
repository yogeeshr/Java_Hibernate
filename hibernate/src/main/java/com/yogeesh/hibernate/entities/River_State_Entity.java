package com.yogeesh.hibernate.entities;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by yogeesh.srkvs@gmail.com on 9/18/17.
 */
@Entity
@Table(name = "state", schema = "rivers", catalog = "")
public class River_State_Entity {
    private Integer id;
    private String name;
    private BigDecimal areaKm2;
    private Long population;
    private String language;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "area_km2", nullable = false, precision = 8)
    public BigDecimal getAreaKm2() {
        return areaKm2;
    }

    public void setAreaKm2(BigDecimal areaKm2) {
        this.areaKm2 = areaKm2;
    }

    @Basic
    @Column(name = "population", nullable = false)
    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    @Basic
    @Column(name = "LANGUAGE", nullable = true, length = 50)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        River_State_Entity that = (River_State_Entity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (areaKm2 != null ? !areaKm2.equals(that.areaKm2) : that.areaKm2 != null) return false;
        if (population != null ? !population.equals(that.population) : that.population != null) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (areaKm2 != null ? areaKm2.hashCode() : 0);
        result = 31 * result + (population != null ? population.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }
}
