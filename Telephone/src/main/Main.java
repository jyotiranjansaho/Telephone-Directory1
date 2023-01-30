package main;

import java.util.List;
import java.util.Scanner;

import dao.Dao;
import telephone.Employee;

public class Main {
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

Employee emp=new Employee();
Dao d=new Dao();
while(true)
{
	System.out.println("1:ctreate telephone offoce ");
	System.out.println("2:create consumer");
	System.out.println("3:insert Telephone office");
	System.out.println("4:insert consumer");
	System.out.println("5:update data");
	System.out.println("6:join data");
	System.out.println("7:Search all details");
	System.out.println("8:order by");
	System.out.println("9:group by");
	
	System.out.println("10:exit");
	System.out.println("chose option");
	int op=sc.nextInt();
	switch(op)
	{
	case 1:
		d.telephone(emp);
		break;
	case 2:
		d.Consumer(emp);
		break;
	case 3:
		System.out.println("enter telephone id");
		int tid=sc.nextInt();
		sc.nextLine();
		System.out.println("enter telephonet name");
		String tname=sc.nextLine();
		System.out.println("enter telephone exchange address");
		String exchang_address=sc.nextLine();
		System.out.println("enter telephone city code");
		String city_code=sc.nextLine();
		emp.setTid(tid);
		emp.setTname(tname);
		emp.setExchang_address(exchang_address);
		emp.setCity_code(city_code);
		
		d.insertOffice(emp);
		break;
	case 4:
		
		System.out.println("enter consumer id");
		int cid=sc.nextInt();
		sc.nextLine();
		System.out.println("enter consumer mob no");
		String mob=sc.nextLine();

		
		System.out.println("enter consumer name");
		String name=sc.nextLine();
		System.out.println("enter consumer Address");
		String address=sc.nextLine();
		System.out.println("enter consumer age");
		int age=sc.nextInt();
		System.out.println("enter consumer foreign key");
		int ttid=sc.nextInt();
		emp.setCid(cid);
		emp.setMob(mob);
		emp.setName(name);
		emp.setAddress(address);
		emp.setAge(age);
		emp.setTtid(ttid);
		d.insertConsumer(emp);
		break;
	case 5:
	
		System.out.println("enter telephone id");
		 tid=sc.nextInt();
		sc.nextLine();
		System.out.println("enter telephone exchange address");
	 exchang_address=sc.nextLine();
		emp.setExchang_address(exchang_address);
		emp.setTid(tid);
		d.update(emp);
	
		break;
	case 6:
		List<Employee> employees=d.getEmployees();
		System.out.print("tid:"+"\t");
		System.out.print("tname:"+"\t");
		System.out.print("Exchange_ID:"+"\t");
		System.out.print("city_code"+"\t");
		System.out.print("cid"+"\t");
		System.out.print("mob:"+"\t"+"\t");
		System.out.print("name:"+"\t"+"\t"+"\t"+"\t");
		System.out.print("address:"+"\t");
		
		System.out.print("age:"+"\t");
		System.out.println("ttid:"+"\t");
		for(Employee emps:employees)
		{
			System.out.print(emps.getTid());
		System.out.print("\t"+emps.getTname());
			System.out.print("\t"+emps.getExchang_address());
			System.out.print("\t"+"\t"+emps.getCity_code());
			System.out.print("\t"+"\t"+emps.getCid());
			System.out.print("\t"+emps.getMob());
			System.out.print("\t"+emps.getName());
			System.out.print("\t"+"\t"+emps.getAddress());
		
			System.out.print("\t"+emps.getAge());
			System.out.println("\t"+emps.getTtid());
		}
		break;
		
	case 7:
		System.out.println("enter the mob");
		mob=sc.next();
    	d.such(mob);
    	break;
	case 8:
		List<Employee> employees1=d.getEmployees();
		for(Employee emps:employees1)
		{
			System.out.println("tid:"+emps.getTid());
			System.out.println("tname:"+emps.getTname());
				//System.out.print("\t"+emps.getExchang_address());
				System.out.println("City_code"+emps.getCity_code());
				//System.out.print("\t"+"\t"+emps.getCid());
				//System.out.print("\t"+emps.getMob());
				System.out.println("name:"+emps.getName());
				System.out.println("Address:"+emps.getAddress());
			
				//System.out.print("\t"+emps.getAge());
				//System.out.println("\t"+emps.getTtid());
			}
		break;
	case 9:
		List<Employee> employees2=d.getEmployees();
		for(Employee emps:employees2)
		{
			System.out.println("tid:"+emps.getTid());
			System.out.println("tname:"+emps.getTname());
				//System.out.print("\t"+emps.getExchang_address());
				System.out.println("City_code"+emps.getCity_code());
				//System.out.print("\t"+"\t"+emps.getCid());
				//System.out.print("\t"+emps.getMob());
				System.out.println("name:"+emps.getName());
				System.out.println("Address:"+emps.getAddress());
			
				//System.out.print("\t"+emps.getAge());
				//System.out.println("\t"+emps.getTtid());
			}	
		break;
	case 10:
		System.exit(0);
	default:
		System.out.println("Enter valid option");
		
	}
}

	}

}
