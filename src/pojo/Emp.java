package pojo;

import java.sql.Date;

public class Emp {
    private int empno;
    private String ename;
    private String epass;
    private int esex;
    private Date ebirth;
    private String eidnum;
    private int deptno;
    private int jobno;
    private Date ehiredate;
    private int etype;
    private int esource;
    private String estore;

    public String getEstore() {
        return estore;
    }

    public void setEstore(String estore) {
        this.estore = estore;
    }

    public Emp(){
        empno=-1;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEpass() {
        return epass;
    }

    public void setEpass(String epass) {
        this.epass = epass;
    }

    public int getEsex() {
        return esex;
    }

    public void setEsex(int esex) {
        this.esex = esex;
    }

    public Date getEbirth() {
        return ebirth;
    }

    public void setEbirth(Date ebirth) {
        this.ebirth = ebirth;
    }

    public String getEidnum() {
        return eidnum;
    }

    public void setEidnum(String eidnum) {
        this.eidnum = eidnum;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public int getJobno() {
        return jobno;
    }

    public void setJobno(int jobno) {
        this.jobno = jobno;
    }

    public Date getEhiredate() {
        return ehiredate;
    }

    public void setEhiredate(Date ehiredate) {
        this.ehiredate = ehiredate;
    }

    public int getEtype() {
        return etype;
    }

    public void setEtype(int etype) {
        this.etype = etype;
    }

    public int getEsource() {
        return esource;
    }

    public void setEsource(int esource) {
        this.esource = esource;
    }
}
