package dao;

import pojo.Emp;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class EmpDAOImpl implements EmpDAO {
    @Override
    public void insert(Emp emp) throws Exception {

    }

    @Override
    public void update(Emp emp) throws Exception {

    }

    @Override
    public void delete(String id) throws Exception {

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
    public Emp findById(String id) throws Exception {
        return null;
    }

    @Override
    public List<Emp> showAll() throws Exception {
        return null;
    }
}
