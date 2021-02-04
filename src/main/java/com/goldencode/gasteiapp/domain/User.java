package com.goldencode.gasteiapp.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.goldencode.gasteiapp.domain.Option;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    private String email;
    private String password;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Entry> entry = new ArrayList<>();

    public User() {
    }

    public User(Integer id, String fullName, String email, String password) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public int getCount(){
        int count = 0;
        for (int i = 0; i < entry.size(); i++) {
            count++;
        }
        return count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Entry> getEntry() {
        return entry;
    }

    public double getTotalSpend(){
        double totalSpend = 0;
        for (Entry obj : this.entry) {
            if (obj.getOption().getCod() == 1){
                totalSpend = totalSpend + obj.getValue();
            }
        }
        return totalSpend;
    }

    public double getTotalGain(){
        double totalGain = 0;
        for (Entry obj : this.entry) {
            if (obj.getOption().getCod() == 2){
                totalGain = totalGain + obj.getValue();
            }
        }
        return totalGain;
    }

    public double getBalance(){
        return (getTotalGain()-getTotalSpend());
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
