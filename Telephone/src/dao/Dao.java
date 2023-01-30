package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import telephone.Employee;
public class Dao {
	static Connection con;
	static PreparedStatement ps;
	static ResultSet rs;
	public static Connection getCon()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ jrscompany","root","root");
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		if(con!=null)
			System.out.println("connection success");
		return con;
	}
	public void telephone(Employee emp)
	{ 
		con=Dao.getCon();
		try
		{
		ps=con.prepareStatement("create table telephone( tid int(10) primary key,tname varchar(20)not null,exchange_address varchar(20)not null,city_code varchar(20))");
	int r=ps.executeUpdate();
	if(r==1)
	System.out.println("create telephone Office successfull");
	}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	public void Consumer(Employee emp)
	{
		con=Dao.getCon();
		try
		{
			ps=con.prepareStatement("create table consumer1(cid int (10) primary key,mob varchar(20) unique,name varchar(20)not null,address varchar(20) not null,age int(10),ttid int(10),foreign key(ttid)references telephone(tid))");
			int r1=ps.executeUpdate();
			if(r1==1)
				System.out.println("consumer table success");
		}
		catch(Exception e)
		{
			e.getMessage();
		
			
		}
	}
	
	public void insertOffice(Employee emp)
	{
		con=Dao.getCon();
		try
		{
			ps=con.prepareStatement("insert into telephone values(?,?,?,?)");
			ps.setInt(1,emp.getTid());
			ps.setString(2,emp.getTname());
			ps.setString(3,emp.getExchang_address());
			ps.setString(4,emp.getCity_code());
			int r=ps.executeUpdate();
			if(r==1)
				System.out.println("office insert success");
		}
		catch(Exception e)
		{
			e.getMessage();
			
		}
		
	}
	public void insertConsumer(Employee emp)
	{
		con=Dao.getCon();
		try
		{
			ps=con.prepareStatement("insert into consumer1 values(?,?,?,?,?,?)");
			ps.setInt(1,emp.getCid());
			ps.setString(2,emp.getMob());
			ps.setString(3,emp.getName());
			ps.setString(4,emp.getAddress());
			ps.setInt(5,emp.getAge());
			ps.setInt(6, emp.getTtid());
			int c=ps.executeUpdate();
			if(c==1)
				System.out.println("consumer1 insert succes");
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	
	
public void update(Employee emp)
{
	con=Dao.getCon();
	try
	{
		ps=con.prepareStatement("update telephone set exchange_address=? where tid=?");
				ps.setString(1,emp.getExchang_address());
		ps.setInt(2,emp.getTid());
		int r=ps.executeUpdate();
		if(r==1)
			System.out.println("update success");
	}
	catch(Exception e)
	{
		e.getMessage();
	}
}
public List<Employee> getEmployees()
{
	con=Dao.getCon();
	List<Employee> emps=new ArrayList<Employee>();
	try
	{
		ps=con.prepareStatement("select * from telephone join consumer1 on telephone.tid=consumer1.ttid");
		rs=ps.executeQuery();
		
		while(rs.next())
		{
			Employee emp=new Employee();
			emp.setTid(rs.getInt(1));
			emp.setTname(rs.getString(2));
            emp.setExchang_address(rs.getString(3));
			emp.setCity_code(rs.getString(4));
			emp.setCid(rs.getInt(5));
			emp.setMob(rs.getString(6));
			emp.setName(rs.getString(7));
			emp.setAddress(rs.getString(8));
			
			emp.setAge(rs.getInt(9));
			emp.setTtid(rs.getInt(10));
			emps.add(emp);
		}
	}
		catch(Exception e)
		{
			e.getMessage();
			System.out.println("join success");
		}
	return emps;
	}
public void such(String mob)

{
	con=Dao.getCon();
	
	try
	{
		ps=con.prepareStatement("select *from telephone join consumer1 on telephone.tid=consumer1.ttid where mob=?");
		ps.setString(1,mob);
		rs=ps.executeQuery();
		while(rs.next())
		{
	System.out.println(rs.getInt(1));
	System.out.println(rs.getString(2));
	System.out.println(rs.getString(3));
	System.out.println(rs.getString(4));
	System.out.println(rs.getInt(5));
	System.out.println(rs.getString(6));
	System.out.println(rs.getString(7));
	System.out.println(rs.getString(8));
	System.out.println(rs.getInt(9));
	System.out.println(rs.getInt(10));
		}
		
	}
	catch(Exception e)
	{
		e.getMessage();
		System.out.println("such success");
	}
	
}
public List<Employee> getEmployees1()
{
	con=Dao.getCon();
	List<Employee> emps=new ArrayList<Employee>();
	try
	{
ps=con.prepareStatement("select tid,tname,city_code,name,address telephone join consumer1 on telephone.tid=consumer1.ttid order by tid desc");
rs=ps.executeQuery();
while(rs.next())
{
	 Employee emp=new Employee();
	emp.setTid(rs.getInt(1));
	emp.setTname(rs.getString(2));
   // emp.setExchang_address(rs.getString(3));
	emp.setCity_code(rs.getString(3));
	//emp.setCid(rs.getInt(5));
	//emp.setMob(rs.getString(6));
	emp.setName(rs.getString(4));
	emp.setAddress(rs.getString(5));
	emps.add(emp);
	
	//emp.setAge(rs.getInt(9));
	//emp.setTtid(rs.getInt(10));
}}
catch(Exception e)	
	{
	e.getMessage();
	System.out.println("desc success");
	}
	return emps;
}
public List<Employee> getEmployees2()
{
	con=Dao.getCon();
	List<Employee> emps=new ArrayList<Employee>();
	try
	{
ps=con.prepareStatement("select tid,tname,city_code,name,address telephone join consumer1 on telephone.tid=consumer1.ttid group by tname");
rs=ps.executeQuery();
while(rs.next())
{
	 Employee emp=new Employee();
	emp.setTid(rs.getInt(1));
	emp.setTname(rs.getString(2));
   // emp.setExchang_address(rs.getString(3));
	emp.setCity_code(rs.getString(3));
	//emp.setCid(rs.getInt(5));
	//emp.setMob(rs.getString(6));
	emp.setName(rs.getString(4));
	emp.setAddress(rs.getString(5));
	emps.add(emp);
	
	//emp.setAge(rs.getInt(9));
	//emp.setTtid(rs.getInt(10));
}}
catch(Exception e)	
	{
	e.getMessage();
	System.out.println("desc success");
	}
	return emps;
}
}



