import java.util.*;
public class Emp{
	
	int empno;
	String ename;
	String job;
	double sal;
	int deptno;
	int mgr;
	Date hiredate;
	int comm;

	public Emp(int empno,String ename,String job,double sal,int deptno,int mgr,Date hiredate,int comm)throws Exception {
		set_empno(empno);
		set_ename(ename);
		set_job(job);
		set_sal(sal);
		set_deptno(deptno);
		set_mgr(mgr);
		set_hiredate(hiredate);
		set_comm(comm);
	}
	public void set_empno(int empno)throws Exception{
		if (empno>0) {
			this.empno=empno;
		}
		else throw new Exception("miala-tsiny");
	}public void set_mgr(int mgr)throws Exception{
		if (mgr>=0) {
			this.mgr=mgr;
		}
		else throw new Exception("Iza no maitre");
	}
	public void set_hiredate(Date hiredate)throws Exception{
		if (hiredate!=null) {
			this.hiredate=hiredate;
		}
		else throw new Exception("Verifier la date");
	}
	public void set_ename(String ename)throws Exception{
		if (ename!="") {
			this.ename=ename;
		}
		else throw new Exception("Mr le vide");
	}
	public void set_job(String job)throws Exception{
		if (this.job!=" ") {
			this.job=job;
		}
		else throw new Exception("Nga somera");
	}
	public void set_sal(double sal)throws Exception{
		if (sal>0) {
			this.sal=sal;
		}
		else throw new Exception("Mpanambaka vahoaka");
	}
	public void set_deptno(int deptno)throws Exception{
		if (deptno>0) {
			this.deptno=deptno;
		}
		else throw new Exception("Kely loatra");
	}
	public void set_comm(int comm)throws Exception{
		if (comm>0) {
			this.comm=comm;
		}
		else throw new Exception("comm ent ca?");
	}

	public int get_empno(){
		return this.empno;
	}
	public String get_ename(){
		return this.ename;
	}
	public String get_job(){
		return this.job;
	}
	public double get_sal(){
		return this.sal;
	}
	public int get_deptno(){
		return this.deptno;
	}
	public int get_mgr(){
		return this.mgr;
	}
	public Date get_hiredate(){
		return this.hiredate;
	}
	public int get_comm(){
		return this.comm;
	}
}