package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Dept;
import utils.DBUtils;

/**
 *  Dept实现类
 */
public class DeptDaoImpl {
    /*
     * 添加数据
     */
	public int insertDept(Dept dept) throws Exception {
//      1.定义相关对象
		Connection conn = null;
		PreparedStatement pstm = null;
//      2.连接数据库
		conn= DBUtils.getConnection();
//      3.定义SQL语句
		String sql="insert into dept values(?,?,?,?)";
		try {
            //	4.获取语句对象
			pstm=conn.prepareStatement(sql);
//			5.给占位符赋值
			pstm.setInt(1, dept.getDeptNo());
			pstm.setString(2, dept.getdName());
			pstm.setString(3, dept.getdTel());
			pstm.setDate(4, dept.getdBirth());
//		    6.运行
			int i=pstm.executeUpdate();
			return i;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
//                  7.回收资源
					pstm.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
//		    
		return 0;
	}
	
    /*
     * 删除数据
     */
	public int deleteDept(int deptNo) throws Exception {
//		1.定义相关对象
		Connection conn = null;
		PreparedStatement pstm = null;
//      2.连接数据库
		conn=DBUtils.getConnection();
//      3.定义SQL语句
		String sql="delete from dept where deptno=?";
		try {
//	  	    4.获取语句对象
			pstm=conn.prepareStatement(sql);
//			5.给占位符赋值		
			pstm.setInt(1,deptNo);
//		    6.运行
			int i=pstm.executeUpdate();
			return i;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
//              7.回收资源
				pstm.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;

	}
    /*
     * 修改数据
     */
	public void updateDept(Dept dept) throws Exception {
//		1.定义对象
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
//      2.连接数据库			
		conn=DBUtils.getConnection();
//      3.定义SQL语句		
		String sql="update dept set set dname=?,dtel=?,dbirth=? where deptno=?";	
		try {
//		  4.获取语句对象
			pstm=conn.prepareStatement(sql);
//			5.给占位符赋值		
			pstm.setString(1, dept.getdName());
			pstm.setString(2, dept.getdTel());
			pstm.setDate(3, dept.getdBirth());
			pstm.setInt(4, dept.getDeptNo());
//		    6.运行
			pstm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
    /*
     * 查询数据
     */
	public Dept selectDept(String dName) throws Exception {
		
//		1.定义对象
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
//      2.连接数据库			
		conn=DBUtils.getConnection();
//      3.定义SQL语句		
		String sql="select * from dept where dname=?";		
		try {
//		    4.获取语句对象
			pstm= conn.prepareStatement(sql);
//			5.给占位符赋值		
			pstm.setString(1, dName);
//		    6.运行
			rs=pstm.executeQuery();
			if(rs.next()) {
				Dept dept =new Dept(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4));
				return dept;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
//              7.关闭连接
				pstm.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		return null;
	}
	
    /*
     * 全查询数据
     */	
	public List<Dept> selectDeptList() throws Exception{
//		1.定义对象
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
//      2.连接数据库			
		conn=DBUtils.getConnection();
//      3.定义SQL语句		
		String sql="select * from dept";	

		try {
//		    4.获取语句对象
			pstm= conn.prepareStatement(sql);
//		    6.运行
			rs=pstm.executeQuery();
			List<Dept> list = new ArrayList<Dept>();
			while(rs.next()) {
				Dept dept = new Dept(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4));
				list.add(dept);
			}
			return list;				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
//          7.关闭连接
			try {
				pstm.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return null;
	}
}
