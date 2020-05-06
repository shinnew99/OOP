public class SoftwareEngineer extends TechnicalEmployee{

    boolean codeprivileges= false;
    TechnicalLead manager;

    public SoftwareEngineer(String name) {
        super(name,0);
    }

    public boolean getCodeAccess(){
        return this.codeprivileges;
    }

    public void setCodeAccess(boolean access){
        if(access == true){
            this.codeprivileges = true;
        } else {
            this.codeprivileges = false;
        }
    }

    public int getSuccessfulCheckIns(){
        return super.checkins;
    }

    public boolean checkInCode() {
        if (manager.getCodeAccess() == true) {
            super.checkins++;
            return true;
        } else {
            return false;
        }

    }
}
