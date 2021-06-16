package javaSocketApp.gui;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WindowClass extends JFrame implements ActionListener{

    public boolean serverStarted = false;
    public boolean serverAccess = false;   

    private JLabel label1 = new JLabel();

    private JButton myButton1;
    private JButton myButton2;
    private JButton newWinBtn;
    private JButton checkButton;

    private JButton serverButton;

    // explicite for chat window (for now)
    JTextField tTextField;
    JPanel jPanel;

    // constructor -> export into other script
    public void windowConstructor(String windowType, String labelContent){

        if (windowType.equals("first")){
            setTitle("Just a Window!");

            this.setSize(400, 400);
            this.setLocationRelativeTo(null); // center window on screen

            // Grab a handle to content pane
            Container c = getContentPane();

            // Sett the layout for the content pane
            c.setLayout(new FlowLayout());

            c.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
            // this.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));

            // LABELS
                // add label to layout
                label1 = new JLabel();

                // add text to label
                label1.setText(labelContent);

                label1.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));

                // add label to the flowlayout
                c.add(label1);

            // BUTTONS
                // add button to the layout
                serverButton = new JButton("ALLOW_CONNECTIONS");
                checkButton = new JButton("check");
                newWinBtn = new JButton("chat-button");

                // add an actionListener
                serverButton.addActionListener(this); // where to send the event -> this (object)
                checkButton.addActionListener(this);
                newWinBtn.addActionListener(this);

                // add buttons to the flowLayout
                c.add(serverButton);
                c.add(checkButton);
                c.add(newWinBtn);

                // BACKGROUND
                    JLabel background;

                    ImageIcon img = new ImageIcon("./img/test.png");

                    // // label1.setIcon(img);
                    background = new JLabel(img);
                    background.setSize(100, 100);
                    // background = new JLabel("LABEL", img, JLabel.CENTER);
                    // background.setBounds(0, 0, this.getBounds().width, this.getBounds().height);

                    // c.add(background);

                    // // System.out.println(background.getBackground());
                    // // System.out.println(background.getMousePosition());
                    // System.out.println(this.getBounds());

            this.setAlwaysOnTop(true);
            this.setVisible(true);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);

            System.out.println("Load main window");

        }else {
            ChatWindowClass chatWindow = new ChatWindowClass();
            chatWindow.chatConstructor(this);
            
            // setTitle("Communication!");

            // // Grab a handle to content pane
            // Container c = getContentPane();

            // // Sett the layout for the content pane
            // c.setLayout(null); // new FlowLayout() ?

            // // chat field & panel (in progress)
            //     tTextField = new JTextField(10); // (10) -> ??

            //     jPanel = new JPanel();

            //     tTextField.setBounds(50, 40, 120, 40);
            //     // tTextField.addCaretListener(this); 

            //     jPanel.setBounds(tTextField.getBounds().x, tTextField.getBounds().y + tTextField.getBounds().height, 600, 600);
            //     jPanel.setOpaque(true);
            //     jPanel.setBackground(Color.CYAN);

            //     c.add(tTextField);
            //     c.add(jPanel);

            // // BUTTONS
            //     // add button to the layout
            //     myButton1 = new JButton("Add_Button");
            //     myButton2 = new JButton("Repaint_Button");

            //     myButton1.setBounds(tTextField.getBounds().x + tTextField.getBounds().width, 30, 130, 40);
            //     myButton2.setBounds(myButton1.getBounds().x + myButton1.getWidth(), 30, myButton1.getBounds().width, myButton1.getBounds().height);

            //     // add an actionListener
            //     myButton1.addActionListener(this); // where to send the event -> this (object)
            //     myButton2.addActionListener(this);

            //     // add buttons to the flowLayout
            //     c.add(myButton1);
            //     c.add(myButton2);

            // this.setSize(400, 400);
            // this.setVisible(true);
            // this.setExtendedState(JFrame.MAXIMIZED_BOTH);

            // System.out.println("Load second window");
        }
        

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        // Check to see which button has been clicked
        if (event.getActionCommand().equals("Add_Button")){
            System.out.println("Add_Button has been clicked");

            String input = tTextField.getText();
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

        }else if (event.getActionCommand().equals("Repaint_Button")){
            System.out.println("Repaint_Button has been clicked");

            jPanel.removeAll();
            jPanel.repaint();

        }else if (event.getActionCommand().equals("REJECT_CONNECTIONS") || event.getActionCommand().equals("ALLOW_CONNECTIONS")){
            serverStarted = true;

            if (serverAccess == false) {
                serverAccess = true;
                serverButton.setName("ALLOW_CONNECTIONS"); // ! does not update
                System.out.println("new Server-connection allowed...");
            } else if (serverAccess == true){
                serverStarted = false;
                serverAccess = false;
                serverButton.setName("REJECT_CONNECTIONS");
                System.out.println("new Server-connection denied...");
                // somehow update Container c 
            }
        
        }else if (event.getActionCommand().equals("CLIENT")){
            System.out.println("Starting client...");
            // ClientApp client = new ClientApp();
            // client.Client(1337); // !! while (true) -> stop process
            
        }else if(event.getActionCommand().equals("chat-button")){
			WindowClass window2 = new WindowClass();
            window2.windowConstructor("second", "Welcome to the chat!");
        }else if(event.getActionCommand().equals("check")){
            System.out.print("Server access: ");
            System.out.println(serverAccess);
        }

    }

}