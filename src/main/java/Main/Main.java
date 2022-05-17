package Main;

import Controller.Controller;
import View.*;

public class Main {

    public static void main(String[] args) {
        FirstView firstView=new FirstView();
        RegisterView registerView = new RegisterView();


        EmployeeView employeeView=new EmployeeView();
        Controller controller = new Controller(firstView,registerView,employeeView);


    }
}
