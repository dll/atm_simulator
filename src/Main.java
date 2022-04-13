import modelController.Controller;
import modelController.Model;
import views.*;

//TODO
//Hacer Lista Scrollable
//Validate Withdraw FEEEEEEEE not higher than current amount
//Move window listner to controller ASK SEAN
//Only if you have time load the last account you were working with, its because the model starts with the curremtaccount user in 0
//ADT

public class Main {

	public static void main(String[] args) {
			Model model = new Model();
			ViewMenu viewMenu = new ViewMenu(model);
			ViewCreate viewCreate = new ViewCreate(model);
			ViewDeposit viewDeposit = new ViewDeposit(model);
			ViewView viewView = new ViewView(model);
			ViewSelect viewSelect = new ViewSelect(model);
			ViewDelete viewDelete = new ViewDelete(model);
			ViewWithdraw viewWithdraw = new ViewWithdraw(model);
			Controller controller = new Controller(model,viewMenu,viewCreate,viewDeposit,viewView,viewSelect,viewDelete, viewWithdraw);
			viewMenu.setVisible(true);
	}
}
