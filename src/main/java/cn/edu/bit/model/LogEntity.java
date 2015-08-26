package cn.edu.bit.model;

import javax.persistence.*;

/**
 * Created by 初 on 2015/8/20.
 */
@Entity
@Table(name = "log", schema = "", catalog = "chinaoil")
public class LogEntity {
    private int id;
    private int address;
    private String type;
    private String message;
    private String timestramp;

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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "timestramp")
    public String getTimestramp() {
        return timestramp;
    }

    public void setTimestramp(String timestramp) {
        this.timestramp = timestramp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogEntity logEntity = (LogEntity) o;

        if (id != logEntity.id) return false;
        if (address != logEntity.address) return false;
        if (type != null ? !type.equals(logEntity.type) : logEntity.type != null) return false;
        if (message != null ? !message.equals(logEntity.message) : logEntity.message != null) return false;
        if (timestramp != null ? !timestramp.equals(logEntity.timestramp) : logEntity.timestramp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + address;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (timestramp != null ? timestramp.hashCode() : 0);
        return result;
    }
}
