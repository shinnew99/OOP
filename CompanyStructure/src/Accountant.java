public class Accountant extends BusinessEmployee{

    public double budget = 0;
    TechnicalLead teamSupporting = null;

    public Accountant(String name) {
        super(name);
        int bonusBudget = 0;
    }

    public TechnicalEmployee getTeamSupported(){
        return this.teamSupporting;
    }

    public void supportTeam(TechnicalLead lead){
        teamSupporting = lead;
        lead.accountant = this;
        double bonusBudget = 0.0;
        for(SoftwareEngineer sw : lead.directReports){
            bonusBudget += sw.baseSalary;
        }
        budget += bonusBudget * 1.1;

    }

    public boolean approveBonus(double bonus){
        if (budget>=bonus){
            return true;
        }
        return false;
    }

    public String employeeStatus(){
        String status = this.employeeId + " " + this.name + "with a budget of " + this.budget + " is supporting " + this.teamSupporting.name;

        return status;
    }


}
