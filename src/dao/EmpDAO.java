package dao;

import pojo.Emp;

import java.util.List;

public interface EmpDAO {
        public void insert(Emp emp) throws Exception;
        public void update(Emp emp) throws Exception;
        public void delete(String id) throws Exception;
        public Emp findByName(String name) throws Exception;
        public Emp findById(String id) throws Exception;
        public List<Emp> showAll() throws Exception;
}
