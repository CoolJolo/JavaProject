package javaSocketApp.gui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import javaSocketApp.client.ClientClass;

public class Window {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 410, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBackground(new Color(176, 224, 230));
		toolBar.setBounds(0, 0, 398, 38);
		frame.getContentPane().add(toolBar);
		
		JButton startButton = new JButton("START");
		startButton.setForeground(new Color(255, 255, 255));
		startButton.setBackground(new Color(0, 153, 204));
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// here -> START SERVER 
			}
		});
		startButton.setToolTipText("start the server");
		toolBar.add(startButton);
		
		JButton chatButton = new JButton("CHAT");
		chatButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// here -> OPEN CHAT-WINDOW
			}
		});
		
		JToggleButton allowConnectionsToggleButton = new JToggleButton("allow connections");
		allowConnectionsToggleButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// here -> SET ALLOWCONNECTIONS = TRUE
			}
			
		});
		allowConnectionsToggleButton.setBackground(new Color(0, 153, 204));
		allowConnectionsToggleButton.setForeground(new Color(255, 255, 255));
		toolBar.add(allowConnectionsToggleButton);
		chatButton.setToolTipText("start the server");
		chatButton.setForeground(Color.WHITE);
		chatButton.setBackground(new Color(0, 153, 204));
		toolBar.add(chatButton);
		
		JButton clientButton_1 = new JButton("CLIENT");
		clientButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClientClass client = new ClientClass();
	            client.clientConstructor(1337); // !! while (true) -> stop process
			}
		});
		clientButton_1.setToolTipText("start the client");
		clientButton_1.setForeground(Color.WHITE);
		clientButton_1.setBackground(new Color(0, 153, 204));
		toolBar.add(clientButton_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(175, 238, 238));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(0, 37, 398, 228);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		ImageIcon img = new ImageIcon("/img/test.png");
		
	}
}
