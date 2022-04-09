import Views.ViewCreate;

//TODO
//Delete method on UML
//Put model as parameter of view

public class Main {

	public static void main(String[] args) {
			Model model = new Model();
			ViewMenu viewMenu = new ViewMenu(model);
			ViewCreate viewCreate = new ViewCreate(model);
			ViewDeposit viewDeposit = new ViewDeposit(model);
			ViewView viewView = new ViewView(model);
			Controller controller = new Controller(model,viewMenu,viewCreate,viewDeposit,viewView);
			
			viewMenu.setVisible(true);
	}

}
