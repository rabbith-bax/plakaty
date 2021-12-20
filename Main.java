package plakaty;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int[][] readArray() {
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
	public static int findSmallest(int[] array) {
		int smallest = Integer.MAX_VALUE;;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0 && array[i] < smallest) {
				smallest = array[i];
			}
		}
		return smallest;
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
			int lowestBlock = findSmallest(array), numberOfSpaces = 0, zerosAtTheEnd = 0;
			for (int i = array.length - 1; i > 0; i--) {
				if (array[i] == 0) {
					zerosAtTheEnd += 1;
				}else break;
			}
			int[] coppiedArray = Arrays.copyOf(array, array.length - zerosAtTheEnd);
			for (int i = 0; i < coppiedArray.length - 1; i++) {
				if (coppiedArray[i] != 0 && coppiedArray[i+1] == 0) {
							numberOfSpaces += 1;
				}
			}
			System.out.println("Print tabeli:");
			for (int i = 0; i < array.length; i++) {
				System.out.println(array[i]);
			}
			for (int i = 0; i < array.length; i++) {
				if (array[i] >= lowestBlock) array[i] -= lowestBlock;
			}
			for (int i = 0; i <= numberOfSpaces; i++) {
				numberOfPosters += 1;
				}
			System.out.println("wynik: " + numberOfPosters);
			System.out.println("ilosc przerw: " + numberOfSpaces);
			System.out.println("Lowest block: " + lowestBlock);
		}
		return numberOfPosters;
	}
	public static void main(String[] args) {
		int[][] array2d = readArray();
		int[] array = convertArray(array2d);
		System.out.println(result(array));
	}

}
