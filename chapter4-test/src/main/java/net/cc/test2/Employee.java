package net.cc.test2;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by zhonghua on 15/11/19.
 */
public class Employee {

    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        hireDay = calendar.getTime();
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    private String name;
    private double salary;
    private Date hireDay;


    public static void main(String[] args) {

        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 100, 2015, 10, 19);
        staff[1] = new Employee("Harry Hacker", 200, 2014, 1, 1);
        staff[2] = new Employee("Tony  Tester", 300, 2013, 1, 1);

        for(Employee e : staff){
            e.raiseSalary(5);
        }

        for(Employee e : staff){
            System.out.println(e.getName() + "\t" + e.getSalary() + "\t" + e.getHireDay());
        }

        System.out.println(staff[0].name);
    }
}
