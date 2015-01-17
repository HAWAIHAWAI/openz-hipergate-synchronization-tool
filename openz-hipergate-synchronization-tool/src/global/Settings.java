package global;

import java.net.URL;

/**
 * Global settings for initialization.
 * 
 * @author cglaeser
 */
public class Settings {

	/**
	 * The url where the openz-hipergate-synchronization web service is located e.g. http[s]://subdomain.domain.tld[:port]/openz-hipergate-synchronization/service
	 */
	private URL url;

	/**
	 * The path where import is started e.g. /businessPartner/import/start
	 */
	private String urlImportExtension;
	
	/**
	 * The path where program identity is confirmed  e.g. /programIdentifier
	 */
	private String validationAdress;
	
	/**
	 * The string to be expected when opening validationAdress
	 */
	private String validationString;
	
	/**
	 * Update interval in seconds. e.g. 15
	 */
	private Integer updateInterval;




	/**
	 * Retrieves the url where the openz-export web site is located.
	 * 
	 * @return A url in the form "http://www.example.com/resourceIdentifier"
	 */
	public URL getURL() {
		return url;
	}

	/**
	 * Sets the url were the openz-export web service is located.
	 * 
	 * @param newUrl
	 *            A url in the form "http://www.example.com/resourceIdentifier"
	 */
	public void setURL(URL newUrl) {
		url = newUrl;
	}

	/**
	 * Retrieves the update interval in seconds.
	 * 
	 * @return The update Interval in seconds
	 */
	public Integer getUpdateInterval() {
		return updateInterval;
	}

	/**
	 * Sets the update interval in seconds.
	 * 
	 * @param newUpdateInterval
	 *            The update interval in seconds
	 */
	public void setUpdateInterval(Integer newUpdateInterval) {
		updateInterval = newUpdateInterval;
	}

	public void setURLImportExtension(String urlImportExtension) {
		this.setUrlImportExtension(urlImportExtension);		
	}

	public String getUrlImportExtension() {
		return urlImportExtension;
	}

	public void setUrlImportExtension(String urlImportExtension) {
		this.urlImportExtension = urlImportExtension;
	}

	public String getValidationAdress() {
		return validationAdress;
	}

	public void setValidationAdress(String validationAdress) {
		this.validationAdress = validationAdress;
	}

	public String getValidationString() {
		return validationString;
	}

	public void setValidationString(String validationString) {
		this.validationString = validationString;
	}
}
