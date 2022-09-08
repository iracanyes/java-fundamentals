package com.jdojo.statement;

// Imports
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class FileReaderSample{
	public FileReaderSample(){}

	public static void main(String[] args) {
		try{
			bufferedFileReader();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void bufferedFileReader() throws IOException, FileNotFoundException{
		String filePath = "C:\\Projets\\cours\\language\\java\\bj9f\\src\\jdojo.statement\\com\\jdojo\\statement";
		BufferedReader reader = new BufferedReader( new FileReader(filePath));


		String line;

		while((line = reader.readLine()) != null){
			System.out.println(line);
		}

		/*
		* same as above
		*/
		do{
			line = reader.readLine();
			if(line != null)
				System.out.println(line);
		}while(line != null);

	}
}