package fuzzyLogicHW_1;

import java.io.File;
import java.net.URISyntaxException;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;

public class Model {
	private final FIS fis;

	public Model(double temperature, double daylightLength) throws URISyntaxException {
		File dosya = new File(getClass().getResource("model.fcl").toURI());
		fis = FIS.load(dosya.getPath(),true);
		fis.setVariable("temperature", temperature);
		fis.setVariable("day_light_duration", daylightLength);
		fis.evaluate();
	}
	public double GetTemperature() {
		return fis.getVariable("temperature").getValue();
	}
	public double GetDayLightDuration() {
		return fis.getVariable("day_light_duration").getValue();
	}
	public double GetElectricityConsumption() {
		return fis.getVariable("electricity_consumption").getValue();
	}
	public boolean GetCharts() {
		try {
			JFuzzyChart.get().chart(fis);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	public boolean GetOutputAreaChart() {
		try {
			var electricityConsumption = fis.getVariable("electricity_consumption");
			JFuzzyChart.get().chart(electricityConsumption,electricityConsumption.getDefuzzifier(),true);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	public boolean PrintRuleSet() {
		try {
			System.out.println(fis);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	public boolean PrintExecutedRules() {
		try {
		    for(Rule r : fis.getFunctionBlock("model").getFuzzyRuleBlock("rules").getRules() ) {
		    	if(r.getDegreeOfSupport()>0) {
		    		System.out.println(r);
		    	}
		    }
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
}
