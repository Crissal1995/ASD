package utility;
import java.io.*;

public class Writefile {
	
	final private static String space = "    ";
	final private static String logs = "./logs/";
	final private static String ext = ".txt";
	
	public synchronized static void clean(String className) {
		File dirLogs = new File(logs);
		dirLogs.mkdir();
		
		String path = logs + className + ext;
		
		try {
			File f = new File(path);
			f.delete();
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized static void write(String className, long dim, float time) {
		String path = logs + className + ext;
		
		try {
			FileWriter fw = new FileWriter(path, true);
			fw.append(dim + space + time);
			fw.append(System.lineSeparator());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
