package com.gmail.rohzek.rollingxor;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JTextField;

public class XOR 
{
	//System.out.println(XOR.encrypt(text, decryptedHexEncode, decryptedBinaryEncode, encryptedBinaryEncode, encryptedHexEncode));
	public static String encrypt(String unEncryptedText, JTextField hexDecrypted, JTextField binaryDecrypted, JTextField binaryEncrypted, JTextField hexEncrypted) 
	{
		// text to hex
		String decryptedHex = NumberConversion.textToHex(unEncryptedText);
		hexDecrypted.setText(decryptedHex);
		
		// hex to binary
		String decryptedBinary = NumberConversion.hexToBinary(decryptedHex);
		binaryDecrypted.setText(decryptedBinary);
		
		// Split binary into bytes
		String[] decryptedBytes = BinaryHelper.binaryToBytes(decryptedBinary);
		
		// xor
		ArrayList<String> encryptedBytes = new ArrayList<String>();
		encryptedBytes.add(decryptedBytes[0]);
		for(int i = 0; i < decryptedBytes.length - 1; i++)
		{
			String next = XOR.xor(decryptedBytes[i], decryptedBytes[i+1]);
			decryptedBytes[i+1] = next;
			encryptedBytes.add(next); // Encrypt
		}
		
		// Put bytes back together
		String encryptedBinary = "";
		for(String out : encryptedBytes)
        {
			encryptedBinary += out;
        }
		binaryEncrypted.setText(encryptedBinary);
		
		// binary to hex
		String encryptedHex = NumberConversion.binaryToHex(encryptedBinary);
		hexEncrypted.setText(encryptedHex);
		
		return encryptedHex;
	}
	
	public static String decrypt(String encryptedText, JTextField binaryEncrypted, JTextField binaryDecrypted, JTextField hex, JTextField text)
	{	
		// Convert encrypted hex string to binary string and display
		String encryptedBinary = NumberConversion.hexToBinary(encryptedText);
		binaryEncrypted.setText(encryptedBinary);
		
		// Convert encrypted binary string to byte array
		String[] encryptedBytes = BinaryHelper.binaryToBytes(encryptedBinary);
		
		// Decrypt each byte, and place it in an arraylist for keeping
		ArrayList<String> decryptedBytes = new ArrayList<String>();
		for(int i = (encryptedBytes.length - 1); i > 0; i--)
        {
			decryptedBytes.add(XOR.xor(encryptedBytes[i], encryptedBytes[i-1]));
        }
		decryptedBytes.add(encryptedBytes[0]);
        Collections.reverse(decryptedBytes);
		
        // Put the bytes back into a single string and display
        String decryptedBinary = "";
        for(String out : decryptedBytes)
        {
        	decryptedBinary += out;
        }
        binaryDecrypted.setText(decryptedBinary);
        
        // Convert decrypted binary string to hex string and display
        String decodedHex = NumberConversion.binaryToHex(decryptedBinary);
        hex.setText(decodedHex);
        
        // Convert decrypted hex to ascii text and display
        String decodedText = NumberConversion.hexToText(decodedHex);
        text.setText(decodedText);
        
		return decodedText;
	}
	
	public static String xor(String input, String key) 
    {
        String output = "";
       
        for(int i = 0; i < input.length(); i++) 
        {
            char eval = input.charAt(i), keyval = key.charAt(i);
           
            if(eval == keyval)
            {
                output += "0";
            }
            else
            {
                output += "1";
            }
        }       
        return output;
    }
}
