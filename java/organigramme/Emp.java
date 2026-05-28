package object;

public class Emp
{
    int level;
    public int get_level()
    {
        return this.level;
    }
    public void set_level(int l)
    {
        this.level=l;
    }
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
    int mgr;
    public int get_mgr()
    {
        return this.mgr;
    }
    public void set_mgr(int n)
    {
        this.mgr=n;
    }
    String hiredate;
    public String get_hiredate()
    {
        return this.hiredate;
    }
    public void set_hiredate(String n)
    {
        this.hiredate=n;
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
    int comm;
    public int get_comm()
    {
        return this.comm;
    }
    public void set_comm(int n)
    {
        this.comm=n;
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
    Emp[] child;
    public void create_child(int i)
    {
        this.child=new Emp[i];
    }
    public Emp[] get_child()
    {
        return this.child;
    }
    public void set_child(int i,int em,String ena,String jo,int mg,String hire,int sa,int com,int dept)
    {
        this.child[i]=new Emp(em,ena,jo,mg,hire,sa,com,dept);
    }

    public Emp debaO(Emp[] tab) //objet
    {
        for(int i=0;i<tab.length;i++)
        {
            if(tab[i].get_mgr()==0)
            {
                tab[i].set_level(0);
                return tab[i];
            }
        }
        return null;
    }
    public void find_child(Emp[] individu)
    {
        int size=0;
        for(int i=0;i<individu.length;i++)
        {
            if(individu[i].get_mgr()==this.get_empno())
            {
                size++;
            }
        }
        this.create_child(size);
        int inc=0;
        for(int j=0;j<individu.length;j++)
        {
            if(individu[j].get_mgr()==this.get_empno())
            {
                this.set_child(inc,individu[j].get_empno(),individu[j].get_ename(),individu[j].get_job(),individu[j].get_mgr(),individu[j].get_hiredate(),individu[j].get_sal(),individu[j].get_comm(),individu[j].get_deptno());
                inc++;      
            }
        }
    }

    public Emp()
    {}
    public Emp(int em,String ena,String jo,int mg,String hire,int sa,int com,int dept)
    {
        set_empno(em);
        set_ename(ena);
        set_job(jo);
        set_mgr(mg);
        set_hiredate(hire);
        set_sal(sa);
        set_comm(com);
        set_deptno(dept);
    }
}