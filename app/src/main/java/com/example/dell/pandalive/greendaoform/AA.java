package com.example.dell.pandalive.greendaoform;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by dell on 2017/8/23.
 */

@Entity
public class AA {

    @Id
    Long id;
    @Property(nameInDb = "str")
    String str;
    public String getStr() {
        return this.str;
    }
    public void setStr(String str) {
        this.str = str;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1171193063)
    public AA(Long id, String str) {
        this.id = id;
        this.str = str;
    }
    @Generated(hash = 1749961025)
    public AA() {
    }


}
