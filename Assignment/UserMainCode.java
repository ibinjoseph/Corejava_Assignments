package Week2.Problem3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserMainCode {
	
	public static boolean checkTripplets(int[] array) {
		
		if(array.length < 3) {
			return false;
		}
		
		for (int i = 2; i < array.length; i++) {
			if(array[i] == array[i-1] && array[i - 1] == array[i - 2]) {
				return true;
			}
		}
		return false;
		
	}

	public static void main(String[] args) {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader(reader);
		int no = 3;
		
		int[] array;
		
		try {
			System.out.println("Enter number of values: ");
			no = Integer.parseInt(bf.readLine());
			
		}
		catch (NumberFormatException e) {
			
		} catch (IOException e) {
		}
		
		array = new int[no];
		
		for (int i = 0; i < no; i++) {
			try {
				System.out.println("Enter number " + (i+1) + ": ");
				array[i] = Integer.parseInt(bf.readLine());;
			
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if(checkTripplets(array)) {
			System.out.println("Given inputs have triplets");
		} else {
			System.out.println("Given inputs doesn't have triplets");
		}
	}

}