import modelController.Controller;
import modelController.Model;
import views.*;

//TODO
//Delete method on UML

public class Main {

	public static void main(String[] args) {
			Model model = new Model();
			ViewMenu viewMenu = new ViewMenu(model);
			ViewCreate viewCreate = new ViewCreate(model);
			ViewDeposit viewDeposit = new ViewDeposit(model);
			ViewView viewView = new ViewView(model);
			ViewSelect viewSelect = new ViewSelect(model);
			Controller controller = new Controller(model,viewMenu,viewCreate,viewDeposit,viewView,viewSelect);
			viewMenu.setVisible(true);
	}

}
