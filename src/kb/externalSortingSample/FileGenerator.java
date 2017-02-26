package kb.externalSortingSample;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.Random;

public class FileGenerator {
	
	private static final String CR = "\r"; // carriage return
	private static Random random = new Random();
	private static BigDecimal bd;
	
	private FileGenerator(){
		
	}
	
	public static void generateFile(String fileName, String[]keys, 
			Object[][]randomValues, int recordsToGenerate){
		
		try (
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName + ".csv"), "UTF-8"));
		)
		{
			//generating column headers
			for(int i = 0; i < keys.length; i++){
				writer.write(keys[i]);
				if(i < keys.length - 1){
					writer.write(",");
				}else{
					writer.write(CR);
				}
			}
			int counter = 0;
			while(counter < recordsToGenerate){
				for(int i = 0; i < randomValues.length; i++){
					writer.write(pickRandomValue(randomValues[i]).toString());
					
					if(i < randomValues.length - 1){
						writer.write(",");
						}
					else{
						writer.write(CR);
					}
				}
				counter++;
			}
		}
		catch (UnsupportedEncodingException | FileNotFoundException e) {
			System.out.println("Error when creating writer." + e.getMessage());
		} catch (IOException e1) {
			System.out.println("IOException." + e1.getMessage());
		}
	}
	/**
	 * picks random value from passed values array, if null generates random double value 
	 * within range of 1000 to 10000 rounded to integral number
	 */
	private static Object pickRandomValue(Object[] values){
		if(values != null){
			return values[random.nextInt(values.length)];
		}else{
			Double d = new Double(random.nextDouble() * 9000 + 1000);
			return roundDoubleToIntegral(d);
		}
	}
	
	private static double roundDoubleToIntegral(Double value){
		bd = new BigDecimal(value);
		bd = bd.setScale(0, BigDecimal.ROUND_HALF_UP);
		return bd.doubleValue();
	}
}
