// import java.awt.Color;
// import java.awt.GradientPaint;
// import java.awt.Graphics;
// import java.awt.Graphics2D;

// import javax.swing.JPanel;

// class CalculatorPanel extends JPanel {
//     @Override
//     protected void paintComponent(Graphics g) {
//         super.paintComponent(g);
//         Graphics2D g2d = (Graphics2D) g;

//         // Define the gradient colors
//         Color startColor = new Color(0xF0F0F0); // Light Gray
//         Color endColor = new Color(0xD3D3D3); // Slightly Darker Gray

//         // Create the gradient paint
//         GradientPaint gp = new GradientPaint(0, 0, startColor, 0, getHeight(), endColor);
//         g2d.setPaint(gp);

//         // Fill the panel with the gradient
//         g2d.fillRect(0, 0, getWidth(), getHeight());
//     }
// }
