import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

class NumberButton extends JButton {
    public NumberButton(String label, ActionListener listener) {
        super(label);
        setFont(new Font("Arial", Font.PLAIN, 40));
        addActionListener(listener);
    }
}

class OperatorButton extends JButton {
    public OperatorButton(String label, ActionListener listener) {
        super(label);
        setFont(new Font("Arial", Font.PLAIN, 40));
        addActionListener(listener);
        // You can add specific styling for operator buttons here if needed
    }
}

class FunctionButton extends JButton {
    public FunctionButton(String label, ActionListener listener) {
        super(label);
        setFont(new Font("Arial", Font.PLAIN, 40));
        addActionListener(listener);
        // You can add specific styling for function buttons here if needed
    }
}