/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Achyl
 */
public class EmploieeService {
    int EmployeeId;
    int ServiceId;
    double dureeminuteEmployee;

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int EmployeeId) {
        this.EmployeeId = EmployeeId;
    }

    public int getServiceId() {
        return ServiceId;
    }

    public void setServiceId(int ServiceId) {
        this.ServiceId = ServiceId;
    }

    public double getDureeminuteEmployee() {
        return dureeminuteEmployee;
    }

    public void setDureeminuteEmployee(double dureeminuteEmployee) {
        this.dureeminuteEmployee = dureeminuteEmployee;
    }

    public EmploieeService() {
    }

    public EmploieeService(int EmployeeId, int ServiceId, double dureeminuteEmployee) {
        this.EmployeeId = EmployeeId;
        this.ServiceId = ServiceId;
        this.dureeminuteEmployee = dureeminuteEmployee;
    }
    
}
