package com.gl.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class AssemblingFloor {
	Queue<Integer> queue = new LinkedList<>();

	int queueElement;
	int flag = 0;

	public void addData(int floorSize) {
		queue.offer(floorSize);
	}

	public void displayData() {
		int size = queue.size();
		int floorSize = size;
		ArrayList<Integer> array = new ArrayList<Integer>();

		for (int i = 1; i <= size; i++) {
			queueElement = queue.peek();
			if (queueElement == floorSize) {
				if (flag == 0) {
					System.out.println("\n" + "Day: " + i);
					System.out.print(queueElement + " ");
					queue.poll();
					floorSize = floorSize - 1;
				}

				if (flag == 1) {
					System.out.println("\n" + "Day: " + i);
					System.out.print(queueElement + " ");
					floorSize = floorSize - 1;
					Collections.sort(array, Collections.reverseOrder());
					for (int k = floorSize; k == array.get(0); k--) {
						System.out.print(array.get(0) + " ");
						floorSize = floorSize - 1;
						array.remove(0);
						if (array.size() == 0) {
							break;
						}
					}
					flag = 0;
					queue.poll();

				}

			} else {
				flag = 1;
				System.out.println("\n" + "Day: " + i);
				array.add(queueElement);
				queue.poll();
			}
		}

		while (array.size() != 0) {
			System.out.print(array.get(0) + " ");
			array.remove(0);
		}

	}

}
