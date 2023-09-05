import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Calculator implements ActionListener{// actionlistener to take actions from switch
	
	
	boolean IsOperatorClicked = false;
	String OldValue;
	
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
		
		displaylabel = new JLabel(); // to label something
		displaylabel.setBounds(30, 50, 540, 40);
		displaylabel.setBackground(Color.gray);
		displaylabel.setHorizontalAlignment(SwingConstants.RIGHT);
		displaylabel.setForeground(Color.white);
		displaylabel.setOpaque(true);
		jf.add(displaylabel);
		
		sevenbutton =new JButton("7") ;//button 7
		sevenbutton.setFont(new Font("Arial",Font.PLAIN,40));
		sevenbutton.addActionListener(this);
		sevenbutton.setBounds(30, 130, 80, 80);
		jf.add(sevenbutton);
		
		eightbutton =new JButton("8") ;//button 8
		eightbutton.setFont(new Font("Arial",Font.PLAIN,40));
		eightbutton.addActionListener(this);
		eightbutton.setBounds(120, 130, 80, 80);
		jf.add(eightbutton);
		
		ninebutton =new JButton("9") ;//button 9
		ninebutton.setFont(new Font("Arial",Font.PLAIN,40));
		ninebutton.setBounds(210, 130, 80, 80);
		ninebutton.addActionListener(this);
		jf.add(ninebutton);
		
		fourbutton =new JButton("4") ;//button 4
		fourbutton.setFont(new Font("Arial",Font.PLAIN,40));
		fourbutton.setBounds(30,220, 80, 80);
		fourbutton.addActionListener(this);
		jf.add(fourbutton);
		
		fivebutton =new JButton("5") ;//button 5
		fivebutton.setFont(new Font("Arial",Font.PLAIN,40));
		fivebutton.addActionListener(this);
		fivebutton.setBounds(120,220, 80, 80);
		jf.add(fivebutton);
		
		sixbutton =new JButton("6") ;//button 6
		sixbutton.setFont(new Font("Arial",Font.PLAIN,40));
		sixbutton.addActionListener(this);
		sixbutton.setBounds(210,220, 80, 80);
		jf.add(sixbutton);
		
		onebutton =new JButton("1") ;//button 1
		onebutton.setFont(new Font("Arial",Font.PLAIN,40));
		onebutton.addActionListener(this);
		onebutton.setBounds(30,310, 80, 80);
		jf.add(onebutton);
		
		twobutton =new JButton("2") ;//button 2
		twobutton.setFont(new Font("Arial",Font.PLAIN,40));
		twobutton.addActionListener(this);
		twobutton.setBounds(120,310, 80, 80);
		jf.add(twobutton);
		
		threebutton =new JButton("3") ;//button 3
		threebutton.setFont(new Font("Arial",Font.PLAIN,40));
		threebutton.setBounds(210,310, 80, 80);
		threebutton.addActionListener(this);
		jf.add(threebutton);
		
		zerobutton =new JButton("0") ;//button 0
		zerobutton.setFont(new Font("Arial",Font.PLAIN,40));
		zerobutton.setBounds(30,400, 80, 80);
		zerobutton.addActionListener(this);
		jf.add(zerobutton);
		

		equalbutton =new JButton("=") ;//button =
		equalbutton.setFont(new Font("Arial",Font.PLAIN,40));
		equalbutton.setBounds(210,400, 80, 80);
		equalbutton.addActionListener(this);
		jf.add(equalbutton);
		
		plusbutton =new JButton("+") ;//button =
		plusbutton.setFont(new Font("Arial",Font.PLAIN,40));
		plusbutton.setBounds(300,130, 80, 80);
		plusbutton.addActionListener(this);
		jf.add(plusbutton);
		
		minusbutton =new JButton("-") ;//button =
		minusbutton.setFont(new Font("Arial",Font.PLAIN,40));
		minusbutton.setBounds(300,220, 80, 80);
		minusbutton.addActionListener(this);
		jf.add(minusbutton);
		
		multibutton =new JButton("*") ;//button =
		multibutton.setFont(new Font("Arial",Font.PLAIN,40));
		multibutton.setBounds(300,310, 80, 80);
		multibutton.addActionListener(this);
		jf.add(multibutton);
		
		dividebutton =new JButton("/") ;//button =
		dividebutton.setFont(new Font("Arial",Font.PLAIN,40));
		dividebutton.setBounds(300,400, 80, 80);
		dividebutton.addActionListener(this);
		jf.add(dividebutton);
		
		dotbutton =new JButton(".") ;//button =
		dotbutton.setFont(new Font("Arial",Font.PLAIN,40));
		dotbutton.setBounds(120,400, 80, 80);
		dotbutton.addActionListener(this);
		jf.add(dotbutton);
		
		clearbutton =new JButton("C") ;//button =
		clearbutton.setFont(new Font("Arial",Font.PLAIN,40));
		clearbutton.setBounds(390,400, 80, 80);
		clearbutton.addActionListener(this);
		jf.add(clearbutton);
		
		
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
	}
public static void main(String[] args) {
	new Calculator();
	


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
		displaylabel.setText(displaylabel.getText()+"0");}		
	}else if (e.getSource()== equalbutton) {
		String NewValue = displaylabel.getText();
		float NewValuef = Float.parseFloat(NewValue);
		float OldValuef = Float.parseFloat(OldValue);
		
		float result = OldValuef+NewValuef;
		displaylabel.setText(result+"");
		
		//displaylabel.setText(displaylabel.getText()+"=");
	}else if (e.getSource()== plusbutton) {
		
		IsOperatorClicked = true;	
		OldValue = displaylabel.getText();
		//displaylabel.setText(displaylabel.getText()+"+");
	}else if (e.getSource()== multibutton) {
//		displaylabel.setText(displaylabel.getText()+"*");
	}else if (e.getSource()== dividebutton) {
	//	displaylabel.setText(displaylabel.getText()+"/");
	}else if (e.getSource()== dotbutton) {
		//displaylabel.setText(displaylabel.getText()+".");
	}else if (e.getSource()==minusbutton) {
	//	displaylabel.setText(displaylabel.getText()+"-");
	}else if (e.getSource()== clearbutton) {
		displaylabel.setText("");
		//displaylabel.setText("");
	
}
}}
