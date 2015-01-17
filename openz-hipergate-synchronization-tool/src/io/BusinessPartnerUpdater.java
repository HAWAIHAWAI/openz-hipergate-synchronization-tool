package io;

import global.Settings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.TimerTask;

/**
 * Class for "downloading" Bills from OpenZ and putting them as files in a
 * folder.
 * 
 * @author cglaeser.
 */
public class BusinessPartnerUpdater extends TimerTask {


	/**
	 * Settings of the BillDownloader.
	 */
	private Settings settings;

	/**
	 * Constructor for BillDownloader.
	 * 
	 * @param settings
	 *            Settings for the BillDownloader.
	 */
	public BusinessPartnerUpdater(Settings settings) {
		this.settings = settings;
	}

	/**
	 * Refreshes the files in the bill folder.
	 */
	@Override
	public void run() {
		try {
			refreshBusinessPartners();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets Bills and unpacks them to folder specified by settings.
	 * 
	 * @throws IOException
	 */
	public void refreshBusinessPartners() throws IOException {
		System.out.println("***BusinessPartnerUpdate started started***");
		URL url = new URL(settings.getURL() + settings.getUrlImportExtension());
		InputStream is = url.openConnection().getInputStream();

		BufferedReader reader = new BufferedReader( new InputStreamReader( is )  );

		String line = null;
		while( ( line = reader.readLine() ) != null )  {
		       System.out.println(line);
		}
		reader.close();
		System.out.println("***BusinessPartnerUpdated finished***");
	}
}
