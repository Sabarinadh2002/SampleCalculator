import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Calculator extends JFrame implements ActionListener{// actionlistener to take actions from switch
	
	

	boolean IsOperatorClicked = false;
	String OldValue;
	String operator = "";
	
	JFrame jf;
	JLabel displaylabel;
	JButton sevenbutton,eightbutton,ninebutton,fourbutton,fivebutton,sixbutton,threebutton,
	twobutton,onebutton,dotbutton,minusbutton,plusbutton,multibutton,dividebutton,zerobutton
	,equalbutton,clearbutton;
    
	
	
	public Calculator() {// constructor
		jf =new JFrame("Calculator");
		jf.setLayout(null);
		jf.setSize(600, 600);
		jf.setLocation(300, 150);

	    CalculatorPanel mainPanel = new CalculatorPanel();
		mainPanel.setLayout(null);

		
		displaylabel = new JLabel();
        displaylabel.setBounds(30, 50, 540, 40);
        displaylabel.setBackground(Color.gray);
        displaylabel.setHorizontalAlignment(SwingConstants.RIGHT); 

        displaylabel.setForeground(Color.white);
        displaylabel.setOpaque(true); 

        mainPanel.add(displaylabel);

        // Create and add NumberButtons
		zerobutton = new NumberButton("0", this);
		zerobutton.setBounds(30, 400, 80, 80);
		
		mainPanel.add(zerobutton);
		
		onebutton = new NumberButton("1", this);
		onebutton.setBounds(30, 310, 80, 80);
		mainPanel.add(onebutton);
		
		twobutton = new NumberButton("2", this);
		twobutton.setBounds(120, 310, 80, 80);
		mainPanel.add(twobutton);
		
		threebutton = new NumberButton("3", this);
		threebutton.setBounds(210, 310, 80, 80);
		mainPanel.add(threebutton);
		
		fourbutton = new NumberButton("4", this);
		fourbutton.setBounds(30, 220, 80, 80);
		mainPanel.add(fourbutton);
		
		fivebutton = new NumberButton("5", this);
		fivebutton.setBounds(120, 220, 80, 80);
		mainPanel.add(fivebutton);
		
		sixbutton = new NumberButton("6", this);
		sixbutton.setBounds(210, 220, 80, 80);
		mainPanel.add(sixbutton);
		
		sevenbutton = new NumberButton("7", this);
		sevenbutton.setBounds(30, 130, 80, 80);
		mainPanel.add(sevenbutton);
		
		eightbutton = new NumberButton("8", this);
		eightbutton.setBounds(120, 130, 80, 80);
		mainPanel.add(eightbutton);
		
		ninebutton = new NumberButton("9", this);
		ninebutton.setBounds(210, 130, 80, 80);
		mainPanel.add(ninebutton);
        // Create and add OperatorButtons
        plusbutton = new OperatorButton("+", this);
        plusbutton.setBounds(300, 130, 80, 80);
        mainPanel.add(plusbutton);

        minusbutton = new OperatorButton("-", this);
        minusbutton.setBounds(300, 220, 80, 80);
        mainPanel.add(minusbutton);

        multibutton = new OperatorButton("*", this); // Create a button for multiplication (*)
        multibutton.setBounds(300, 310, 80, 80);
        mainPanel.add(multibutton);

        dividebutton = new OperatorButton("/", this);
        dividebutton.setBounds(300, 400, 80, 80);
        mainPanel.add(dividebutton);

        // Create and add FunctionButtons
        dotbutton = new FunctionButton(".", this);
        dotbutton.setBounds(120, 400, 80, 80);
        mainPanel.add(dotbutton);

        equalbutton = new FunctionButton("=", this);
        equalbutton.setBounds(210, 400, 80, 80);
        mainPanel.add(equalbutton);

        clearbutton = new FunctionButton("C", this);
        clearbutton.setBounds(390, 400, 80, 80);
        mainPanel.add(clearbutton);

		jf.setContentPane(mainPanel);	
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
	}
public static void main(String[] args) {
	new Calculator();
	


}

class CalculatorPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Define the gradient colors
        Color startColor  = new Color(0x0033cc); // Light Gray
        Color endColor = new Color(0xcc33ff); // Slightly Darker Gray

        // Create the gradient paint
        GradientPaint gp = new GradientPaint(0, 0, startColor, 0, getHeight(), endColor);
        g2d.setPaint(gp);

        // Fill the panel with the gradient
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}
@Override
public void actionPerformed(ActionEvent e) { // Switches
	if (e.getSource()== sevenbutton) {
		if (IsOperatorClicked) {
			displaylabel.setText("7");
			IsOperatorClicked =false;
			
		}else {
		displaylabel.setText(displaylabel.getText()+"7");}
				
	}else if (e.getSource()== eightbutton) {
		if(IsOperatorClicked) {
			displaylabel.setText("8");
			IsOperatorClicked =false;}
		else {
		displaylabel.setText(displaylabel.getText()+"8");}
	}else if (e.getSource()== ninebutton) {
		if(IsOperatorClicked) {
			displaylabel.setText("9");
			IsOperatorClicked =false;}
		else {
		displaylabel.setText(displaylabel.getText()+"9");}
	}else if (e.getSource()== sixbutton) {
		if(IsOperatorClicked) {
			displaylabel.setText("6");
			IsOperatorClicked =false;}
		else {
		displaylabel.setText(displaylabel.getText()+"6");}
	}else if (e.getSource()== fivebutton) {
		if(IsOperatorClicked) {
			displaylabel.setText("5");
			IsOperatorClicked =false;}
		else {
		displaylabel.setText(displaylabel.getText()+"5");}
	}else if (e.getSource()== fourbutton) {
		if(IsOperatorClicked) {
			displaylabel.setText("4");
			IsOperatorClicked =false;}
		else {
		displaylabel.setText(displaylabel.getText()+"4");}
	}else if (e.getSource()== threebutton) {
		if(IsOperatorClicked) {
			displaylabel.setText("3");
			IsOperatorClicked =false;}
		else {
		displaylabel.setText(displaylabel.getText()+"3");}
	}else if (e.getSource()== twobutton) {
		if(IsOperatorClicked) {
			displaylabel.setText("2");
			IsOperatorClicked =false;}
		else {
		displaylabel.setText(displaylabel.getText()+"2");}
	}else if (e.getSource()== onebutton) {
		if(IsOperatorClicked) {
			displaylabel.setText("1");
			IsOperatorClicked =false;}
		else {
		displaylabel.setText(displaylabel.getText()+"1");}
	}else if (e.getSource()== zerobutton) {
		if(IsOperatorClicked) {
			displaylabel.setText("0");
			IsOperatorClicked =false;}
		else {
		displaylabel.setText(displaylabel.getText()+"0");
	}	
    }else if (e.getSource() == dotbutton){
		if (!displaylabel.getText().contains(".")) {
			displaylabel.setText(displaylabel.getText()+".");
		}
		
	}else if (e.getSource()== plusbutton) {
		
		IsOperatorClicked = true;	
		OldValue = displaylabel.getText();
		operator = "+";
		//displaylabel.setText(displaylabel.getText()+"+");
	}else if (e.getSource()== multibutton) {
		IsOperatorClicked = true;
		OldValue = displaylabel.getText();
		operator = "*";
//		displaylabel.setText(displaylabel.getText()+"*");
	}else if (e.getSource()== dividebutton) {
		IsOperatorClicked = true;
		OldValue = displaylabel.getText();
		operator = "/";
	//	displaylabel.setText(displaylabel.getText()+"/");
	}else if (e.getSource()==minusbutton) {
		IsOperatorClicked = true;
		OldValue = displaylabel.getText();
		operator = "-";
	//	displaylabel.setText(displaylabel.getText()+"-");
	}else if (e.getSource()== equalbutton) {
		String NewValue = displaylabel.getText();
		try{
		float NewValuef = Float.parseFloat(NewValue);
		float OldValuef = Float.parseFloat(OldValue);
		
		float result = 0;
		switch (operator) {
			case "+":
				result = OldValuef + NewValuef;
				break;
			case "-":
				result = OldValuef - NewValuef;
				break;
			case "*":
				result = OldValuef * NewValuef;
				break;
			case "/":
				if (NewValuef == 0){
					displaylabel.setText("Error: Division by zero");
					return;
				}		
			    result = OldValuef / NewValuef;
				break;
		}
		displaylabel.setText(result + "");
		IsOperatorClicked = true;
	} catch (NumberFormatException ex){
		displaylabel.setText("Invalid input");
	}
		
	}else if (e.getSource() == clearbutton){
		displaylabel.setText("");
		IsOperatorClicked = false;
		OldValue = "";
		operator = "";
	}
}}
