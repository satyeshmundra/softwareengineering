import javax.swing.JApplet;

public class Contacts_Applet extends JApplet {

	/**
	 * Create the applet.
	 */
	
	public void init()
	{
		Contacts window = new Contacts();
		getContentPane().add(window.frmMenu.getContentPane());
		this.setSize(500 , 500);
		
	}
	//public Contacts_Applet() {

		
		
	//}

}
