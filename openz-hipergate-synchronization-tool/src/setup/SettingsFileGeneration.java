package setup;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import global.Settings;

/**
 * Intended to generate the XML settings files
 * 
 * @author Christian Gläser
 */
public class SettingsFileGeneration {

	/**
	 * Url for the web interface.
	 */
	private URL url;
	
	/**
	 * The extension for the start of the import process
	 */
	private String urlImportExtension;

	/**
	 * Update interval in seconds.
	 */
	private Integer updateInterval;

	private String validationString;

	private String validationAdress;

	/**
	 * Constructor with default values.
	 */
	public SettingsFileGeneration() {
		try {
			url = new URL("http://141.22.32.186/openz-hipergate-synchronization");

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		urlImportExtension = "/service/businessPartner/import/start";
		updateInterval = 15;
		validationAdress = "/service/programIdentifier";
		validationString = "openz-hipergate-synchronization";
		
	}

	/**
	 * Constructor for custom values.
	 * 
	 * @param url
	 *            The url for creasting the XML scaffold
	 * @param updateInterval
	 *            The update interval in seconds
	 * @param folderLocation
	 *            The folder location
	 */
	public SettingsFileGeneration(URL url, Integer updateInterval,
			String urlImportExtension, String validationAdress, String validationString) {
		this.url = url;
		this.urlImportExtension = urlImportExtension;
		this.updateInterval = updateInterval;
		this.validationAdress = validationAdress;
		this.validationString = validationString;
	}

	/**
	 * Generates the XML scaffold
	 * 
	 * @return A string with the generated XML file as content
	 */
	public String generateXMLScaffold() {
		Settings settings = new Settings();
		settings.setURL(url);
		settings.setUpdateInterval(15);
		settings.setURLImportExtension(urlImportExtension);
		settings.setValidationAdress(validationAdress);
		settings.setValidationString(validationString);
		XStream xStream = new XStream(new DomDriver());
		xStream.alias("settings", Settings.class);
		return xStream.toXML(settings);
	}

	/**
	 * Creates a XML scaffold with default values
	 * 
	 * @param args
	 *            arguments for XMLScaffoldGeneration - currently none
	 * @throws UnsupportedEncodingException
	 *             The character encoding is not supported
	 * @throws FileNotFoundException
	 *             File path could not be opened
	 */
	public static void main(String[] args) throws FileNotFoundException,
			UnsupportedEncodingException {
		SettingsFileGeneration xmlScaffold = new SettingsFileGeneration();
		PrintWriter writer = new PrintWriter("settings.xml", "UTF-8");
		writer.println(xmlScaffold.generateXMLScaffold());
		writer.close();
	}
}
