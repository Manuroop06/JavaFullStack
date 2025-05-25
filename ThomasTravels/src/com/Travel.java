package com;

public class Travel {

	/*
	 * This method checks whether the driver drives a vehicle of category car or not
	 */
	public boolean isCarDriver(Driver driver) {
		if (driver.getCategory().equalsIgnoreCase("car")) {
			return true;
		} else {
			return false;
		}
		
	}

	public String retrievebyDriverId(Driver[] drivers, int driverId) {
		for (Driver d : drivers) {
			if (d.getDriverId() == driverId) {
				return "Driver name is " + d.getDriverName() + " belonging to the category " + d.getCategory()
						+ " traveled " + d.getTotalDistance() + " KM so far.";
			}
		}
		return "Driver with ID " + driverId + " not found.";

	}

	public int retrieveCountOfDriversByCategory(Driver[] drivers, String category) {
		int count = 0;
		for (Driver d : drivers) {
			if (d.getCategory().equalsIgnoreCase(category)) {
				count++;
			}
		}
		return count;
	}

	public Driver[] retrieveDriver(Driver[] drivers, String category) {
		int size = retrieveCountOfDriversByCategory(drivers, category);
		Driver[] retrievedDrivers = new Driver[size];
		int index = 0;
		for (Driver d : drivers) {
			if (d.getCategory().equalsIgnoreCase(category)) {
				retrievedDrivers[index++] = d;
			}
		}
		return retrievedDrivers;

	}

	public Driver retriveMaximumDistanceTravelledDriver(Driver[] drivers) {
		if (drivers.length == 0)
			return null;
		Driver maxDriver = drivers[0];
		for (int i = 0; i < drivers.length; i++) {
			if (drivers[i].getTotalDistance() > maxDriver.getTotalDistance()) {
				maxDriver = drivers[i];
			}
		}
		return maxDriver;

	}

}
