package com.jaya.hibernate;

public class Employee {    //table Employee in hibernate
	
	private int empNo;     //Emp_no number(3) in hibernate
	private String empName; //Emp_name varchar2(20)
	private double empSal;  //Emp_sal number(5)
	
	//For setter getter Alt+shift+s
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}

	
	
	
}
