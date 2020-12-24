package com.oop.employee.model.vo;

public class Run {
   public static void main(String[] args) {
      
      Employee e1 = new Employee();   
      e1.printEmployee();
      
      Employee e2 = new Employee(1,"홍길동",'남',"010-7777-7777");   
      e2.printEmployee();
      
      Employee e3 = new Employee(2, "유관순", '여', "010-3131-3131", "영업부", 3_000_000, 0.15);
      e3.printEmployee();
   }
}