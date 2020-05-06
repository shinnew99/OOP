public abstract class Employee {
    String name;
    double baseSalary;
    public static int employeeIDCnt = 1;
    int employeeId;
    Employee manager;

    public Employee(String name, double baseSalary){
        //일종의 멤버변수에 파라미터값을 저장해주는 행위라고 보면됌
        this.name = name;
        this.baseSalary = baseSalary;
        this.employeeId = employeeIDCnt;
        employeeIDCnt++;

    }

    public double getBaseSalary(){
        double currentSalary = this.baseSalary;
        return currentSalary;
    }

    public String getName(){
        String currentName = this.name;
        return currentName;
    }

    public int getEmployeeID(){
        return this.employeeId;
    }

    public Employee getManager(){
        return this.manager;
    }

    public boolean equals(Employee other){
        //어떤 employeeId가 새로들어온(입력된) emloyeeId랑 같은지 비교
        if(this.employeeId == other.employeeId){
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        String combination = this.employeeId + " " + this.name;
        return combination;
    }

    public String employeeStatus(){
        //줄 바꾸는 건 "\n"
        String status = this.toString() + " " + this.baseSalary + " " + manager;
        return status;
    }


/*    public static void main(String[] args) {
        Employee employee = new Employee("Martin Grarrix", 5000.0);
        Employee employee2 = new Employee("DJ Snake", 5500.0 );
        Employee employee3 = new Employee("DJ Khalid", 5300.0 );

        System.out.println(employee);
        System.out.println(employee.employeeId);
        System.out.println(employee2.employeeId);
        System.out.println(employee3.employeeId);
        Employee employee4 = new Employee("abcd", 5300.0 );
        System.out.println(employee4.employeeId);

        System.out.println(employee3.toString());
        System.out.println(employee3.employeeStatus());

    }*/

}
