package TestFile;

import java.io.File;
import java.util.Vector;

public class TestFileFolderSorted {
	public static void main(String args[]) {
		int i;
		String dir = "D:\\C\\xstore\\download\\archive", tmp = null;
		long time = 0;
		File tempDir, tempFile;
		Vector fileQ = new Vector();
		fileQ.add(dir);
		while (!fileQ.isEmpty()) {
			tempDir = new File((String) fileQ.remove(0));
			if (tempDir.list() != null)
				for (i = 0; i < tempDir.list().length; i++) {
					tempFile = new File(tempDir.getPath() + File.separatorChar + tempDir.list()[i]);
					if (tempFile.isDirectory()) {
						System.out.println(tempFile.getPath() + " " + fileQ.size());
						if (tempFile.lastModified() > time) {
							time = tempFile.lastModified();
							tmp = tempFile.getPath();
						}
						fileQ.add(tempFile.getPath());
					}
				}
		}
		System.out.println("most recently modified " + tmp);
	}
}
