package dao;

import java.util.List;

import pojo.Dept;

public interface DeptDAO {
     public void update(Dept dept) throws Exception;
     public void deleteDept(int deptNo) throws Exception;
     public Dept findByName(String name) throws Exception;
     public Dept findById(String id) throws Exception;
     public List<Dept> showAll() throws Exception;
}
