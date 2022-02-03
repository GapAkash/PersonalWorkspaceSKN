package mainApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMerge {
	public static void main(String[] args) {

		String marker[] = {"CAM5003R001    restore-xstore-db.err", 
				"CAO5080R001    upload-pospolls.err", 
				"USM4009R001    get-remote-sql-server-backup.err", 
				"USM4010R003    get-remote-sql-server-backup.err", 
		        "USM4033R003    get-remote-sql-server-backup.err", 
		        "USM4034R001    startup.err",
		        "USM4034R002    startup.err",
		        "USM4034R003    startup.err", 
		        "USM4034R004    startup.err",
		        "USM4051R001    startup.err",
		        "USM4051R002    startup.err",
		        "USM4061R002    restore-xstore-db.err",
		        "USM4080R001    startup.err",
		        "USM4080R002    startup.err",
		        "USM4080R003    startup.err",
		        "USM4080R003    appears to be offline",
		        "USM4071R004    appears to be offline",
		        "CAO5082S099    appears to be offline"};
		System.out.println(marker.length);
		
		List<String> listMarker = new ArrayList<String>(Arrays.asList(marker));

		
				listMarker.removeIf(n -> n.contains("appears to be offline"));
				System.out.println("\nNEW");
				System.out.println(listMarker.size());
//

		marker = new String[listMarker.size()];
		marker = listMarker.toArray(marker);
		System.out.println(marker.length);
		
//		String notMatchedMarker[] = {};
//		List<String> listMatchedMarker = new ArrayList<String>();
//		List<String> listNotMatchedMarker = new ArrayList<String>();
//		
//		for (int i = 0; i < marker.length; i++) {
//			if (marker[i].contains("appears to be offline")) {
//				marker[i] = null;
//			}
//		}
//		System.out.println(Arrays.toString(marker));
//		System.out.println(marker.length);

	}
}
