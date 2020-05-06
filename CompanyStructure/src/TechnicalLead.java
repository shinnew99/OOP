import java.util.ArrayList;

public class TechnicalLead extends SoftwareEngineer{
    TechnicalLead manager;
    ArrayList<SoftwareEngineer> directReports = new ArrayList<>();
    public int headcount = 4;
    public Accountant accountant = null;

    public TechnicalLead(String name) {
        super(name);
        this.baseSalary= 1.3*75000;

    }

    public boolean hasHeadCount() {
        if (directReports.size() > headcount) {
            return false;
        } else {
            return true;
        }
    }

    public boolean addReport(SoftwareEngineer e){
        if( this.headcount !=0 ){
            directReports.add(e);
            e.manager = this;
            return true;
        } else {
            return false;
        }
    }

    public boolean approveCheckIn(SoftwareEngineer e){
        if(this.directReports.contains(e) && e.getCodeAccess() == true && this.getCodeAccess() == true){
            return true;
        } else {
            return false;
        }
    }


    public boolean requestBonus(Employee e, double bonus){
        BusinessLead businessLead = (BusinessLead) accountant.manager;
        if(businessLead.approveBonus(e,bonus)){
            return true;
        }
        return false;
    }


    public String getTeamStatus(){
        String status = this.employeeId + " " + super.name + " has " + this.checkins + "successful check ins ";
        if(directReports.size() ==0 ){
            status += "and no direct reports yet";
        } else {
            status += "is managing:\n";
            for(SoftwareEngineer report : directReports){
                status += report.employeeId + "has " + report.checkins + "successful checkins\n";
            }
        }
        return status;

    }

}
