package com.yogeesh.hibernate.entities;

import javax.persistence.*;

/**
 * Created by yogeesh.srkvs@gmail.com on 9/18/17.
 */
@Entity
@Table(name = "river", schema = "rivers", catalog = "")
public class River_River_Entity {
    private Integer id;
    private String name;
    private String origin;
    private Integer lengthKm;
    private Long basinKm2;

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
    @Column(name = "origin", nullable = true, length = 50)
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Basic
    @Column(name = "length_km", nullable = false)
    public Integer getLengthKm() {
        return lengthKm;
    }

    public void setLengthKm(Integer lengthKm) {
        this.lengthKm = lengthKm;
    }

    @Basic
    @Column(name = "basin_km2", nullable = false)
    public Long getBasinKm2() {
        return basinKm2;
    }

    public void setBasinKm2(Long basinKm2) {
        this.basinKm2 = basinKm2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        River_River_Entity that = (River_River_Entity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (origin != null ? !origin.equals(that.origin) : that.origin != null) return false;
        if (lengthKm != null ? !lengthKm.equals(that.lengthKm) : that.lengthKm != null) return false;
        if (basinKm2 != null ? !basinKm2.equals(that.basinKm2) : that.basinKm2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        result = 31 * result + (lengthKm != null ? lengthKm.hashCode() : 0);
        result = 31 * result + (basinKm2 != null ? basinKm2.hashCode() : 0);
        return result;
    }
}
