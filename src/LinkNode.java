/*
 * LinkNode.java
 *
 */

import java.util.*;
public class LinkNode {
    
    private String empName;
    private String jobTitle;
    private int salary;
    private int yearsEmp;
    private LinkNode next;
    
  
    public LinkNode(String name, String title, int sal, int years) { 
        empName = name;
        jobTitle = title;
        salary = sal;
        yearsEmp = years;
        next = null;
    } // LinkNode()
    
    public void setName(String eName)
    {
        empName = eName;
    }
    
    public String getName(){
            return empName;
    }
    public void setJob(String eJob)
    {
        jobTitle = eJob;
    }
    
    public String getJob(){
            return jobTitle;
    }
    
    public void setSalary(int eSal)
    {
        salary = eSal;
    }
    
    public int getSalary(){
            return salary;
    }
    public void setYears(int eYears)
    {
        yearsEmp = eYears;
    }
    
    public int getYears(){
            return yearsEmp;
    }      
  
    public void setNext(LinkNode nextPtr) {
        next = nextPtr;
    } 
  
    public LinkNode getNext() {
        return next;
    } 
    
    public String getInfo()
    {
        return empName + "\t" + jobTitle + "\t"+ salary + "\t" + yearsEmp;
    }
    
}
