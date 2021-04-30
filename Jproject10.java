//import java.util.Scanner;
//
//public class CompareNumbers {
//
//	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter the first number:");
//		int a = sc.nextInt();
//		System.out.println("Enter the second number:");
//		int b = sc.nextInt();
//		System.out.println("Enter the third number:");
//		int c = sc.nextInt();
//		if (a==b||b==c||a==c) {
//			System.out.println("There are same numbers.");
//		}
//		else if(a<b){
//			if(b>c){
//				System.out.println("The largest number is "+b+".");
//			}
//			else System.out.println("The largest number is "+Math.max(a, c)+".");
//		}
//		else{
//			if(a>c){
//				System.out.println("The largest number is "+a+".");
//			}
//			else System.out.println("The largest number is "+Math.max(b,c)+".");
//		}
//	}
//}
//
import java.util.Scanner;

public class HeartRateCalculation {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("RestingHR:");
		double resting=sc.nextDouble();
		System.out.println("Age:");
		double age=sc.nextDouble();
		System.out.println("Intensity|TargetHeartRate");
		System.out.println("---------|---------------");
		for (double i =55; i <= 95; i=i+5) {
			double TargetHeartRate =(((220 - age) - resting) * i/100) + resting;
			long target=Math.round(TargetHeartRate);
			System.out.println(i+"%|"+Math.round(target)+"bpm");
		}
	}

}
