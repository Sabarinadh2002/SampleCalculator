import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;

public class Calculator extends JFrame implements ActionListener{// actionlistener to take actions from switch
	
	

	boolean IsOperatorClicked = false;
	String OldValue;
	String operator = "";
	
	
	JLabel displaylabel;
	JButton sevenbutton,eightbutton,ninebutton,fourbutton,fivebutton,sixbutton,threebutton,
	twobutton,onebutton,dotbutton,minusbutton,plusbutton,multibutton,dividebutton,zerobutton,piButton
	,equalbutton,clearbutton,squareButton,rootButton,backspaceButton,negateButton,percentageButton,logButton;
    
	
	
	public Calculator() {// constructor
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 500);
        setLocationRelativeTo(null);

	    CalculatorPanel mainPanel = new CalculatorPanel();
		mainPanel.setLayout(new BorderLayout(5,5));
		mainPanel.setBackground(Color.decode("#202020"));

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.setBackground(Color.decode("#202020"));
		topPanel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));

		JLabel headingLabel = new JLabel("Sample Calculator");
		headingLabel.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
		headingLabel.setForeground(Color.white);
		headingLabel.setHorizontalAlignment(SwingConstants.LEFT);
		headingLabel.setPreferredSize(new Dimension(300, 30));
		topPanel.add(headingLabel, BorderLayout.NORTH);
		

		displaylabel = new JLabel("0");
        displaylabel.setFont(new Font("Arial", Font.BOLD, 50));
        displaylabel.setHorizontalAlignment(SwingConstants.RIGHT);
        displaylabel.setBackground(Color.decode("#202020"));
        displaylabel.setOpaque(true);
        displaylabel.setForeground(Color.white);
		displaylabel.setPreferredSize(new Dimension(300, 50));
		topPanel.add(displaylabel, BorderLayout.CENTER);

		mainPanel.add(topPanel, BorderLayout.NORTH);
		
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 4, 3, 3));
        buttonPanel.setBackground(Color.decode("#202020"));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(1,1,20,1));


        // Create and add NumberButtons

		negateButton = createOperatorButton("±");
		buttonPanel.add(negateButton);
		percentageButton = createOperatorButton("%");
		buttonPanel.add(percentageButton);
		logButton = createOperatorButton("lg");
		buttonPanel.add(logButton);
		backspaceButton = createOperatorButton("←");
        buttonPanel.add(backspaceButton);

		sevenbutton = createNumberButton("7");
        buttonPanel.add(sevenbutton);
        eightbutton = createNumberButton("8");
        buttonPanel.add(eightbutton);
        ninebutton = createNumberButton("9");
        buttonPanel.add(ninebutton);
		piButton = createOperatorButton("π");
		buttonPanel.add(piButton);
		
        

		fourbutton = createNumberButton("4");
        buttonPanel.add(fourbutton);
        fivebutton = createNumberButton("5");
        buttonPanel.add(fivebutton);
        sixbutton = createNumberButton("6");
        buttonPanel.add(sixbutton);
        multibutton = createOperatorButton("*");
        buttonPanel.add(multibutton);

        onebutton = createNumberButton("1");
        buttonPanel.add(onebutton);
        twobutton = createNumberButton("2");
        buttonPanel.add(twobutton);
        threebutton = createNumberButton("3");
        buttonPanel.add(threebutton);
        minusbutton = createOperatorButton("-");
        buttonPanel.add(minusbutton);

        
        dotbutton = createOperatorButton(".");
        buttonPanel.add(dotbutton);
		zerobutton = createOperatorButton("0");
        buttonPanel.add(zerobutton);
		plusbutton = createOperatorButton("+");
        buttonPanel.add(plusbutton);
		clearbutton = createOperatorButton("C");
        buttonPanel.add(clearbutton);

		squareButton = createOperatorButton("X²");
		buttonPanel.add(squareButton);
		rootButton = createOperatorButton("√");
		buttonPanel.add(rootButton);
		dividebutton = createOperatorButton("/");
        buttonPanel.add(dividebutton);

		equalbutton = createFunctionButton("=");
        buttonPanel.add(equalbutton);
		

        

		JPanel wrapperPanel = new JPanel(new BorderLayout());
		wrapperPanel.setBackground(Color.decode("#202020"));

		
		wrapperPanel.add(buttonPanel, BorderLayout.CENTER);

	    // Add the button panel to the main panel
        mainPanel.add(wrapperPanel, BorderLayout.SOUTH);

        // Set the main panel as the content pane
        setContentPane(mainPanel);

        // Make the frame visible
        setVisible(true);
		
	}

	// Helper methods to create buttons
    private JButton createNumberButton(String text) {
		Color defaultColor = Color.decode("#3b3b3b"); // Default gray
        Color hoverColor = Color.decode("#505050");   // Darker gray on hover
        Color clickColor = Color.decode("#808080");
        RoundedButton button = new RoundedButton(text, defaultColor,hoverColor,clickColor,20, 20);
        button.setFont(new Font("Arial", Font.BOLD, 30));
		button.setForeground(Color.WHITE);
		
		button.addActionListener(this);
        return button;
    }

    private JButton createOperatorButton(String text) {
		Color defaultColor = Color.decode("#333332"); // Default dark
		Color hoverColor = Color.decode("#666666");   // Lighter on hover
		Color clickColor = Color.decode("#999999");   // Even lighter on click
		RoundedButton button = new RoundedButton(text, defaultColor, hoverColor, clickColor, 20, 20);
		button.setFont(new Font("Arial", Font.BOLD, 30));
        button.setForeground(Color.WHITE);
		
		button.addActionListener(this);
        return button;
    }

    private JButton createFunctionButton(String text) {
        Color defaultColor = Color.decode("#da9fe5"); // Default purple
        Color hoverColor = Color.decode("#e0b0f0");   // Brighter purple on hover
        Color clickColor = Color.decode("#b07fb3");   // Darker purple on click
        RoundedButton button = new RoundedButton(text, defaultColor, hoverColor, clickColor, 20, 20);
        button.setFont(new Font("Arial", Font.PLAIN, 30));
        button.setForeground(Color.black);
		
		button.addActionListener(this);
        return button;
    }
	public static void main(String[] args) {
	new Calculator();
	


}


@Override
public void actionPerformed(ActionEvent e) { // Switches
	if (e.getSource() == sevenbutton) {
		handleNumberClick("7");
	} else if (e.getSource() == eightbutton) {
		handleNumberClick("8");
	} else if (e.getSource() == ninebutton) {
		handleNumberClick("9");
	} else if (e.getSource() == sixbutton) {
		handleNumberClick("6");
	} else if (e.getSource() == fivebutton) {
		handleNumberClick("5");
	} else if (e.getSource() == fourbutton) {
		handleNumberClick("4");
	} else if (e.getSource() == threebutton) {
		handleNumberClick("3");
	} else if (e.getSource() == twobutton) {
		handleNumberClick("2");
	} else if (e.getSource() == onebutton) {
		handleNumberClick("1");
	} else if (e.getSource() == zerobutton) {
		handleNumberClick("0");
	} else if (e.getSource() == dotbutton) {
		if (!displaylabel.getText().contains(".")) {
			displaylabel.setText(displaylabel.getText() + ".");
		}
	} else if (e.getSource() == plusbutton) {
		handleOperatorClick("+");
	} else if (e.getSource() == multibutton) {
		handleOperatorClick("*");
	} else if (e.getSource() == dividebutton) {
		handleOperatorClick("/");
	} else if (e.getSource() == minusbutton) {
		handleOperatorClick("-");
	} else if (e.getSource() == equalbutton) {
		handleEqualClick();
	} else if (e.getSource() == clearbutton) {
		clear();
	} else if (e.getSource() == squareButton){
		handleSquareClick();
	} else if (e.getSource() == rootButton){
		handleRootClick();
	} else if (e.getSource() == backspaceButton){
		handleBackSpaceClick();
	} else if (e.getSource() == piButton){
		displaylabel.setText(String.valueOf(Math.PI));
	} else if (e.getSource() == logButton){
		try{
			double value = Double.parseDouble(displaylabel.getText());
			displaylabel.setText(String.valueOf(Math.log10(value)));
		} catch (NumberFormatException ex){
			displaylabel.setText("Invalid input");
		}
	}else if (e.getSource() == negateButton) {
		try {
			double value = Double.parseDouble(displaylabel.getText());
			displaylabel.setText(String.valueOf(value * -1));
		} catch (NumberFormatException ex){
			displaylabel.setText("Invalid input");
		}
	}else if (e.getSource() == percentageButton){
		try {
			double value = Double.parseDouble(displaylabel.getText());
			displaylabel.setText(String.valueOf(value / 100));
		} catch (NumberFormatException ex){
			displaylabel.setText("Invalid input");
		}
	}

}
private void handleNumberClick(String value) {
	if (IsOperatorClicked) {
		displaylabel.setText(value);
		IsOperatorClicked = false;
	} else {
		displaylabel.setText(displaylabel.getText().equals("0") ? value : displaylabel.getText() + value);
	}
}

private void handleOperatorClick(String operator) {
	IsOperatorClicked = true;
	OldValue = displaylabel.getText();
	this.operator = operator;
}

private void handleBackSpaceClick(){
	String currentText = displaylabel.getText();
	if (currentText.length() > 1){
		displaylabel.setText(currentText.substring(0, currentText.length() - 1));
	} else {
		displaylabel.setText("0");
	}
}

private void handleEqualClick() {
	String newValue = displaylabel.getText();
	try {
		float newValuef = Float.parseFloat(newValue);
		float oldValuef = Float.parseFloat(OldValue);

		float result = 0;
		switch (operator) {
			case "+":
				result = oldValuef + newValuef;
				break;
			case "-":
				result = oldValuef - newValuef;
				break;
			case "*":
				result = oldValuef * newValuef;
				break;
			case "/":
				if (newValuef == 0) {
					displaylabel.setText("Error: Division by zero");
					return;
				}
				result = oldValuef / newValuef;
				break;
		}
		displaylabel.setText(result + "");
		IsOperatorClicked = true;
	} catch (NumberFormatException ex) {
		displaylabel.setText("Invalid input");
	}
}

private void clear() {
	displaylabel.setText("0");
	IsOperatorClicked = false;
	OldValue = "";
	operator = "";
}

private void handleSquareClick(){
	try{
		float value = Float.parseFloat(displaylabel.getText());
		float result = value * value;
		displaylabel.setText(result + "");
	}catch(NumberFormatException ex){
		displaylabel.setText("Invalid input");
	}
}

private void handleRootClick(){
	try{
		float value = Float.parseFloat(displaylabel.getText());
		if (value < 0){
			displaylabel.setText("Error: Negative root");
			return;
		}
		double result = Math.sqrt(value);
		displaylabel.setText(result + "");
	}catch (NumberFormatException ex) {
		displaylabel.setText("Invalid input");
	}
}

class RoundedButton extends JButton {
	
	private int arcWidth;
	private int arcHeight;
	private Color hoverBackgroundColor;
	private Color clickBackgroundColor;
	private Color defaultBackgroundColor;

	public RoundedButton (String text, Color backgroundColor,Color hoveColor,Color clickColor, int arcWidth, int arcHeight){
		super(text);
		
		this.defaultBackgroundColor = backgroundColor;
		this.arcWidth = arcWidth;
		this.arcHeight = arcHeight;
		this.hoverBackgroundColor = backgroundColor.brighter();
		this.clickBackgroundColor = backgroundColor.darker();
		
		setFocusPainted(false);
		setBorderPainted(false);
		setOpaque(false);
		setContentAreaFilled(false);

		setBackground(defaultBackgroundColor);

	addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            setBackground(hoverBackgroundColor);
        }

		@Override
		public void mouseExited(MouseEvent e) {
			setBackground(defaultBackgroundColor);
		}
		@Override
		public void mousePressed(MouseEvent e){
			setBackground(clickBackgroundColor);
		}
		@Override
		public void mouseReleased(MouseEvent e){
			setBackground(hoverBackgroundColor);
		}
	});
	}
	@Override
	protected void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setColor(getBackground());
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

		super.paintComponent(g2);

		g2.dispose();
	}
	@Override
	public void setBackground(Color bg){
		super.setBackground(bg);
		repaint();
	}

	@Override
    protected void paintBorder(Graphics g) {
        // Graphics2D g2 = (Graphics2D) g.create();
        // g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // // Optional: Draw a border if needed (comment out if no border is required)
        // g2.setColor(Color.BLACK);
        // g2.setStroke(new BasicStroke(2));
        // g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight);

        // g2.dispose(); // Clean up graphics object
    }

}


public class RoundedBorder extends AbstractBorder {
    private Color color;
    private int thickness;
    private int arcRadius;

    public RoundedBorder(Color color, int thickness, int arcRadius) {
        this.color = color;
        this.thickness = thickness;
        this.arcRadius = arcRadius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(color);
        g2.setStroke(new BasicStroke(thickness));
        g2.drawRoundRect(x, y, width - 1, height - 1, arcRadius, arcRadius);
        
    }

	

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(thickness, thickness, thickness, thickness);
    }


    @Override
    public Insets getBorderInsets(Component c, Insets insets){
		insets.left = insets.right = insets.top = insets.bottom = thickness;
		return insets;
	}
    
}

// Helper method to create a custom border with rounded corners
public class RoundedButtonBorder extends AbstractBorder {
    private int arcWidth;
    private int arcHeight;

    public RoundedButtonBorder(int arcWidth, int arcHeight) {
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        // Graphics2D g2d = (Graphics2D) g.create();
        // g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // g2d.setColor(Color.BLACK); // Border color
        // g2d.drawRoundRect(x, y, width - 1, height - 1, arcWidth, arcHeight);
        // g2d.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(5, 5, 5, 5); // Adjust insets as needed
    }
    
    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}


}
