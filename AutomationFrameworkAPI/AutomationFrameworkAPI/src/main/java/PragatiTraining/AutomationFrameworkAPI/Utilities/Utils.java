package PragatiTraining.AutomationFrameworkAPI.Utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Utils {
	
	public static HashMap<String,String>EnvWars=new HashMap<String,String>();
	
	public static void InitialisEnvWars() {
		
		String FilePath="C:\\PragatiSoftwareTesting\\link\\EnvWars.csv";
		
		try {
			
			//Opening file in read mode
			FileReader FR=new FileReader(FilePath); 
			BufferedReader BR=new BufferedReader(FR);
			String Line=BR.readLine();
			while(Line!=null) {
				//e.g DRIVERS_PATH,C:\\PragatiSoftwareTesting\\Seleniums-Drivers\\
				String[]parts=Line.split(",");
				/*
				 * parts[0]=DRIVERS_PATH
				 * parts[1]=C:\\PragatiSoftwareTesting\\Seleniums-Drivers\\
				 */
				String Key=parts[0];
				String Value=parts[1];
				EnvWars.put(Key, Value);
				Line=BR.readLine();
			}
		} 
		catch (FileNotFoundException e) {
			
			System.out.println("File :"+FilePath+ "Not Found. ");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Problem in reading file: "+FilePath);
		}
		
	}

}
