package com.gmail.rohzek.rollingxor;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class NumberConversion 
{
	public static String textToHex(String convert)
	{
		String output = "";
		
		try 
		{
			 output = Hex.encodeHexString(convert.getBytes("UTF-8"));
		} 
		catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}
		
		return output.toUpperCase();
	}
	
	public static String hexToText(String convert) 
	{
		String output = "";
		
		try 
		{
			byte[] bytes = Hex.decodeHex(convert);
			output = new String(bytes, "UTF-8");
		} 
		catch (DecoderException e) 
		{
			e.printStackTrace();
		} 
		catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}
		
		return output;
	}
	
	public static String hexToBinary(String hex)
	{
		String base = new BigInteger(hex, 16).toString(2);
		String padding = "%" + (hex.length() * 4) + "s";
		
		return String.format(padding, base).replace(" ", "0");
	}
	
	public static String binaryToHex(String binary)
	{
		BigInteger decimal = new BigInteger(binary, 2);
		return decimal.toString(16).toUpperCase();
	}
}
