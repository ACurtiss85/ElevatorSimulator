import java.util.ArrayList;
import java.util.List;

// Assume input is in format with first Integer as starting floor and following numbers are travel floors 
// Assume no decimal floors so only accept Integers. Reject any non integer. Travel will continue on after
// rejecting a bad input
// Assume traveler goes to at lease 1 floor
// Assuem negative floors are ok and also take 10 units of time each

public class ElevatorSimulator {
	public static void main(String[] args) {
		int startingFloor = 0;

		System.out.println("Welcome to ElevatorSimulator. ");
		List<Integer> floorsToVisit = new ArrayList<>();

		if (args.length >= 2) {
			// Identify Starting floor then add floors to travel to to list
			startingFloor = Integer.parseInt(args[0]);

			for (int i = 1; i < args.length; i++) {
				try {
					int floor = Integer.parseInt(args[i]);
					floorsToVisit.add(floor);
					System.out.println("Added " + floor + " to floorsToVisit");
				} catch (NumberFormatException e) {
					System.out.println("Invalid input: " + args[i]);
				}
			}

			int currentFloor = startingFloor; // Starting floor
			int totalTravelTime = 0;
			List<Integer> visitedFloors = new ArrayList<>();

			for (int floor : floorsToVisit) {
				int travelTime = Math.abs(currentFloor - floor) * 10; // Assuming 10 units of time per floor
				totalTravelTime += travelTime;
				visitedFloors.add(floor);
				currentFloor = floor;
			}

			System.out.println("Total travel time: " + totalTravelTime);
			System.out.println("The starting floor is " + startingFloor);
			System.out.print("Floors visited in order: ");
			for (int visitedFloor : visitedFloors) {
				System.out.print(visitedFloor + " ");
			}
			System.out.println();
		} else {
			// Problem with input
			System.out.println(
					"Please provide starting floor followed by list of floors to visit as command-line arguments.");
		}
	}
}