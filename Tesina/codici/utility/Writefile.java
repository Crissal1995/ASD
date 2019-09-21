package utility;
import java.io.*;

public class Writefile {
	
	public synchronized static void clean(String className) {
		String path = "./logs/" + className + ".txt";
		
		try {
			File f = new File(path);
			f.delete();
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized static void write(String className, long dim, float time) {
		String path = "./logs/" + className + ".txt";
		
		try {
			FileWriter fw = new FileWriter(path, true);
			fw.append(dim + "     " + time);
			fw.append(System.lineSeparator());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
