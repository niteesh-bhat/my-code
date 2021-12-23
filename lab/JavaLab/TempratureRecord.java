package java_lab;

import java.util.Scanner;

class CityTempratureRecord {
	String cityNames[];
	double tempratures[][];
	
	public CityTempratureRecord() {
		cityNames = new String[5];
		tempratures = new double[5][6];
	}
	
	public void readTempratures() {
		Scanner s = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.print("Enter city " + (i+1) + " name: ");
			cityNames[i] = s.next();
			
			System.out.println("Enter tempratures for city " + (i+1) + ": ");
			for (int j = 0; j < 6; j++)
				tempratures[i][j] = s.nextDouble();
		}
		s.close();
	}
	
	public void findLowestTemprature() {
		double lowestTemp = tempratures[0][0];
		int lowestCityIdx = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				if (tempratures[i][j] < lowestTemp) {
					lowestTemp = tempratures[i][j];
					lowestCityIdx = i;
				}
			}
		}
		
		System.out.println(cityNames[lowestCityIdx] + " has the lowest temprature of " + lowestTemp);
	}
	
	public void findHighestTemprature() {
		double highestTemp = tempratures[0][0];
		int highestCityIdx = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				if (tempratures[i][j] > highestTemp) {
					highestTemp = tempratures[i][j];
					highestCityIdx = i;
				}
			}
		}
		
		System.out.println(cityNames[highestCityIdx] + " has the highest temprature of " + highestTemp);
	}
}

public class TempratureRecord {
	public static void main(String[] args) {
		CityTempratureRecord records = new CityTempratureRecord();
		records.readTempratures();
		records.findHighestTemprature();
		records.findLowestTemprature();
	}
}
