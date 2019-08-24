package com.jiema.entity.common;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    // 菜单id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //角色编码
    private String code;
    // 角色名称
    private String name;
    //角色权限菜单
    @OneToMany
    private List<Menu> Menu;
    //菜单创建时间
    private Date creatTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<com.jiema.entity.common.Menu> getMenu() {
        return Menu;
    }

    public void setMenu(List<com.jiema.entity.common.Menu> menu) {
        Menu = menu;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}
