package com.TrainManagement;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("***Train Consist Management App***");
		List<String> trainConsist=new ArrayList<>(); //using arrayList for bogies
		System.out.println("\n--TRAIN INITIALIZED SUCCESSFULLY--");
		System.out.println("Initial Bogie Count : " + trainConsist.size());//displaying bogie count
		System.out.println("\nCurrent Train Consist : " + trainConsist);//displaying train consist
		System.out.println("\n System Ready for Operations...");
		
	}

}
