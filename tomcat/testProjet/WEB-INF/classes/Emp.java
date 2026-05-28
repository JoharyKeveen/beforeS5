public class Emp
{
    int empno;
    public int get_empno()
    {
        return this.empno;
    }
    public void set_empno(int n)
    {
        this.empno=n;
    }
    String ename;
    public String get_ename()
    {
        return this.ename;
    }
    public void set_ename(String n)
    {
        this.ename=n;
    }
    String job;
    public String get_job()
    {
        return this.job;
    }
    public void set_job(String n)
    {
        this.job=n;
    }
    int sal;
    public int get_sal()
    {
        return this.sal;
    }
    public void set_sal(int n)
    {
        this.sal=n;
    }
    int deptno;
    public int get_deptno()
    {
        return this.deptno;
    }
    public void set_deptno(int n)
    {
        this.deptno=n;
    }
    public Emp()
    {}
    public Emp(int em,String ena,String jo,int sa,int dept)
    {
        set_empno(em);
        set_ename(ena);
        set_job(jo);
        set_sal(sa);
        set_deptno(dept);
    }
}