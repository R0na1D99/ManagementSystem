package dao;

import pojo.Emp;
import pojo.Job;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JobDAOImpl implements JobDAO{
    @Override
    public void insert(Job job) throws Exception {
        String sql = "insert into job values(?,?,?)";
        PreparedStatement ps = null;
        Connection conn=null;
        try {
            conn= DBUtils.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,job.getJobno());
            ps.setString(2,job.getJname());
            ps.setString(3,job.getJtype());
            ps.executeUpdate();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(conn!=null)conn.close();
        }
    }

    @Override
    public void update(Job job) throws Exception {
        String sql = "update job set jname=?,jtype=? where jobno=?";
        PreparedStatement ps = null;
        Connection conn=null;
        try {
            conn= DBUtils.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(3,job.getJobno());
            ps.setString(1,job.getJname());
            ps.setString(2,job.getJtype());
            ps.executeUpdate();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(conn!=null)conn.close();
        }
    }

    @Override
    public void delete(int no) throws Exception {
        String sql = "delete from job where jobno=?";
        PreparedStatement ps = null;
        Connection conn=null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, no);
            ps.executeUpdate();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Job> findByName(String name) throws Exception {
        String sql = "select * from job where jname=?";
        PreparedStatement ps = null;
        Connection conn=null;
        List<Job> all = new ArrayList<Job>();
        try {
            conn= DBUtils.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ResultSet rSet = ps.executeQuery();
            while (rSet.next()) {
                Job job = new Job();
                job.setJobno(rSet.getInt(1));
                job.setJname(rSet.getString(2));
                job.setJtype(rSet.getString(3));
                all.add(job);
            }
            rSet.close();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(conn!=null)conn.close();
        }
        return all;
    }

    @Override
    public Job findByNo(int no) throws Exception {
        String sql = "select * from job where jobno=?";
        PreparedStatement ps = null;
        Connection conn=null;
        Job job = new Job();
        try {
            conn= DBUtils.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,no);
            ResultSet rSet = ps.executeQuery();
            if (rSet.next()) {
                job.setJobno(rSet.getInt(1));
                job.setJname(rSet.getString(2));
                job.setJtype(rSet.getString(3));
            }
            rSet.close();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(conn!=null)conn.close();
        }
        return job;
    }

    @Override
    public List<Job> findByType(String type) throws Exception {
        String sql = "select * from job where jtype=?";
        PreparedStatement ps = null;
        Connection conn=null;
        List<Job> all = new ArrayList<Job>();
        try {
            conn= DBUtils.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,type);
            ResultSet rSet = ps.executeQuery();
            while (rSet.next()) {
                Job job = new Job();
                job.setJobno(rSet.getInt(1));
                job.setJname(rSet.getString(2));
                job.setJtype(rSet.getString(3));
                all.add(job);
            }
            rSet.close();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(conn!=null)conn.close();
        }
        return all;
    }

    @Override
    public List<Job> findAll() throws Exception {
        String sql = "select * from job";
        PreparedStatement ps = null;
        Connection conn=null;
        List<Job> all = new ArrayList<Job>();
        try {
            conn= DBUtils.getConnection();
            ps=conn.prepareStatement(sql);
            ResultSet rSet = ps.executeQuery();
            while (rSet.next()) {
                Job job = new Job();
                job.setJobno(rSet.getInt(1));
                job.setJname(rSet.getString(2));
                job.setJtype(rSet.getString(3));
                all.add(job);
            }
            rSet.close();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(conn!=null)conn.close();
        }
        return all;
    }
}
