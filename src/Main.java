import modelController.Controller;
import modelController.Model;
import views.*;

//TODO
//Validate Withdraw FEEEEEEEE not higher than current amount
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
