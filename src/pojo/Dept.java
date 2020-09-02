package pojo;

import java.sql.Date;

/*
 * 部门表
 */
public class Dept {
//  1.字段名
	private int deptNo;
	private String dName;
	private String dTel;
	private Date dBirth;
	
//  2.生成get/set方法	
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getdTel() {
		return dTel;
	}
	public void setdTel(String dTel) {
		this.dTel = dTel;
	}
	public Date getdBirth() {
		return dBirth;
	}
	public void setdBirth(Date dBirth) {
		this.dBirth = dBirth;
	}
	
//  3.重写toString方法
	@Override
	public String toString() {
		return "Dept [deptNo=" + deptNo + ", dName=" + dName + ", dTel=" + dTel + ", dBirth=" + dBirth + "]";
	}
	
//  4.生成所需要的构造方法
    public Dept() {
	    super();
    }
    public Dept(int deptNo, String dName, String dTel, Date dBirth) {
	   super();
	   this.deptNo = deptNo;
	   this.dName = dName;
	   this.dTel = dTel;
	   this.dBirth = dBirth;
    }
	public Dept(int deptNo, String dName, String dTel) {
		super();
		this.deptNo = deptNo;
		this.dName = dName;
		this.dTel = dTel;
	}
            


	
	
}
