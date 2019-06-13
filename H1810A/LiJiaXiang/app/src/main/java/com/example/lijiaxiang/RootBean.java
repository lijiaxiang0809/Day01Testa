package com.example.lijiaxiang;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class RootBean {
    @Id
    @Property(nameInDb = "lid")
    private Long lid;
    private int id;
    private int image;
    private String title;
    private String url;
    private int type;
    @Generated(hash = 1428678873)
    public RootBean(Long lid, int id, int image, String title, String url,
            int type) {
        this.lid = lid;
        this.id = id;
        this.image = image;
        this.title = title;
        this.url = url;
        this.type = type;
    }
    @Generated(hash = 636722272)
    public RootBean() {
    }
    public Long getLid() {
        return this.lid;
    }
    public void setLid(Long lid) {
        this.lid = lid;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getImage() {
        return this.image;
    }
    public void setImage(int image) {
        this.image = image;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }

}
