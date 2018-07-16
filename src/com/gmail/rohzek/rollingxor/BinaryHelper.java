package com.gmail.rohzek.rollingxor;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

public class BinaryHelper 
{
	public static String[] binaryToBytes(String binary)
	{
		Iterable<String> result = Splitter.fixedLength(8).split(binary);
		return Iterables.toArray(result, String.class);
	}
	
	public static String bytesToBinary(String[] bytes) 
	{
		String output = "";
		
		for(int i = 0; i < bytes.length; i++) 
		{
			output += bytes[i];
		}
		
		return output;
	}
}
