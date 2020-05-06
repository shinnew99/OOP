public abstract class TechnicalEmployee extends Employee{

    public int checkins = 10;
    public TechnicalEmployee(String name) {
        super(name, 75000);
    }


    public TechnicalEmployee(String name, int checkins) {
        super(name, 75000);
        this.checkins = checkins;
    }

    public String employeeStatus(){

        String currentStatus = this.employeeId + " " + this.name + "\n"
                + "has " + checkins + "successful check ins";
        return currentStatus;
    }
}
