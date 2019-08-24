package com.jiema.entity.common;


import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "menu")
public class Menu {
    // 菜单id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //菜单编码
    private String code;
    // 菜单名称
    private String name;
    // 父菜单code
    private String parentCode;
    //节点层级
    private String level;
    // 菜单url
    private String url;
    // 菜单图标
    private String icon;
    // 菜单顺序
    private String sn;
    //菜单创建时间
    private Date creatTime;
    //是否展开状态（默认false）
    private Boolean spread;
    //节点打开方式（即a的target值），必须href设定后才有效
    private String target;

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", parentCode='" + parentCode + '\'' +
                ", level='" + level + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", sn='" + sn + '\'' +
                ", creatTime=" + creatTime +
                ", spread=" + spread +
                ", target='" + target + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return id == menu.id &&
                Objects.equals(code, menu.code) &&
                Objects.equals(name, menu.name) &&
                Objects.equals(parentCode, menu.parentCode) &&
                Objects.equals(level, menu.level) &&
                Objects.equals(url, menu.url) &&
                Objects.equals(icon, menu.icon) &&
                Objects.equals(sn, menu.sn) &&
                Objects.equals(creatTime, menu.creatTime) &&
                Objects.equals(spread, menu.spread) &&
                Objects.equals(target, menu.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, parentCode, level, url, icon, sn, creatTime, spread, target);
    }

    public Boolean getSpread() {
        return spread;
    }

    public void setSpread(Boolean spread) {
        this.spread = spread;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

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

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}
