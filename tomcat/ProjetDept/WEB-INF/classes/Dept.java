package assets;

import connect.*;

import java.sql.*;
import java.util.Vector;

public class Dept {
    int deptno;
    String deptName;
    String location;

    public Dept() {
    }

    public Dept(int deptno, String deptName, String location) {
        this.deptno = deptno;
        this.deptName = deptName;
        this.location = location;
    }

    public void save() {
        ConnectOracle c = new ConnectOracle();
        Connection connect = c.connect();

        try {
            Statement stmt = connect.createStatement();
            String req = String.format("insert into dept values(%d,'%s','%s')", getDeptno(), getDeptName(), getLocation());
            stmt.executeUpdate(req);
            connect.commit();
            stmt.close();
            connect.close();
        } catch (Exception e) {
        }
    }

    public Vector<Dept> getAll() {
        ConnectOracle c = new ConnectOracle();
        Connection connect = c.connect();

        try {
            Statement stmt = connect.createStatement();
            String req = String.format("select * from dept");
            ResultSet resultFromDept = stmt.executeQuery(req);
            Vector<Dept> render = toObject(resultFromDept);
            stmt.close();
            connect.close();
            return render;

        } catch (Exception e) {
        }

        return null;
    }

    public Vector<Dept> toObject(ResultSet res) throws Exception {
        Dept d;
        Vector<Dept> render = new Vector<>();
        while (res.next()) {
            d = new Dept(res.getInt("deptno"),res.getString("dname"),res.getString("loc"));
            render.add(d);
        }

        return render;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDeptName() {
        return deptName;
    }

    public int getDeptno() {
        return deptno;
    }

    public String getLocation() {
        return location;
    }
}