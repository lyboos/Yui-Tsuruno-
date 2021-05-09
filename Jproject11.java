import java.util.ArrayList;
import java.util.Scanner;

public class ResponseTimeCalculation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> mylist = new ArrayList<Integer>();
		boolean flag = true;
		do {
			System.out.println("Enter a Number:");
			try {
				int a = sc.nextInt();
				mylist.add(a);
			} catch (RuntimeException e) {
				String str = sc.nextLine();
				if (str.equals("done")) {
					flag = false;
				}
			}
		} while (flag);
		if (mylist.size() == 1) {
			for (Integer item:mylist) {
				double item2=item.doubleValue();
				System.out.println("Numbers:"+item);
				System.out.println("The average is "+String.format("%.2f",item2)+'.');
				System.out.println("The minimum is "+item+'.');
				System.out.println("The maximum is "+item+'.');
				System.out.println("The standard deviation is 0.00.");
			}
		} else {
			Integer[] array = mylist.toArray(new Integer[mylist.size()]);
			double aver = 0, standard = 0;
			int min = 20000, max = 0;
			System.out.print("Numbers:");
			for (int i = 0; i < mylist.size(); i++) {
				aver += array[i];
				if (array[i] > max)
					max = array[i];
				if (array[i] < min)
					min = array[i];
				System.out.print(array[i]);
				if (i != mylist.size() - 1) {
					System.out.print(",");
				}
			}
			System.out.println();
			if (mylist.size() > 1) {
				aver = aver / (mylist.size());
				for (int item : array) {
					standard += (item - aver) * (item - aver);
				}
				standard = standard / mylist.size();
				standard = Math.sqrt(standard);
				System.out.println("The average is " + String.format("%.2f", aver) + '.');
				System.out.println("The minimum is " + min + '.');
				System.out.println("The maximum is " + max + '.');
				System.out.println("The standard deviation is " + String.format("%.2f", standard) + '.');
			}
		}
	}
}
