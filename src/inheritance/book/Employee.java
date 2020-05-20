package inheritance.book;

public class Employee {
    private double salary;

    public Employee() {
    }

    public Employee(double salary){
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void show(){
        System.out.println("this show in Employee");
    }
}
