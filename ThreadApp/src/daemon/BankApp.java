package daemon;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BankApp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankApp frame = new BankApp();
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
	public BankApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelEUR = new JLabel("EUR");
		labelEUR.setBounds(251, 33, 46, 14);
		contentPane.add(labelEUR);
		
		JLabel labelUSD = new JLabel("USD");
		labelUSD.setBounds(251, 69, 46, 14);
		contentPane.add(labelUSD);
		
		JLabel labelRUB = new JLabel("RUB");
		labelRUB.setBounds(251, 112, 46, 14);
		contentPane.add(labelRUB);
		
		JLabel info_EUR = new JLabel("New label");
		info_EUR.setBounds(342, 33, 46, 14);
		contentPane.add(info_EUR);
		
		JLabel info_USD = new JLabel("New label");
		info_USD.setBounds(342, 69, 46, 14);
		contentPane.add(info_USD);
		
		JLabel info_RUB = new JLabel("New label");
		info_RUB.setBounds(342, 112, 46, 14);
		contentPane.add(info_RUB);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info_EUR.setText(XMLCurrencyParser.getCurrency("978"));
				info_USD.setText(XMLCurrencyParser.getCurrency("840"));
				info_RUB.setText(XMLCurrencyParser.getCurrency("643"));
			}
		});
		btnNewButton.setBounds(41, 65, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(157, 177, 46, 14);
		contentPane.add(lblNewLabel);
		
		Thread refresher = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
				info_EUR.setText(XMLCurrencyParser.getCurrency("978"));
				info_USD.setText(XMLCurrencyParser.getCurrency("840"));
				info_RUB.setText(XMLCurrencyParser.getCurrency("643"));
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Currency was updated");
				}
				
			}
		});
		
		refresher.setDaemon(true);
		refresher.start();
	}
}
