package cn.edu.bit.model;

import javax.persistence.*;

/**
 * Created by 初 on 2015/5/31.
 */
@Entity
@Table(name = "address_info", schema = "", catalog = "chinaoil")
public class AddressInfoEntity {
    private int address;
    private String version;
    private String lastTime;

    @Id
    @Column(name = "address")
    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    @Basic
    @Column(name = "version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Basic
    @Column(name = "last_time")
    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressInfoEntity that = (AddressInfoEntity) o;

        if (address != that.address) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (lastTime != null ? !lastTime.equals(that.lastTime) : that.lastTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = address;
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (lastTime != null ? lastTime.hashCode() : 0);
        return result;
    }
}
