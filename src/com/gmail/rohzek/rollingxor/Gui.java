package com.gmail.rohzek.rollingxor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

/**
 * This mess was made with Eclipse's WindowBuilder
 * I didn't really bother cleaning it up, only added what I needed.
 * 
 * @author Rohzek
 *
 */
@SuppressWarnings("serial")
public class Gui extends JFrame 
{
	boolean firstClickDecode = true;
	boolean firstClickEncode = true;
	
	ImageIcon logo = new ImageIcon("img/Lock-icon.png");
	
	private JPanel contentPane;
	private JTextField decodeInputField;
	private JTextField decryptedTextDecode;
	private JTextField decryptedHexDecode;
	private JTextField decryptedBinaryDecode;
	private JTextField encryptedBinaryDecode;
	private JTextField encodeInputField;
	private JTextField encryptedHexEncode;
	private JTextField encryptedBinaryEncode;
	private JTextField decryptedBinaryEncode;
	private JTextField decryptedHexEncode;

	public Gui() 
	{
		setTitle("Rolling XOR");
		try 
		{
			UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
			
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			//UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
			
		} 
		catch(Exception e) 
		{
			System.out.println("Error setting LAF: " + e);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 395);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setIconImage(logo.getImage());
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel encodePanel = new JPanel();
		tabbedPane.addTab("Encode", null, encodePanel, null);
		encodePanel.setLayout(null);
		
		encodeInputField = new JTextField();
		encodeInputField.setText("Enter text to encode here...");
		
		encodeInputField.addFocusListener(new FocusListener()
		{
		    public void focusGained(FocusEvent e) 
		    {
		    	if(firstClickEncode)
		    	{
		    		encodeInputField.setText("");
		    		firstClickEncode = false;
		    	}
		    }

		    public void focusLost(FocusEvent e) 
		    {
		        // Do nothing
		    }
		});
		
		encodeInputField.setColumns(10);
		encodeInputField.setBounds(10, 11, 517, 30);
		encodePanel.add(encodeInputField);
		
		JButton encodeSubmitButton = new JButton("Encode");
		
		encodeSubmitButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String text = encodeInputField.getText();
				XOR.encrypt(text, decryptedHexEncode, decryptedBinaryEncode, encryptedBinaryEncode, encryptedHexEncode);
			}
			
		});
		
		encodeSubmitButton.setBounds(532, 11, 67, 31);
		encodePanel.add(encodeSubmitButton);
		
		encryptedHexEncode = new JTextField();
		encryptedHexEncode.setEditable(false);
		encryptedHexEncode.setColumns(10);
		encryptedHexEncode.setBounds(10, 275, 589, 30);
		encodePanel.add(encryptedHexEncode);
		
		encryptedBinaryEncode = new JTextField();
		encryptedBinaryEncode.setEditable(false);
		encryptedBinaryEncode.setColumns(10);
		encryptedBinaryEncode.setBounds(10, 209, 589, 30);
		encodePanel.add(encryptedBinaryEncode);
		
		decryptedBinaryEncode = new JTextField();
		decryptedBinaryEncode.setEditable(false);
		decryptedBinaryEncode.setColumns(10);
		decryptedBinaryEncode.setBounds(10, 143, 589, 30);
		encodePanel.add(decryptedBinaryEncode);
		
		decryptedHexEncode = new JTextField();
		decryptedHexEncode.setEditable(false);
		decryptedHexEncode.setColumns(10);
		decryptedHexEncode.setBounds(10, 77, 589, 30);
		encodePanel.add(decryptedHexEncode);
		
		JLabel lblEncryptedHex = new JLabel("Encrypted Hex:");
		lblEncryptedHex.setBounds(20, 250, 99, 14);
		encodePanel.add(lblEncryptedHex);
		
		JLabel lblEncryptedBinary_1 = new JLabel("Encrypted Binary:");
		lblEncryptedBinary_1.setBounds(20, 184, 386, 14);
		encodePanel.add(lblEncryptedBinary_1);
		
		JLabel lblUnencryptedBinary = new JLabel("Unencrypted Binary:");
		lblUnencryptedBinary.setBounds(20, 118, 309, 14);
		encodePanel.add(lblUnencryptedBinary);
		
		JLabel lblDecryptedHex_1 = new JLabel("Unencrypted Hex:");
		lblDecryptedHex_1.setBounds(20, 52, 99, 14);
		encodePanel.add(lblDecryptedHex_1);
		
		JPanel decodePanel = new JPanel();
		tabbedPane.addTab("Decode", null, decodePanel, null);
		decodePanel.setLayout(null);
		
		decodeInputField = new JTextField();
		decodeInputField.setBounds(10, 11, 517, 30);
		decodeInputField.setText("Enter hex to decode here...");
		
		decodeInputField.addFocusListener(new FocusListener()
		{
		    public void focusGained(FocusEvent e) 
		    {
		    	if(firstClickDecode)
		    	{
		    		decodeInputField.setText("");
		    		firstClickDecode = false;
		    	}
		    }

		    public void focusLost(FocusEvent e) 
		    {
		        // Do nothing
		    }
		});
		
		decodeInputField.setColumns(10);
		decodePanel.add(decodeInputField);
		
		JButton decodeSubmitButton = new JButton("Decode");
		
		decodeSubmitButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String text = decodeInputField.getText();
				XOR.decrypt(text, encryptedBinaryDecode, decryptedBinaryDecode, decryptedHexDecode, decryptedTextDecode);
			}
			
		});
		
		decodeSubmitButton.setBounds(532, 11, 67, 31);
		decodePanel.add(decodeSubmitButton);
		
		decryptedTextDecode = new JTextField();
		decryptedTextDecode.setEditable(false);
		decryptedTextDecode.setColumns(10);
		decryptedTextDecode.setBounds(10, 275, 589, 30);
		decodePanel.add(decryptedTextDecode);
		
		decryptedHexDecode = new JTextField();
		decryptedHexDecode.setEditable(false);
		decryptedHexDecode.setColumns(10);
		decryptedHexDecode.setBounds(10, 209, 589, 30);
		decodePanel.add(decryptedHexDecode);
		
		decryptedBinaryDecode = new JTextField();
		decryptedBinaryDecode.setEditable(false);
		decryptedBinaryDecode.setColumns(10);
		decryptedBinaryDecode.setBounds(10, 143, 589, 30);
		decodePanel.add(decryptedBinaryDecode);
		
		JLabel lblDecryptedText = new JLabel("Decrypted Text:");
		lblDecryptedText.setBounds(20, 250, 99, 14);
		decodePanel.add(lblDecryptedText);
		
		JLabel lblDecryptedHex = new JLabel("Decrypted Hex:");
		lblDecryptedHex.setBounds(20, 184, 99, 14);
		decodePanel.add(lblDecryptedHex);
		
		JLabel lblDecryptedBinary = new JLabel("Decrypted Binary:");
		lblDecryptedBinary.setBounds(20, 118, 387, 14);
		decodePanel.add(lblDecryptedBinary);
		
		encryptedBinaryDecode = new JTextField();
		encryptedBinaryDecode.setEditable(false);
		encryptedBinaryDecode.setColumns(10);
		encryptedBinaryDecode.setBounds(10, 77, 589, 30);
		decodePanel.add(encryptedBinaryDecode);
		
		JLabel lblEncryptedBinary = new JLabel("Undecrypted Binary:");
		lblEncryptedBinary.setBounds(20, 52, 320, 14);
		decodePanel.add(lblEncryptedBinary);
	}
}
