package assets;

import connect.*;

import java.util.Date;
import java.util.Vector;
import java.sql.*;

public class Emp
{
    int empno;
    String ename;
    String job;
    int manager;
    Date hiredate;
    int salary;
    int comm;
    int deptno;

    public Emp(){

    }

    public Emp(String ename, String job, int salary) {
        this.setEname(ename);
        this.setJob(job);
        this.setSalary(salary);
    }

    public Emp(int empno, String ename, String job, int manager, int salary, int deptno, Date hirDate) {
        this.setEmpno(empno);
        this.setEname(ename);
        this.setJob(job);
        this.setManager(manager);
        this.setSalary(salary);
        this.setDeptno(deptno);
        this.setHiredate(hirDate);
    }

    

    public Vector<Emp> findByDept(int idDept) {
        ConnectOracle c = new ConnectOracle();
        Connection connect = c.connect();
    
        try {
            Statement stmt = connect.createStatement();
            String req = String.format("select * from emp where deptno = %d", idDept);
            ResultSet resultFromEmp = stmt.executeQuery(req);
            Vector<Emp> render = toObject(resultFromEmp);
            stmt.close();
            connect.close();
            return render;
        } catch (Exception e) {
        }

        return null;
    }

    public Vector<Emp> toObject(ResultSet res) throws Exception {
        Emp em;
        Vector<Emp> render = new Vector<>();
        while (res.next()) {
            em = new Emp(res.getInt("empno"), res.getString("ename"), res.getString("job"), res.getInt("mgr"),
                    res.getInt("sal"), res.getInt("deptno"), res.getDate("hiredate"));
            render.add(em);
        }

        return render;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setComm(int comm) {
        this.comm = comm;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getComm() {
        return comm;
    }

    public int getDeptno() {
        return deptno;
    }

    public int getEmpno() {
        return empno;
    }

    public String getEname() {
        return ename;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public String getJob() {
        return job;
    }

    public int getManager() {
        return manager;
    }

    public int getSalary() {
        return salary;
    }

}