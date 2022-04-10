package customClasses;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class TextFieldValidator 
{
	/** The regular expression used to validate*/
	private String regExp;
	/** The error color for the border of the field to validate*/
	private Color errorColor;
	/** The field to be validated*/
	private JTextField target;
	
	/**Constructor that receives the textfield and the color to use in case of validation does not pass
	 @param myTarget the textfield to validate
	 @param myErrorColor the color to use in case of validation does not pass
	  */
	public TextFieldValidator(JTextField myTarget, Color myErrorColor)
	{
		regExp = "\\w";
		target = myTarget;
		errorColor = myErrorColor;
	};
	
	
	/**Constructor that receives the textfield, sets default color to RED
	 @param myTarget the textfield to validate
	 */
	public TextFieldValidator(JTextField myTarget)
	{
		
		this(myTarget,Color.RED);
		
	};
	
	
	/**
     * Sets the regular expression
     * @param myRegExp the regular expression
     */
	public void setRegExp(String myRegExp)
	{
		regExp = myRegExp;
	}
	
	/**
     * Sets the Error Color
     * @param myColor the color to use to set
     */
	public void setErrorColor(Color myColor)
	{
		errorColor = myColor;
	}
	
	/**
     * Validates if text field passes the validation
     * @return true if text field passes the validation and false if it does not pass
     */
	public Boolean check() 
	{
		if(target.getText().matches(regExp))
		{
			target.setBorder(null);
			return true;
		}
		else
		{
			target.setBorder(BorderFactory.createLineBorder(errorColor));
			return false;
		}
	}
	
	/**
     * Resets text field to default color
    */
	public void reset()
	{
		target.setBorder(null);
	}
}

