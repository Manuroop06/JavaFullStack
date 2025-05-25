package com;

import java.util.Scanner;

public class TestDriver {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number of drivers: ");
		int n = sc.nextInt();
		sc.nextLine();

		Driver[] drivers = new Driver[n];

		for (int i = 0; i < n; i++) {
			System.out.println("\nEnter details for Driver " + (i + 1) + ":");

			System.out.print("Category: ");
			String category = sc.nextLine();

			System.out.print("Driver ID: ");
			int id = sc.nextInt();

			sc.nextLine(); // consume newline

			System.out.print("Driver Name: ");
			String name = sc.nextLine();

			System.out.print("Total Distance Travelled: ");
			double distance = sc.nextDouble();

			sc.nextLine(); // consume newline

			drivers[i] = new Driver(category, id, name, distance);
		}
		Travel travel = new Travel();

		// Test isCarDriver
		System.out.print("\nEnter Driver ID to check if it's a car driver: ");
		int checkId = sc.nextInt();
		for (Driver d : drivers) {
			if (d.getDriverId() == checkId) {
				boolean isCar = travel.isCarDriver(d);
				System.out.println("Is car driver? " + isCar);
				break;
			}
		}

		// Test retrievebyDriverId
		System.out.print("\nEnter Driver ID to retrieve details: ");
		int retrieveId = sc.nextInt();
		sc.nextLine();
		String result = travel.retrievebyDriverId(drivers, retrieveId);
		System.out.println(result);

		// Test retrieveCountOfDriversByCategory
		System.out.print("\nEnter category to count drivers: ");
		String category = sc.nextLine();
		int count = travel.retrieveCountOfDriversByCategory(drivers, category);
		System.out.println("Number of drivers in category '" + category + "': " + count);

		// Test retrieveDriver
		System.out.print("\nEnter category to retrieve drivers: ");
		String categoryCheck = sc.nextLine();
		Driver[] categoryDrivers = travel.retrieveDriver(drivers, categoryCheck);
		System.out.println("Drivers in category '" + categoryCheck + "':");
		for (Driver d : categoryDrivers) {
			System.out.println(
					d.getDriverName() + " (ID: " + d.getDriverId() + ", Distance: " + d.getTotalDistance() + ")");
		}

		// Test retriveMaximumDistanceTravelledDriver
		Driver maxDriver = travel.retriveMaximumDistanceTravelledDriver(drivers);
		if (maxDriver != null) {
			System.out.println("\nDriver with maximum distance travelled:");
			System.out.println(maxDriver.getDriverName() + " (ID: " + maxDriver.getDriverId() + ", Distance: "
					+ maxDriver.getTotalDistance() + ")");
		} else {
			System.out.println("No drivers found.");
		}

		sc.close();
	}

}
