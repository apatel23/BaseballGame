import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class FileReader {
	
	private String fileName;
	private Scanner sc;
	public ArrayList<Integer> points;
	
	FileReader(String file) {
		fileName = file;
		points = new ArrayList<Integer>();
		
		OpenFile();
	}
	
	public void OpenFile() {
		try {
			sc = new Scanner(new File(fileName));
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				System.out.println(" : " + line);
				addPoints(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error reading file");
			e.printStackTrace();
		}
	}
	
	public void addPoints(String lineOfPoints) {
		String[] line = lineOfPoints.split(" ");
		for(int i = 0; i < line.length; i++) {
			int point = Integer.parseInt(line[i]);
			points.add(point);
			System.out.println("add point: " + point);
		}
	}
	
	public ArrayList<Integer> getPoints() {
		return points;
	}
	

}
