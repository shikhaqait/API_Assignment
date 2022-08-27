package constant;

public class Variables {

	/**
	 * default will be cloud hosted url
	 */
	private static String baseURL = "https://jsonplaceholder.typicode.com";

	public static String getBaseURL() {
		if (System.getProperty("url") == null) {
			return baseURL;
		} else
			return System.getProperty("url");
	}

}
