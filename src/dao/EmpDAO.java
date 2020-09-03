package dao;

import pojo.Emp;

import java.util.List;

public interface EmpDAO {
        public void insert(Emp emp) throws Exception;
        public void update(Emp emp) throws Exception;
        public void delete(int id) throws Exception;
        public Emp findByName(String name) throws Exception;
        public Emp findByNo(int no) throws Exception;
        public List<Emp> findByJobNo(int no) throws Exception;
        public List<Emp> findAll() throws Exception;
}
