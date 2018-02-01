import java.math.BigDecimal;
import java.util.Scanner;

/*
 * Author Jordan Zwart
 * Batting stats, calculate the batting average and slugging percentage for one or more players
 * Use an array to store the at-bats for each player. For the the at-bats enter 0,1,2,3,4
 * Validate the input so that the user can only enter positive integers
 * Validate the users response to the question "Another batter?" so that the user can only enter Y,y,N,n
 * Format the batting average and slugging percentages such that three decimal places are shown
 */
public class BattingStats {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String letter = "y";
		int[] storeAtBat = null;
		
		System.out.println("Welcome to Batting Average Calculator!");
		while(letter.equalsIgnoreCase("y")){
		System.out.println("Enter number of at bat: ");
		
		int atBats = scan.nextInt();
		
		System.out.println("0 = out, 1=single, 2=double, 3=triple, 4=home run");
		storeAtBat = new int[atBats];
		
		for (int i=0; i < atBats; i++){
			System.out.println("Results for at-bat " + (i + 1) + ":");
			storeAtBat[i] = scan.nextInt();
			scan.nextLine();
			
			
				while((storeAtBat[i] < 0 || storeAtBat[i] > 4)){
				System.out.println("Not a valid result for at-bat. Result must be between 0-4");
				System.out.println("Results for at-bat " + (i +1) + ":");
				storeAtBat[i] = scan.nextInt();
				}
			
		}
		int sum = 0;
		for(int i = 0; i < storeAtBat.length; i++){
			sum+= storeAtBat[i];
		}
			//sluggingpercentPercentage
		int baseHit = 0;
		for(int i = 0; i < storeAtBat.length; i++){
			if (storeAtBat[i] > 0){
			baseHit++;
			}
		}
		System.out.println("Hits: " + baseHit);
		System.out.println("Total Bases: " + sum);
		
		System.out.println(avg(baseHit,atBats));
		System.out.println(slg(sum,atBats));
		
		System.out.println("Another Batter? Enter: (y/n)");
		
		letter = scan.nextLine();
//		switch(letter){
//		case "y":
//			break;
//		case "Y":
//			break;
//		case "n":
//			System.out.println("goodbye");
//			break;
//		case "N":
//			System.out.println("goodbye");
//			break;
//		default:
//			System.out.println("Not a valid input");
//			break;
//		}
		
	}
		
	}

		
		
		
		





	public static BigDecimal avg(int hits, int atBats) {
		double average = (double) hits / (double) atBats;
		BigDecimal b = new BigDecimal(average);

		return b.setScale(3, BigDecimal.ROUND_HALF_UP);
	}

	public static BigDecimal slg(int totalBases, int atBats) {
		double slugging = (double) totalBases / (double) atBats;
		BigDecimal b = new BigDecimal(slugging);
		return b.setScale(3, BigDecimal.ROUND_HALF_UP);
	}
}


