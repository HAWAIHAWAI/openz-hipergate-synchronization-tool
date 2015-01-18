package io;

import global.Settings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.TimerTask;

/**
 * Class for retrieving BusinessPartner(s) from the Message-Queue.
 * 
 * @author cglaeser.
 */
public class BusinessPartnerUpdater extends TimerTask {


	/**
	 * Settings of BusinessPartnerUpdater.
	 */
	private Settings settings;

	/**
	 * Constructor for BusinessPartnerUpdater.
	 * 
	 * @param settings
	 *            Settings for BusinessPartnerUpdater.
	 */
	public BusinessPartnerUpdater(Settings settings) {
		this.settings = settings;
	}

	/**
	 * Action to refresh the BusinessPartner(s) in the database.
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
	 * Refreshes the BusinessPartner(s) in the database.
	 * 
	 * @throws IOException Error occurred during execution...
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
