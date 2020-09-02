package dao;

import java.util.List;

import pojo.Dept;

public class DeptDAO {
	 public int insertDept(Dept dept) throws Exception;
     public void update(Dept dept) throws Exception;
     public void deleteDept(int deptNo) throws Exception;
     public Emp findByName(String name) throws Exception;
     public Emp findById(String id) throws Exception;
     public List<Emp> showAll() throws Exception;
}
