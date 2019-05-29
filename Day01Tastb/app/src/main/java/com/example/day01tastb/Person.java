package com.example.day01tastb;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Person {
    @Id
    private Long lid;
    private String name;
    private int image;
    @Generated(hash = 748470760)
    public Person(Long lid, String name, int image) {
        this.lid = lid;
        this.name = name;
        this.image = image;
    }
    @Generated(hash = 1024547259)
    public Person() {
    }
    public Long getLid() {
        return this.lid;
    }
    public void setLid(Long lid) {
        this.lid = lid;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getImage() {
        return this.image;
    }
    public void setImage(int image) {
        this.image = image;
    }

}
