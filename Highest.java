package plakaty;
import java.util.Arrays;
import java.util.Scanner;

public class Highest {
	public static int[][] readArray() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int arrayLength = scan.nextInt(), arrayWide = 2;
		int[][] array = new int[arrayLength][arrayWide];
		for (int i = 0; i < arrayLength; i++) {
			for (int j = 0; j < arrayWide; j++) {
				array[i][j] = scan.nextInt();
			}
		}
		return array;
	}
	public static int[] convertArray(int[][] array2d) {
		int arrayLength = array2d.length;
		int[] array = new int[arrayLength];
		for (int i = 0; i < arrayLength; i++) {
			array[i] = array2d[i][1];
		}
		return array;
	}
	public static int findHighest(int[] array) {
		int highest = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > highest) {
				highest = array[i];
			}
		}
		return highest;
	}
	public static boolean isArrayEmpty(int[] array) {
		boolean empty = true;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				empty = false;
				break;
			}
		}
		return empty;
	}
	public static int result(int[] array) {
		int numberOfPosters = 0;
		while (!(isArrayEmpty(array))) {
			int highestBlock = findHighest(array);
			int numberOfBlocks = array.length;
			int indexOfHB = Arrays.binarySearch(array, highestBlock);
			if (indexOfHB == numberOfBlocks - 1) {
				array[indexOfHB] = array[numberOfBlocks -2] - 1;
				numberOfPosters += 1;
			}else if (indexOfHB == numberOfBlocks -2) {
				if (array[indexOfHB] == array[numberOfBlocks -1]) {
					array[indexOfHB] = array[numberOfBlocks - 2] - 1;
					array[numberOfBlocks -1] = array[numberOfBlocks - 2] - 1;
				}else array[indexOfHB] = array[numberOfBlocks - 2] - 1;
				numberOfPosters += 1;
			}else {
				for (int i = indexOfHB; i < numberOfBlocks - 1; i++) {
					if (array[i] == array[indexOfHB]) array[i] -= 1;
					numberOfPosters += 1;
				}
			}
			
		}
		return numberOfPosters;
	}
	public static void main(String[] args) {
		int[][] array2d = readArray();
		int[] array = convertArray(array2d);
		System.out.println(result(array));
	}
}
