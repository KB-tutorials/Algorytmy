package kb.externalSortingSample;

public class Demo {
	
	public static void main(String[]args){
		String[]keys = {"mark", "production year", "price"};
		Object[][]randomValues = {
				{"BMW", "Honda", "KIA", "Daewoo", "Peugeot", "Renault", "Mercedes", "Ford"},
				{new Integer(1999), new Integer(2000), new Integer(2003), new Integer(2001), new Integer(2002)},
				null
		};
		FileGenerator.generateFile("test2", keys, randomValues, 1000);
	}
}	
