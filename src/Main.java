import modelController.Controller;
import modelController.Model;
import views.*;

//TODO
//Delete method on UML,ask if there is destruction to do or something
//When clic cancel error, no textfied validator to reset (Possible Solution on resetin view reset border color, or maybe just take out the reset of the validator) 
//Hacer Lista Scrollable
//Poner formato $0.00 en reporte
//When select, make it disappear
//Menu buttons disabled when there is nothing (when done save do this)
//Validate Withdraw not higher than current amount 
//SAVE/LOAD save is when quit (ask Sean)


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
