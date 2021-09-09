import java.util.Scanner;

public class FoodOrder {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] foodNames = { "Pizza", "Kebab", "Soup" };
		float[] foodPrices = { 75.00f, 100.00f, 45.00f };
		byte[] foodQuantity = { 0, 0, 0 };
		byte[] foodInStock = { 0, 3, 10 };

		float totalCoast = 0;
		System.out.printf("%17s","Menu:\n");
		System.out.printf("%24s","___________________\n");

		for (int i = 0; i < foodNames.length; i++) {
				System.out.printf("%10s [%6.2fMDL]|\n", "|"+foodNames[i], foodPrices[i]);
		}
		System.out.printf("%24s","___________________\n");

		System.out.print("What are you interested in? ");
		String foodNameToFind = in.next();

		for (int i = 0; i < foodInStock.length; i++) {
			if (foodPrices[i] >= 50.00f) {
				foodPrices[i] *= 0.9f;
			}
		}

		for (int i = 0; i < foodNames.length; i++) {
			if (foodNames[i].equals(foodNameToFind) && foodQuantity[i] <= foodInStock[i]) {
				System.out.printf("Yes, we have %s it costs %.2fMDL.", foodNameToFind, foodPrices[i]);
				foodQuantity[i]++;
				break;
			} else if (foodNames[i].equals(foodNameToFind) && foodQuantity[i] > foodInStock[i]) {
				System.out.printf("Sorry, at the moment we have not enough %s!", foodNameToFind);
				break;
			}
			if (i == (foodNames.length - 1) && !(foodNames[i].equals(foodNameToFind))) {
				System.out.printf("Sorry, we have no %s!", foodNameToFind);
			}
		}

//		for (int i = 0; i < foodQuantity.length; i++) {
//			if (foodQuantity[i] > 0) {
//				float itemCoast = foodPrices[i] * foodQuantity[i];
//				System.out.printf("%20s [%7.2fMDL] x%3d = %7.2fMDL\n", foodNames[i], foodPrices[i], foodQuantity[i],
//						itemCoast);
//				totalCoast += itemCoast;
//			}
//		}
//		System.out.printf("%38s = %7.2fMDL", "Total price            ", totalCoast);
	}

}
