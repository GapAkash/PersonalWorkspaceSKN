package mainApp;

import java.util.HashMap;
import java.util.Map;

public class TestHashmap {
	public static void main(String[] args) {
		Object country[] = {"UK", "CA", "TH", "JP", "RU", "AE"};
		String emeiaCountries[] = { "UK", "AT", "BH", "BE", "CZ", "FR", "DE", "HU", "IT", "KW", "NL", "PT", "QA", "RU", "SA", "ES", "CH", "AE"};
		String region = null;
		Map<String, String> map = new HashMap<String, String>();
		map.put("EMEIA", "UK");
		
		for (int i = 0; i < country.length; i++) {
			if(map.containsValue("UK")) {
				region = "EMEIA";
				//System.out.println(map.);
			}
		}
	}

}
