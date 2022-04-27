package me.timo;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b6;
	private JButton b7;
	private JButton b8;
	private JButton b9;
	private JLabel lblNewLabel_2,
				pointsBlueLabel,
				pointsRedLabel;

	private Boolean currentPlayerBlue = true;
	private int pointsBlue = 0,
				pointsRed = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 357, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		b1 = new JButton("");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				markButton(b1);
			}
		});
		b1.setFont(new Font("Tahoma", Font.BOLD, 55));
		b1.setBounds(10, 66, 100, 100);
		contentPane.add(b1);
		
		b2 = new JButton("");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				markButton(b2);
			}
		});
		b2.setFont(new Font("Tahoma", Font.BOLD, 55));
		b2.setBounds(120, 66, 100, 100);
		contentPane.add(b2);
		
		b3 = new JButton("");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				markButton(b3);
			}
		});
		b3.setFont(new Font("Tahoma", Font.BOLD, 55));
		b3.setBounds(230, 66, 100, 100);
		contentPane.add(b3);
		
		b4 = new JButton("");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				markButton(b4);
			}
		});
		b4.setFont(new Font("Tahoma", Font.BOLD, 55));
		b4.setBounds(10, 177, 100, 100);
		contentPane.add(b4);
		
		b5 = new JButton("");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				markButton(b5);
			}
		});
		b5.setFont(new Font("Tahoma", Font.BOLD, 55));
		b5.setBounds(120, 177, 100, 100);
		contentPane.add(b5);
		
		b6 = new JButton("");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				markButton(b6);
			}
		});
		b6.setFont(new Font("Tahoma", Font.BOLD, 55));
		b6.setBounds(230, 177, 100, 100);
		contentPane.add(b6);
		
		b7 = new JButton("");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				markButton(b7);
			}
		});
		b7.setFont(new Font("Tahoma", Font.BOLD, 55));
		b7.setBounds(10, 288, 100, 100);
		contentPane.add(b7);
		
		b8 = new JButton("");
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				markButton(b8);
			}
		});
		b8.setFont(new Font("Tahoma", Font.BOLD, 55));
		b8.setBounds(120, 288, 100, 100);
		contentPane.add(b8);
		
		b9 = new JButton("");
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				markButton(b9);
			}
		});
		b9.setFont(new Font("Tahoma", Font.BOLD, 55));
		b9.setBounds(230, 288, 100, 100);
		contentPane.add(b9);
		
		pointsBlueLabel = new JLabel("Punkte von Blau: 0");
		pointsBlueLabel.setBounds(10, 41, 160, 14);
		contentPane.add(pointsBlueLabel);

		pointsRedLabel = new JLabel("Punte von Rot: 0");
		pointsRedLabel.setBounds(10, 26, 160, 14);
		contentPane.add(pointsRedLabel);
		
		lblNewLabel_2 = new JLabel("Nächster Zug: Blau");
		lblNewLabel_2.setBounds(10, 11, 320, 14);
		contentPane.add(lblNewLabel_2);

		clearFields();
	}
	
	public void markButton(JButton button) {
		if(button.getBackground().getRGB() != -1118482)
			return;
		String color;
		String nextText = "Nächster Zug: ";
		if(currentPlayerBlue) {
			color = "#0b0d8c";
			nextText += "Rot";
			currentPlayerBlue = false;
		} else {
			color = "#b0120c";
			nextText += "Blau";
			currentPlayerBlue = true;
		}
		button.setBackground(Color.decode(color));
		lblNewLabel_2.setText(nextText);

		checkFields();
	}

	public void checkFields() {
		if((compareFields(b1, b2, b3))
		|| compareFields(b4, b5, b6)
		|| compareFields(b7, b8, b9)

		|| compareFields(b1, b4, b7)
		|| compareFields(b2, b5, b8)
		|| compareFields(b3, b6, b9)

		|| compareFields(b1, b5, b9)
		|| compareFields(b3, b5, b7)) {
			if(currentPlayerBlue) {
				// Rot hat gewonnen
				pointsRed++;
				pointsRedLabel.setText("Punkte von Rot: " + pointsRed);
			} else {
				// Blau hat gewonnen
				pointsBlue++;
				pointsBlueLabel.setText("Punkte von Blau: " + pointsBlue);
			}

			clearFields();
		} else {
			if(checkDraw()) {
				clearFields();
			}
		}
	}

	public void clearFields() {
		for (Component component : getContentPane().getComponents()) {
			if(component instanceof JButton) {
				component.setBackground(new Color(-1118482));
				((JButton) component).updateUI();
			}
		}
	}

	public boolean checkDraw() {
		int i = 0;
		for (Component component : getContentPane().getComponents()) {
			if(component instanceof JButton) {
				if(component.getBackground().getRGB() != -1118482)
					i++;
			}
		}
		return i == 9;
	}

	public boolean compareFields(JButton button1, JButton button2, JButton button3) {
		if(button1.getBackground().getRGB() == -1118482
		|| button2.getBackground().getRGB() == -1118482
		|| button3.getBackground().getRGB() == -1118482)
			return false;
		return (button1.getBackground().equals(button2.getBackground())
				&& button1.getBackground().equals(button3.getBackground()));
	}
}
