package com.goldencode.gasteiapp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Entry implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer option;

    private double value;
    private String date;
    private boolean recurrent;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public Entry() { }

    public Entry(Integer id, User user, Category category, Option option, double value, String date, boolean recurrent) {
        this.id = id;
        this.user = user;
        this.category = category;
        this.option = option.getCod();
        this.value = value;
        this.date = date;
        this.recurrent = recurrent;
    }

    public Entry(Integer id, User user, Option option, double value, String date, boolean recurrent) {
        this.id = id;
        this.user = user;
        this.option = option.getCod();
        this.value = value;
        this.date = date;
        this.recurrent = recurrent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Option getOption() {
        return Option.toEnum(option);
    }

    public void setOption(Option option) {
        this.option = option.getCod();
    }

    public int getCodOption(Option option) {
        return option.getCod();
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isRecurrent() {
        return recurrent;
    }

    public void setRecurrent(boolean recurrent) {
        this.recurrent = recurrent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry)) return false;
        Entry entry = (Entry) o;
        return getId().equals(entry.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
