package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSV {
	// this method will read data from csv file and return a list
	public static List<String[]> read(String file) {
		List<String[]> data = new LinkedList<String[]>();// data list that contains all data from the csv file
		String dataRow;// each such string stores data for a particular person
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((dataRow = br.readLine()) != null) {// checking for lines which contain data
				String[] dataRecords = dataRow.split(",");// dataRecords is a string array where each element contains
				// different data of a particular person..these data values were separated by comma in the csv file
				data.add(dataRecords);// add the records of a person to the list
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("COULD NOT FIND FILE");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("COULD NOT READ FILE");
			e.printStackTrace();
		}
		return data;
	}
}
