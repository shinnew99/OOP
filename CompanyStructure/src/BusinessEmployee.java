public abstract class BusinessEmployee extends Employee{

    public double budget=0;
    double bonusBudget;

    public BusinessEmployee(String name) {
        super(name, 50000);
        //this.name =
    }

    public double getBonusBudget(){
        return bonusBudget;
    }
    public String employeeStatus(){

        int checkins = 10;
        String status = this.employeeId + " " + this.name + "\n"
                + "with a budget of " + budget;
        return status;
    }
}
