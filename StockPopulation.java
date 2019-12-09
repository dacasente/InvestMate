import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class StockPopulation {
	public static void populateDatabase() {

	}

	public static String getPrices(String ticker) throws Exception {
		String thing = "";
		File file = new File(ticker + ".csv");
		System.out.println(file.getName());
		if (file.exists()) {
			StringBuilder formatted = new StringBuilder();
			BufferedReader br = new BufferedReader(new FileReader(file));
			br.readLine();
			String line;
			while ((line = br.readLine()) != null) {
				formatted.append(line);
				formatted.append(",");
			}
			br.close();
			thing = formatted.toString();

		}
		return thing;
	}
}
