package cn.edu.bit.model;

import javax.persistence.*;

/**
 * Created by 初 on 2015/8/20.
 */
@Entity
@Table(name = "inteli_table_dot", schema = "", catalog = "chinaoil")
public class InteliTableDotEntity {
    private int id;
    private int address;
    private String timestramp;
    private Integer currenta;
    private Integer currentb;
    private Integer currentc;
    private Integer voltagea;
    private Integer voltageb;
    private Integer voltagec;
    private Integer activePower1;
    private Integer activePower2;
    private Integer activePower3;
    private Integer activePower4;
    private Integer reactivePower1;
    private Integer reactivePower2;
    private Integer reactivePower3;
    private Integer reactivePower4;
    private Integer apparentPower1;
    private Integer apparentPower2;
    private Integer apparentPower3;
    private Integer apparentPower4;
    private Integer powerfactor1;
    private Integer powerfactor2;
    private Integer powerfactor3;
    private Integer powerfactor4;
    private Integer positiveActiveEnergy;
    private Integer positiveReactiveEnergy;
    private Integer reverseActiveEnergy;
    private Integer reverseReactiveEnergy;

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
    @Column(name = "currenta")
    public Integer getCurrenta() {
        return currenta;
    }

    public void setCurrenta(Integer currenta) {
        this.currenta = currenta;
    }

    @Basic
    @Column(name = "currentb")
    public Integer getCurrentb() {
        return currentb;
    }

    public void setCurrentb(Integer currentb) {
        this.currentb = currentb;
    }

    @Basic
    @Column(name = "currentc")
    public Integer getCurrentc() {
        return currentc;
    }

    public void setCurrentc(Integer currentc) {
        this.currentc = currentc;
    }

    @Basic
    @Column(name = "voltagea")
    public Integer getVoltagea() {
        return voltagea;
    }

    public void setVoltagea(Integer voltagea) {
        this.voltagea = voltagea;
    }

    @Basic
    @Column(name = "voltageb")
    public Integer getVoltageb() {
        return voltageb;
    }

    public void setVoltageb(Integer voltageb) {
        this.voltageb = voltageb;
    }

    @Basic
    @Column(name = "voltagec")
    public Integer getVoltagec() {
        return voltagec;
    }

    public void setVoltagec(Integer voltagec) {
        this.voltagec = voltagec;
    }

    @Basic
    @Column(name = "activePower1")
    public Integer getActivePower1() {
        return activePower1;
    }

    public void setActivePower1(Integer activePower1) {
        this.activePower1 = activePower1;
    }

    @Basic
    @Column(name = "activePower2")
    public Integer getActivePower2() {
        return activePower2;
    }

    public void setActivePower2(Integer activePower2) {
        this.activePower2 = activePower2;
    }

    @Basic
    @Column(name = "activePower3")
    public Integer getActivePower3() {
        return activePower3;
    }

    public void setActivePower3(Integer activePower3) {
        this.activePower3 = activePower3;
    }

    @Basic
    @Column(name = "activePower4")
    public Integer getActivePower4() {
        return activePower4;
    }

    public void setActivePower4(Integer activePower4) {
        this.activePower4 = activePower4;
    }

    @Basic
    @Column(name = "reactivePower1")
    public Integer getReactivePower1() {
        return reactivePower1;
    }

    public void setReactivePower1(Integer reactivePower1) {
        this.reactivePower1 = reactivePower1;
    }

    @Basic
    @Column(name = "reactivePower2")
    public Integer getReactivePower2() {
        return reactivePower2;
    }

    public void setReactivePower2(Integer reactivePower2) {
        this.reactivePower2 = reactivePower2;
    }

    @Basic
    @Column(name = "reactivePower3")
    public Integer getReactivePower3() {
        return reactivePower3;
    }

    public void setReactivePower3(Integer reactivePower3) {
        this.reactivePower3 = reactivePower3;
    }

    @Basic
    @Column(name = "reactivePower4")
    public Integer getReactivePower4() {
        return reactivePower4;
    }

    public void setReactivePower4(Integer reactivePower4) {
        this.reactivePower4 = reactivePower4;
    }

    @Basic
    @Column(name = "apparentPower1")
    public Integer getApparentPower1() {
        return apparentPower1;
    }

    public void setApparentPower1(Integer apparentPower1) {
        this.apparentPower1 = apparentPower1;
    }

    @Basic
    @Column(name = "apparentPower2")
    public Integer getApparentPower2() {
        return apparentPower2;
    }

    public void setApparentPower2(Integer apparentPower2) {
        this.apparentPower2 = apparentPower2;
    }

    @Basic
    @Column(name = "apparentPower3")
    public Integer getApparentPower3() {
        return apparentPower3;
    }

    public void setApparentPower3(Integer apparentPower3) {
        this.apparentPower3 = apparentPower3;
    }

    @Basic
    @Column(name = "apparentPower4")
    public Integer getApparentPower4() {
        return apparentPower4;
    }

    public void setApparentPower4(Integer apparentPower4) {
        this.apparentPower4 = apparentPower4;
    }

    @Basic
    @Column(name = "powerfactor1")
    public Integer getPowerfactor1() {
        return powerfactor1;
    }

    public void setPowerfactor1(Integer powerfactor1) {
        this.powerfactor1 = powerfactor1;
    }

    @Basic
    @Column(name = "powerfactor2")
    public Integer getPowerfactor2() {
        return powerfactor2;
    }

    public void setPowerfactor2(Integer powerfactor2) {
        this.powerfactor2 = powerfactor2;
    }

    @Basic
    @Column(name = "powerfactor3")
    public Integer getPowerfactor3() {
        return powerfactor3;
    }

    public void setPowerfactor3(Integer powerfactor3) {
        this.powerfactor3 = powerfactor3;
    }

    @Basic
    @Column(name = "powerfactor4")
    public Integer getPowerfactor4() {
        return powerfactor4;
    }

    public void setPowerfactor4(Integer powerfactor4) {
        this.powerfactor4 = powerfactor4;
    }

    @Basic
    @Column(name = "positiveActiveEnergy")
    public Integer getPositiveActiveEnergy() {
        return positiveActiveEnergy;
    }

    public void setPositiveActiveEnergy(Integer positiveActiveEnergy) {
        this.positiveActiveEnergy = positiveActiveEnergy;
    }

    @Basic
    @Column(name = "positiveReactiveEnergy")
    public Integer getPositiveReactiveEnergy() {
        return positiveReactiveEnergy;
    }

    public void setPositiveReactiveEnergy(Integer positiveReactiveEnergy) {
        this.positiveReactiveEnergy = positiveReactiveEnergy;
    }

    @Basic
    @Column(name = "reverseActiveEnergy")
    public Integer getReverseActiveEnergy() {
        return reverseActiveEnergy;
    }

    public void setReverseActiveEnergy(Integer reverseActiveEnergy) {
        this.reverseActiveEnergy = reverseActiveEnergy;
    }

    @Basic
    @Column(name = "reverseReactiveEnergy")
    public Integer getReverseReactiveEnergy() {
        return reverseReactiveEnergy;
    }

    public void setReverseReactiveEnergy(Integer reverseReactiveEnergy) {
        this.reverseReactiveEnergy = reverseReactiveEnergy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InteliTableDotEntity that = (InteliTableDotEntity) o;

        if (id != that.id) return false;
        if (address != that.address) return false;
        if (timestramp != null ? !timestramp.equals(that.timestramp) : that.timestramp != null) return false;
        if (currenta != null ? !currenta.equals(that.currenta) : that.currenta != null) return false;
        if (currentb != null ? !currentb.equals(that.currentb) : that.currentb != null) return false;
        if (currentc != null ? !currentc.equals(that.currentc) : that.currentc != null) return false;
        if (voltagea != null ? !voltagea.equals(that.voltagea) : that.voltagea != null) return false;
        if (voltageb != null ? !voltageb.equals(that.voltageb) : that.voltageb != null) return false;
        if (voltagec != null ? !voltagec.equals(that.voltagec) : that.voltagec != null) return false;
        if (activePower1 != null ? !activePower1.equals(that.activePower1) : that.activePower1 != null) return false;
        if (activePower2 != null ? !activePower2.equals(that.activePower2) : that.activePower2 != null) return false;
        if (activePower3 != null ? !activePower3.equals(that.activePower3) : that.activePower3 != null) return false;
        if (activePower4 != null ? !activePower4.equals(that.activePower4) : that.activePower4 != null) return false;
        if (reactivePower1 != null ? !reactivePower1.equals(that.reactivePower1) : that.reactivePower1 != null)
            return false;
        if (reactivePower2 != null ? !reactivePower2.equals(that.reactivePower2) : that.reactivePower2 != null)
            return false;
        if (reactivePower3 != null ? !reactivePower3.equals(that.reactivePower3) : that.reactivePower3 != null)
            return false;
        if (reactivePower4 != null ? !reactivePower4.equals(that.reactivePower4) : that.reactivePower4 != null)
            return false;
        if (apparentPower1 != null ? !apparentPower1.equals(that.apparentPower1) : that.apparentPower1 != null)
            return false;
        if (apparentPower2 != null ? !apparentPower2.equals(that.apparentPower2) : that.apparentPower2 != null)
            return false;
        if (apparentPower3 != null ? !apparentPower3.equals(that.apparentPower3) : that.apparentPower3 != null)
            return false;
        if (apparentPower4 != null ? !apparentPower4.equals(that.apparentPower4) : that.apparentPower4 != null)
            return false;
        if (powerfactor1 != null ? !powerfactor1.equals(that.powerfactor1) : that.powerfactor1 != null) return false;
        if (powerfactor2 != null ? !powerfactor2.equals(that.powerfactor2) : that.powerfactor2 != null) return false;
        if (powerfactor3 != null ? !powerfactor3.equals(that.powerfactor3) : that.powerfactor3 != null) return false;
        if (powerfactor4 != null ? !powerfactor4.equals(that.powerfactor4) : that.powerfactor4 != null) return false;
        if (positiveActiveEnergy != null ? !positiveActiveEnergy.equals(that.positiveActiveEnergy) : that.positiveActiveEnergy != null)
            return false;
        if (positiveReactiveEnergy != null ? !positiveReactiveEnergy.equals(that.positiveReactiveEnergy) : that.positiveReactiveEnergy != null)
            return false;
        if (reverseActiveEnergy != null ? !reverseActiveEnergy.equals(that.reverseActiveEnergy) : that.reverseActiveEnergy != null)
            return false;
        if (reverseReactiveEnergy != null ? !reverseReactiveEnergy.equals(that.reverseReactiveEnergy) : that.reverseReactiveEnergy != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + address;
        result = 31 * result + (timestramp != null ? timestramp.hashCode() : 0);
        result = 31 * result + (currenta != null ? currenta.hashCode() : 0);
        result = 31 * result + (currentb != null ? currentb.hashCode() : 0);
        result = 31 * result + (currentc != null ? currentc.hashCode() : 0);
        result = 31 * result + (voltagea != null ? voltagea.hashCode() : 0);
        result = 31 * result + (voltageb != null ? voltageb.hashCode() : 0);
        result = 31 * result + (voltagec != null ? voltagec.hashCode() : 0);
        result = 31 * result + (activePower1 != null ? activePower1.hashCode() : 0);
        result = 31 * result + (activePower2 != null ? activePower2.hashCode() : 0);
        result = 31 * result + (activePower3 != null ? activePower3.hashCode() : 0);
        result = 31 * result + (activePower4 != null ? activePower4.hashCode() : 0);
        result = 31 * result + (reactivePower1 != null ? reactivePower1.hashCode() : 0);
        result = 31 * result + (reactivePower2 != null ? reactivePower2.hashCode() : 0);
        result = 31 * result + (reactivePower3 != null ? reactivePower3.hashCode() : 0);
        result = 31 * result + (reactivePower4 != null ? reactivePower4.hashCode() : 0);
        result = 31 * result + (apparentPower1 != null ? apparentPower1.hashCode() : 0);
        result = 31 * result + (apparentPower2 != null ? apparentPower2.hashCode() : 0);
        result = 31 * result + (apparentPower3 != null ? apparentPower3.hashCode() : 0);
        result = 31 * result + (apparentPower4 != null ? apparentPower4.hashCode() : 0);
        result = 31 * result + (powerfactor1 != null ? powerfactor1.hashCode() : 0);
        result = 31 * result + (powerfactor2 != null ? powerfactor2.hashCode() : 0);
        result = 31 * result + (powerfactor3 != null ? powerfactor3.hashCode() : 0);
        result = 31 * result + (powerfactor4 != null ? powerfactor4.hashCode() : 0);
        result = 31 * result + (positiveActiveEnergy != null ? positiveActiveEnergy.hashCode() : 0);
        result = 31 * result + (positiveReactiveEnergy != null ? positiveReactiveEnergy.hashCode() : 0);
        result = 31 * result + (reverseActiveEnergy != null ? reverseActiveEnergy.hashCode() : 0);
        result = 31 * result + (reverseReactiveEnergy != null ? reverseReactiveEnergy.hashCode() : 0);
        return result;
    }
}
