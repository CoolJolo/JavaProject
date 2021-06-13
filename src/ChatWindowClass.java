import java.awt.Color;

import javax.swing.*;
import javax.swing.event.*;

public class ChatWindowClass extends JFrame implements CaretListener{

    JTextField tTextField;
    JPanel jPanel;

    private CreateLabelsDynamically chatWindow;

    public void chatConstructor(WindowClass window){

        setTitle("CHAT");
        setSize(800, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

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

    // everytime, clicked/tiped on/in tTextField / other events defined
    @Override
    public void caretUpdate(CaretEvent e) {
        String input = tTextField.getText();

        jPanel.removeAll();

        // ~~ grobe Strukture ~~
            // String[] replyChat // user inputs after scanning of vulgar language

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
