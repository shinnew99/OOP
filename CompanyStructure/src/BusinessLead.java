import java.util.ArrayList;

public class BusinessLead extends Accountant{

    ArrayList<Accountant> directReports = new ArrayList<>();
    public int headCount = 10;

    public BusinessLead(String name) {
        super(name);
        this.baseSalary = 2.0 * 50000;
    }

    public boolean hasHeadCount(){
        if (directReports.size() < headCount ) {
            return true;
        }
        return false;
    }

    public boolean addReport(Accountant e, TechnicalLead supportTeam){
        if(this.headCount!=0) {
            directReports.add(e);
            this.bonusBudget *= e.baseSalary*1.1;
            e.supportTeam(supportTeam);
            e.manager = this;
            return false;
        }
        return true;
    }


    public boolean requestBonus(Employee e, double bonus){
        if(bonus <= this.budget){
            this.budget -= bonus;
            e.baseSalary += bonus;
            return true;
        }
        return false;
    }

    
    public boolean approveBonus(Employee e, double bonus){//TODO
        for(Accountant accountant : directReports){
            if(accountant.getTeamSupported() == e.getManager()) {
                if (requestBonus(e, bonus)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getTeamStatus(){
        String status = this.employeeId + " " + this.name + " has " + this.bonusBudget + "of bonus budget";

        return status;
    }
}
