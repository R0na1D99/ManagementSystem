package dao;

import pojo.Emp;
import pojo.Job;

import java.util.List;

public interface JobDAO {
    public void insert(Job job) throws Exception;
    public void update(Job job) throws Exception;
    public void delete(int no) throws Exception;
    public List<Job> findByName(String name) throws Exception;
    public Job findByNo(int no) throws Exception;
    public List<Job> findByType(String type) throws Exception;
    public List<Job> findAll() throws Exception;
}
