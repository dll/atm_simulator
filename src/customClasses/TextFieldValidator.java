package customClasses;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TextFieldValidator 
{
	/** The regular expression used to validate*/
	private String regExp;
	/** The error color for the border of the field to validate*/
	private Color errorColor;
	/** The field to be validated*/
	private JTextField target;
	private String type;
	
	/**Constructor that receives the textfield and the color to use in case of validation does not pass
	 @param myTarget the textfield to validate
	 @param myErrorColor the color to use in case of validation does not pass
	  */
	public TextFieldValidator(JTextField myTarget, Color myErrorColor, String myType)
	{
		regExp = "\\w";
		target = myTarget;
		errorColor = myErrorColor;
		type = myType;
	};
	
	
	/**Constructor that receives the textfield, sets default color to RED
	 @param myTarget the textfield to validate
	 */
	public TextFieldValidator(JTextField myTarget, String myType)
	{
		
		this(myTarget,Color.RED, myType);
		
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
		if(type == "MONEY")
		{
			if(target.getText().matches(regExp))
			{
				
				if(Double.parseDouble(target.getText())>0)
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
			else
			{
				target.setBorder(BorderFactory.createLineBorder(errorColor));
				return false;
			}
		}
		else
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
		
	}
	/**
     * Validates if text field passes the validation
     * @return true if text field passes the validation and false if it does not pass
     */
	public Boolean checkWithdraw(double balance, double fee) 
	{
		if(type == "MONEY")
		{
			if(target.getText().matches(regExp))
			{
				System.out.println(Double.parseDouble(target.getText()));
				if(Double.parseDouble(target.getText())>0 && Double.parseDouble(target.getText())<=(balance - fee))
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
			else
			{
				target.setBorder(BorderFactory.createLineBorder(errorColor));
				return false;
			}
		}
		else
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
		
	}
	
	
	
	/**
     * Resets text field to default color
    */
	public void reset()
	{
		target.setBorder(null);
	}
}

