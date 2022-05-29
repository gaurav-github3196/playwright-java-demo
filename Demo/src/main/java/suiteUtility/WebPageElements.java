package suiteUtility;

public class WebPageElements {
	
	private String name;
	private String locator;
	private String value;
	
	/**
	 * @param name
	 * @param locator
	 * @param value
	 */
	public WebPageElements(String name, String locator, String value) {
		super();
		this.name = name;
		this.locator = locator;
		this.value = value;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the locator
	 */
	public String getLocator() {
		return locator;
	}
	/**
	 * @param locator the locator to set
	 */
	public void setLocator(String locator) {
		this.locator = locator;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	


}
