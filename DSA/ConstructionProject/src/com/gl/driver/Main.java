package com.gl.driver;

import java.util.Scanner;

import com.gl.service.AssemblingFloor;

public class Main {
	public static void main(String[] args) {
		AssemblingFloor queue = new AssemblingFloor();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the total number of floors in the building:");
		int totalFloors = scanner.nextInt();
		int i = 1, k = 1;
		int[] array = new int[totalFloors];
		int flag = 0;

		loop: while (i <= totalFloors) {
			flag = 0;
			System.out.println("Enter the floor size given on day: " + i);
			int floorSize = scanner.nextInt();
			if (floorSize <= totalFloors) {
				if (array[0] == 0) {
					array[0] = floorSize;
					queue.addData(floorSize);
					i++;
					continue loop;
				} else {
					for (int j = 0; j < totalFloors; j++) {
						if (array[j] == floorSize) {
							System.out
									.println("Floor size " + array[j] + " is entered already. Please enter correctly");
							flag = 1;
							continue loop;
						}

					}

					if (flag != 1) {
						array[k] = floorSize;
						queue.addData(floorSize);
						i++;
						k++;
						continue loop;
					}

				}

			} else {
				System.out.println("Please enter the floor size between 1 and " + totalFloors);
			}

		}

		System.out.println("The order of construction is as follows: ");
		queue.displayData();
		scanner.close();

	}

}
