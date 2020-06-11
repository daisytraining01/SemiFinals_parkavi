package utility;

import io.cucumber.java.After;

public class Hooks extends BrowserConfig {
	
		
	public Hooks(String browserName) {
		super(browserName);
		}

	@After
	public void close() {
		
		driver.close();
	}

}
