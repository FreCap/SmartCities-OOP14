package it.unibo.oop.smartercities.view.mainpanel;

import it.unibo.oop.smartercities.datatype.InfoStreetObserver;
import it.unibo.oop.smartercities.datatype.I.IInfoStreetObserver;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class InformationsPanel extends JPanel implements IInformationsPanel {

	private static final long serialVersionUID = -3058034776743041502L;
	private static final String NEW_LINE = System.lineSeparator();
	private static final String TAB = "          ";
	
	private final JTextArea streetObserverInfo = new JTextArea();
	private final JTextArea carRateInfo = new JTextArea();
	private final JTextArea sightInfo = new JTextArea();
	private final JTextArea speedInfo = new JTextArea();
	
	private IInfoStreetObserver currentInfo;
	
	public InformationsPanel(){
		super();
		this.setBorder(new TitledBorder("Informations"));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.currentInfo = new InfoStreetObserver.Builder().build();
		this.streetObserverInfo.setEditable(false);
		this.streetObserverInfo.setBackground(this.getBackground());;
		this.carRateInfo.setEditable(false);
		this.carRateInfo.setBackground(this.getBackground());;
		this.sightInfo.setEditable(false);
		this.sightInfo.setBackground(this.getBackground());;
		this.speedInfo.setEditable(false);
		this.speedInfo.setBackground(this.getBackground());;
		this.add(streetObserverInfo);
		this.add(carRateInfo);
		this.add(sightInfo);
		this.add(speedInfo);
		this.updateInfo();
	}

	@Override
	public void showInformations(IInfoStreetObserver iso) {
		this.currentInfo = iso;
		this.updateInfo();
	}

	@Override
	public JPanel getPanel() {
		return this;
	}
	
	private void updateInfo() {
		showStreetObserverInfo();
		showCarRateInfo();
		showSightingInfo();
		showSpeedInfo();
	}
	
	private void showStreetObserverInfo() {
		String s = new StringBuilder().append("   STREET OBSERVER\t\t\t")
									  .append(NEW_LINE)
									  .append(TAB + "Location: " + this.currentInfo.getStreetObserverLocation())
									  .append(NEW_LINE)
									  .append(TAB + "ID: " + this.currentInfo.getStreetObserverID())
									  .toString();
		this.streetObserverInfo.setText(s);
		
	}
	
	private void showCarRateInfo() {
		String s = new StringBuilder().append("   CAR RATE")
				  .append(NEW_LINE)
				  .append(TAB + "Max car rate of today: " + this.currentInfo.getMaxCarRateToday())
				  .toString();
		this.carRateInfo.setText(s);
	}
	
	private void showSightingInfo() {
		String s = new StringBuilder().append("   SIGHT DATA")
				  .append(NEW_LINE)
				  .append(TAB + "Number of sight (last hour): " + this.currentInfo.getnOfSightLastHour())
				  .append(NEW_LINE)
				  .append(TAB + "Number of sight (today): " + this.currentInfo.getnOfSightToday())
				  .append(NEW_LINE)
				  .append(TAB + "Number of sight (last week): " + this.currentInfo.getnOfSightLastWeek())
				  .append(NEW_LINE)
				  .append(TAB + "Number of sight (last month): " + this.currentInfo.getnOfSightLastMonth())
				  .toString();
		this.sightInfo.setText(s);
	}

	private void showSpeedInfo() {
		String s = new StringBuilder().append("   SPEED DATA")
				  .append(NEW_LINE)
				  .append(TAB + "Speed limit in this road is: " + this.currentInfo.getSpeedLimit())
				  .append(NEW_LINE)
				  .append(TAB + "Average speed limit (today): " + this.currentInfo.getAverageSpeedToday())
				  .append(NEW_LINE)
				  .append(TAB + "Average speed limit (last week): " + this.currentInfo.getAverageSpeedLastWeek())
				  .append(NEW_LINE)
				  .append(TAB + "Average speed limit (last month): " + this.currentInfo.getAverageSpeedLastMonth())
				  .append(NEW_LINE)
				  .append(TAB + "Max speed registered today is: " + this.currentInfo.getMaxSpeedToday())
				  .toString();
		this.speedInfo.setText(s);
	}

}
