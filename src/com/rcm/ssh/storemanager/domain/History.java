package com.rcm.ssh.storemanager.domain;
// Generated 2017-2-18 12:40:09 by Hibernate Tools 3.2.2.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * History generated by hbm2java
 */
@Entity
@Table(name="historys"
    ,catalog="ssh_store"
)
public class History  implements java.io.Serializable {


     private String id;
     private Good good;
     private Date optiontime;
     private String type;
     private Integer amount;
     private Integer remain;
     private String user;

    public History() {
    }

	
    public History(Date optiontime) {
        this.optiontime = optiontime;
    }
    public History(Good good, Date optiontime, String type, Integer amount, Integer remain, String user) {
       this.good = good;
       this.optiontime = optiontime;
       this.type = type;
       this.amount = amount;
       this.remain = remain;
       this.user = user;
    }
   
     @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="id", unique=true, nullable=false, length=40)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="goodsid")
    public Good getGood() {
        return this.good;
    }
    
    public void setGood(Good good) {
        this.good = good;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="optiontime", nullable=false, length=0)
    public Date getOptiontime() {
        return this.optiontime;
    }
    
    public void setOptiontime(Date optiontime) {
        this.optiontime = optiontime;
    }
    
    @Column(name="_type", length=1)
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    @Column(name="amount")
    public Integer getAmount() {
        return this.amount;
    }
    
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    
    @Column(name="remain")
    public Integer getRemain() {
        return this.remain;
    }
    
    public void setRemain(Integer remain) {
        this.remain = remain;
    }
    
    @Column(name="_user", length=50)
    public String getUser() {
        return this.user;
    }
    
    public void setUser(String user) {
        this.user = user;
    }




}

