package com.lyy.dao;

/**
 * @ClassName DepartmentDao
 * @Description 部门表实体类
 * @Author Ice
 * @Date 2022/9/27 15:01
 * @Version 1.0
 **/
public class DepartmentDao {

    private Integer deptno; //部门编号
    private String dname; //部门名称
    private String loc; //城市

    public DepartmentDao(){}

    public DepartmentDao(int deptno, String dname, String loc){
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "DepartmentDao{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
