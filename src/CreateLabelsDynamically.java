import java.awt.Color;

import javax.swing.*;
import javax.swing.event.*;

public class CreateLabelsDynamically extends JFrame implements CaretListener{

    JTextField tTextField;
    JPanel jPanel;

    
    public CreateLabelsDynamically() {
        
        tTextField = new JTextField(10); // (10) -> ??
        jPanel = new JPanel();


        setLayout(null);

        tTextField.setBounds(50, 20, 50, 30);
        tTextField.addCaretListener(this);

        jPanel.setBounds(50, 80, 200, 200);
        jPanel.setOpaque(true);
        jPanel.setBackground(Color.CYAN);

        add(tTextField);
        add(jPanel);

    }

    public static void main(String args[]) {

        CreateLabelsDynamically c = new CreateLabelsDynamically();
        c.setTitle("FRAME");
        c.setSize(300, 500);
        c.setVisible(true);
        c.setLocationRelativeTo(null);
        c.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // everytime, clicked/tiped on/in tTextField / other events defined
    @Override
    public void caretUpdate(CaretEvent e) {
        String input = tTextField.getText();

        jPanel.removeAll();

        if (!input.equals("")) {
            int num = Integer.parseInt(input);
            JLabel jLables[] = new JLabel[num]; // list of lables

            for (JLabel jLabel : jLables) {
                jLabel = new JLabel("Label");
                jPanel.add(jLabel);
            }
        }
        jPanel.validate();
        jPanel.repaint();
    }
}
