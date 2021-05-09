import java.io.*;
import java.util.ArrayList;

public class CSVFile {

	public static void main(String[] args) {
		String filePath = CSVFile.class.getClassLoader().getResource("data.txt").getPath();
		printCSVFile(filePath);
	}
	
	public static void printCSVFile(String filePath){
		//add code here
		File pf=new File(filePath);
		BufferedReader reader=null;
		ArrayList<String> mylist=new ArrayList<String>();
		try {
				reader=new BufferedReader(new FileReader(pf));
				String tem=null;
				while ((tem=reader.readLine())!=null){
					mylist.add(tem);
				}
				reader.close();
		} catch (IOException e) {
				e.printStackTrace();
		}
		String[] arrString = (String[])mylist.toArray(new String[0]);
		System.out.println("Last    Fisrt    Salary");
		for (String str:arrString) {
			for (int i = 0; i <str.length() ; i++) {
				if(str.charAt(i)!=',')
					System.out.print(str.charAt(i));
				else
					System.out.print("    ");
			}
			System.out.println();
		}
		}
	}
