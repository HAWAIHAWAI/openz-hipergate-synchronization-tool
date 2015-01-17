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
	 * Sets the url where the openz-export web service is located.
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

	/**
	 * Setter for URL Import Extension.
	 * @param urlImportExtension The new URL Import Extension.
	 */
	public void setURLImportExtension(String urlImportExtension) {
		this.setUrlImportExtension(urlImportExtension);		
	}

	/**
	 * Getter for URL Import Extension.
	 * @return
	 */
	public String getUrlImportExtension() {
		return urlImportExtension;
	}

	/**
	 * Setter for URL Import Extension.
	 * @param urlImportExtension The new URL Import Extension.
	 */
	public void setUrlImportExtension(String urlImportExtension) {
		this.urlImportExtension = urlImportExtension;
	}

	/**
	 * Getter for Validation Adress.
	 * @return Validation Adress as String.
	 */
	public String getValidationAdress() {
		return validationAdress;
	}

	/**
	 * Setter for Validation Adress.
	 * @param validationAdress The new Validation Adress.
	 */
	public void setValidationAdress(String validationAdress) {
		this.validationAdress = validationAdress;
	}

	/**
	 * Getter for Validation String.
	 * @return ValidationString.
	 */
	public String getValidationString() {
		return validationString;
	}

	/**
	 * Setter for Validation String.
	 * @param validationString The new Validation String.
	 */
	public void setValidationString(String validationString) {
		this.validationString = validationString;
	}
}
