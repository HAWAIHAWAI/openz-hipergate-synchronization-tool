package ui;

import global.Settings;
import io.BusinessPartnerUpdater;
import io.SettingsInstantiation;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Timer;

/**
 * This class provides the update service for the openz-csv-import-export.
 * 
 * @author cglaeser
 *
 */
public class UpdateService {

	/**
	 * Settings for UpdateService.
	 */
	private Settings settings;

	/**
	 * Required for UpdateService to update the files in the specified folder.
	 * 
	 * @see {@link Settings} for settings of the program.
	 */
	private Timer time;

	/**
	 * Constructor for the update service. Creates an UpdateService with the
	 * previously specified settings.
	 * 
	 * @throws IOException
	 *             When settings file can't be read
	 */
	public UpdateService() throws IOException {
		System.out.println("loading settings...");
		settings = SettingsInstantiation.getSettings();
		time = new Timer(true);
		BusinessPartnerUpdater bd = new BusinessPartnerUpdater(settings);
		time.scheduleAtFixedRate(bd, 0, settings.getUpdateInterval() * 1000);
		final TrayIcon trayIcon;

		if (SystemTray.isSupported()) {

			SystemTray tray = SystemTray.getSystemTray();
			Image image = Toolkit.getDefaultToolkit().getImage(
					"images/Connector-Icon.jpg");

			ActionListener exitListener = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Exiting...");
					System.exit(0);
					time.cancel();
				}
			};

			PopupMenu popup = new PopupMenu();
			MenuItem defaultItem = new MenuItem("Exit");
			defaultItem.addActionListener(exitListener);
			popup.add(defaultItem);

			trayIcon = new TrayIcon(image, "HAWAI-Hipergate Synchronization", popup);
			trayIcon.setImageAutoSize(true);

			try {
				tray.add(trayIcon);
			} catch (AWTException e) {
				System.err.println("TrayIcon could not be added.");
			}

		} else {
			System.err.println("System tray is currently not supported.");
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		try {
			UpdateService main = new UpdateService();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
