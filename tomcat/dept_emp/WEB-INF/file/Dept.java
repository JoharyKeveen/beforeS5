import java.util.*;
import java.sql.*;
public class Dept{

private int deptno;
private String dname;
private String loc;
	
	public Dept(int id,String dname)throws Exception{
		set_deptno(id);
		set_dname(dname);
		set_loc();
	}

	public void set_deptno(int id){
		this.deptno=id;
	}
	public void set_dname(String dname){
		this.dname=dname;
	}
	public void set_loc(){
		this.loc="Antananarivo";
	}
	public int get_deptno(){
		return this.deptno;
	}
	public String get_dname(){
		return this.dname;
	}
	public String get_loc(){
		return this.loc;
	}

	public void save()throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connecting=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
		Statement state=connecting.createStatement();
		String sql="insert into dept values("+get_deptno()+","+get_dname()+","+get_loc()+")";
		ResultSet temp=state.executeQuery(sql);
		state.close();
		connecting.close();
	}


	public int get_size_result(String result,Connection connecting)throws SQLException{
		Statement state=connecting.createStatement();
		ResultSet temp=state.executeQuery(result);
		int size=0;
		while(temp.next()){
			size++;
		}
		temp.close();
		state.close();
		return size;
	}

	// public ArrayList<Dept> getAll(){
	// 	Class.forName("oracle.jdbc.driver.OracleDriver");
	// 	Connection connecting=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
	// 	Statement state=connecting.createStatement();
	// 	String sql="select * from dept";
	// 	ResultSet temp=state.executeQuery(sql);
	// 	ArrayList<Dept> result=new ArrayList<Dept>();
	// 	while(temp.next()){
	// 		result.add((ArrayList<Dept>)temp);
	// 	}
	// 	state.close();
	// 	connecting.close();
	// 	return result;
	// }
}