package com.thecoffeshop.entity;
// Generated Nov 20, 2018 8:44:18 AM by Hibernate Tools 5.1.7.Final

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Price generated by hbm2java
 */
@Entity
@Table(name = "price", catalog = "theshopcoffee")
public class Price implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "PRICEID", unique = true, nullable = false)
    private int priceid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCTID")
    private Product product;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "STARTDATETIME", length = 19)
    private Date startdatetime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ENDDATETIME", length = 19)
    private Date enddatetime;

    @Column(name = "PRICE")
    private Integer price;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATEAT", length = 19)
    private Date updateat;

    @Column(name = "ISDELETE")
    private Boolean isdelete;

    public Price() {
    }

    public Price(int priceid) {
        this.priceid = priceid;
    }

    public Price(int priceid, Product product, Date startdatetime, Date enddatetime, Integer price, Date updateat,
                 Boolean isdelete) {
        this.priceid = priceid;
        this.product = product;
        this.startdatetime = startdatetime;
        this.enddatetime = enddatetime;
        this.price = price;
        this.updateat = updateat;
        this.isdelete = isdelete;
    }


    public int getPriceid() {
        return this.priceid;
    }

    public void setPriceid(int priceid) {
        this.priceid = priceid;
    }


    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public Date getStartdatetime() {
        return this.startdatetime;
    }

    public void setStartdatetime(Date startdatetime) {
        this.startdatetime = startdatetime;
    }


    public Date getEnddatetime() {
        return this.enddatetime;
    }

    public void setEnddatetime(Date enddatetime) {
        this.enddatetime = enddatetime;
    }


    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getUpdateat() {
        return this.updateat;
    }

    public void setUpdateat(Date updateat) {
        this.updateat = updateat;
    }

    public Boolean getIsdelete() {
        return this.isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }

}
