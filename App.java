package fuzzyLogicHW_1;

import java.net.URISyntaxException;
import java.util.Locale;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		System.out.println("Double değerleri ondalıklı kısmı nokta ile ayrılacak şekilde giriniz.");
		System.out.println("Örnek: 10.8 DOĞRU - 10,8 YANLIŞ");
		Scanner scan = new Scanner(System.in);
		System.out.println("Lütfen, sıcaklık değerini (double) giriniz: ");
		double temperature = scan.nextDouble();
		System.out.println("Lütfen, gün ışığı süresi değerini (double) giriniz: ");
		double daylightDuration = scan.nextDouble();
		Model model = null;
		try {
			model = new Model(temperature,daylightDuration);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("Sıcaklık: " + model.GetTemperature());
		System.out.println("Gün uzunluğu: " + model.GetDayLightDuration());
		System.out.println("Elektrik Tüketimi: " + model.GetElectricityConsumption() + " kMW/h");
		//model.GetCharts();
		//model.GetOutputAreaChart();
		model.PrintExecutedRules();
		
	}

}
