package inheritance.book;

public class Manager extends Employee {
    private double bonus;

    public Manager() {
        super();
    }

    public Manager(double salary) {
        super(salary);
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

    @Override
    public void show(){
        System.out.println("this show in Manager");
    }

}
