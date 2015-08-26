package cn.edu.bit.model;

import javax.persistence.*;

/**
 * Created by 初 on 2015/8/20.
 */
@Entity
@Table(name = "ade7758_continous", schema = "", catalog = "chinaoil")
public class Ade7758ContinousEntity {
    private int id;
    private int address;
    private String timestramp;
    private String type;
    private String data;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "address")
    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    @Basic
    @Column(name = "timestramp")
    public String getTimestramp() {
        return timestramp;
    }

    public void setTimestramp(String timestramp) {
        this.timestramp = timestramp;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "data")
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ade7758ContinousEntity that = (Ade7758ContinousEntity) o;

        if (id != that.id) return false;
        if (address != that.address) return false;
        if (timestramp != null ? !timestramp.equals(that.timestramp) : that.timestramp != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + address;
        result = 31 * result + (timestramp != null ? timestramp.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}
