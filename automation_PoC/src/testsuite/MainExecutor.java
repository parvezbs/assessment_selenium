package testsuite;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class MainExecutor {
	public static void main(String[] args) {
		String projectLocation = System.getProperty("user.dir");
		System.out.println(projectLocation);
		List<String> file = new ArrayList<String>();
		file.add(projectLocation+"/testng.xml");
		TestNG testNG = new TestNG();
		testNG.setTestSuites(file);
		testNG.run();}
}
