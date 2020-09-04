package dao;

import pojo.Emp;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDAOImpl implements EmpDAO {
    @Override
    public void insert(Emp emp) throws Exception {
        String sql = "insert into emp values(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        Connection conn=null;
        try {
            conn= DBUtils.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,emp.getEmpno());
            ps.setString(2,emp.getEname());
            ps.setString(3,emp.getEpass());
            ps.setInt(4,emp.getEsex());
            ps.setDate(5,emp.getEbirth());
            ps.setString(6,emp.getEidnum());
            ps.setInt(7,emp.getDeptno());
            ps.setInt(8,emp.getJobno());
            ps.setDate(9,emp.getEhiredate());
            ps.setInt(10,emp.getEtype());
            ps.setInt(11,emp.getEsource());
            ps.setString(12,emp.getEstore());
            ps.executeUpdate();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(conn!=null)conn.close();
        }
    }

    public void update(Emp emp) throws Exception {
        String sql = "update emp set empno=?,ename=?,epass=?,esex=?,ebirth=?,eidnum=?,deptno=?,jobno=?,ehiredate=?,etype=?,esource=?,estore=? where empno=?";
        PreparedStatement ps = null;
        Connection conn=null;
        try {
            conn= DBUtils.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,emp.getEmpno());
            ps.setString(2,emp.getEname());
            ps.setString(3,emp.getEpass());
            ps.setInt(4,emp.getEsex());
            ps.setDate(5,emp.getEbirth());
            ps.setString(6,emp.getEidnum());
            ps.setInt(7,emp.getDeptno());
            ps.setInt(8,emp.getJobno());
            ps.setDate(9,emp.getEhiredate());
            ps.setInt(10,emp.getEtype());
            ps.setInt(11,emp.getEsource());
            ps.setString(12,emp.getEstore());
            ps.setInt(13,emp.getEmpno());
            ps.executeUpdate();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(conn!=null)conn.close();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from emp where empno=?";
        PreparedStatement ps = null;
        Connection conn=null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Emp findByName(String name) throws Exception {
        String sql = "select * from emp where ename=?";
        PreparedStatement ps = null;
        Connection conn=null;
        Emp emp = new Emp();
        try {
            conn= DBUtils.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ResultSet rSet = ps.executeQuery();
            if (rSet.next()) {
                emp.setEmpno(rSet.getInt(1));
                emp.setEname(rSet.getString(2));
                emp.setEpass(rSet.getString(3));
                emp.setEsex(rSet.getInt(4));
                emp.setEbirth(rSet.getDate(5));
                emp.setEidnum(rSet.getString(6));
                emp.setDeptno(rSet.getInt(7));
                emp.setJobno(rSet.getInt(8));
                emp.setEhiredate(rSet.getDate(9));
                emp.setEtype(rSet.getInt(10));
                emp.setEsource(rSet.getInt(11));
                emp.setEstore(rSet.getString(12));
            }
            rSet.close();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(conn!=null)conn.close();
        }
        return emp;
    }

    @Override
    public Emp findByNo(int no) throws Exception {
        String sql = "select * from emp where empno=?";
        PreparedStatement ps = null;
        Connection conn=null;
        Emp emp = new Emp();
        try {
            conn= DBUtils.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,no);
            ResultSet rSet = ps.executeQuery();
            if (rSet.next()) {
                emp.setEmpno(rSet.getInt(1));
                emp.setEname(rSet.getString(2));
                emp.setEpass(rSet.getString(3));
                emp.setEsex(rSet.getInt(4));
                emp.setEbirth(rSet.getDate(5));
                emp.setEidnum(rSet.getString(6));
                emp.setDeptno(rSet.getInt(7));
                emp.setJobno(rSet.getInt(8));
                emp.setEhiredate(rSet.getDate(9));
                emp.setEtype(rSet.getInt(10));
                emp.setEsource(rSet.getInt(11));
                emp.setEstore(rSet.getString(12));
            }
            rSet.close();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(conn!=null)conn.close();
        }
        return emp;
    }

    @Override
    public List<Emp> findByJobNo(int no) throws Exception {
        String sql = "select * from emp where jobno=?";
        PreparedStatement ps = null;
        Connection conn=null;
        List<Emp> all = new ArrayList<Emp>();
        try {
            conn= DBUtils.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,no);
            ResultSet rSet = ps.executeQuery();
            while (rSet.next()) {
                Emp emp = new Emp();
                emp.setEmpno(rSet.getInt(1));
                emp.setEname(rSet.getString(2));
                emp.setEpass(rSet.getString(3));
                emp.setEsex(rSet.getInt(4));
                emp.setEbirth(rSet.getDate(5));
                emp.setEidnum(rSet.getString(6));
                emp.setDeptno(rSet.getInt(7));
                emp.setJobno(rSet.getInt(8));
                emp.setEhiredate(rSet.getDate(9));
                emp.setEtype(rSet.getInt(10));
                emp.setEsource(rSet.getInt(11));
                emp.setEstore(rSet.getString(12));
                all.add(emp);
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
    public List<Emp> findAll() throws Exception {
        List<Emp> all = new ArrayList<Emp>();
        String sql = "select * from emp";
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ResultSet rSet = ps.executeQuery();
            while (rSet.next()) {
                Emp emp = new Emp();
                emp.setEmpno(rSet.getInt(1));
                emp.setEname(rSet.getString(2));
                emp.setEpass(rSet.getString(3));
                emp.setEsex(rSet.getInt(4));
                emp.setEbirth(rSet.getDate(5));
                emp.setEidnum(rSet.getString(6));
                emp.setDeptno(rSet.getInt(7));
                emp.setJobno(rSet.getInt(8));
                emp.setEhiredate(rSet.getDate(9));
                emp.setEtype(rSet.getInt(10));
                emp.setEsource(rSet.getInt(11));
                emp.setEstore(rSet.getString(12));
                all.add(emp);
            }
            rSet.close();
            ps.close();
        } catch (Exception e) {
            throw new Exception("findAll出现异常");
        } finally {
            if (conn == null) conn.close();
        }
        return all;
    }
}
