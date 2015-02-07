package it.unibo.oop.smac.view.stolencarspanel;

import it.unibo.oop.smac.datatype.I.IStolenCar;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * Modello che gestisce la visualizzazione dei dati contenuti nel DB delle
 * stolen cars
 */
public class StolenCarTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 6581624902840366368L;

	/**
	 * List delle righe che devono essere visualizzate
	 */
	private List<IStolenCar> stolenCars;

	/**
	 * Colonne della tabella
	 */
	private static final String[] columnNames = { "Id", "Targa", "Inserimento" };

	/**
	 * Costruttore che inizializza una tabella vuota
	 */
	public StolenCarTableModel() {
		stolenCars = new ArrayList<IStolenCar>();
	}

	/**
	 * Funzione che permette l'aggiornamento della tabella con nuovi dati
	 * 
	 * @param stolenCars
	 */
	public void updateList(List<IStolenCar> stolenCars) {
		this.stolenCars = stolenCars;
		int rowCount = getRowCount();
		fireTableRowsInserted(rowCount, rowCount);
	}

	/**
	 * Metodo che permette la restituzione del numero di righe da visualizzare
	 * basandosi sul model di dati custom su cui si basa la tabella
	 * 
	 * @return int Numero di righe
	 */
	@Override
	public int getRowCount() {
		return stolenCars.size();
	}

	/**
	 * Metodo che restituisce il numero di colonne della tabella
	 * 
	 * @return int Numero di colonne
	 */
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	/**
	 * Restituisce il nome della colonna
	 * 
	 * @param colonna
	 *            di cui si richiede il nome
	 * @return una stringa che contiene il nome di default della
	 *         <code>colonna</code>
	 */
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	/**
	 * Metodo che impedisce la modifica di qualsiasi riga nella tabella
	 */
	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}

	/**
	 * Restituisc il valore della casella all'index <code>col</code> e
	 * <code>row</code>.
	 *
	 * @param row
	 *            riga del valore richiesto
	 * @param column
	 *            colonna del valore richiesto
	 * @return l'oggetto corrispondente ad una determinata riga-colonna
	 */
	@Override
	public Object getValueAt(int row, int col) {
		if (col == 0) {
			return row + 1;
		} else if (col == 1) {
			DateFormat df = DateFormat.getDateInstance();
			Date current = this.getStolenCars().get(row).getInsertionDate();
			return df.format(current);
		} else if (col == 2) {
			return this.getStolenCars().get(row).getLicensePlate();
		} else {
			return null;
		}
	}

	/**
	 * Getter per la lista delle righe da visualizzare
	 */
	private List<IStolenCar> getStolenCars() {
		return stolenCars;
	}

}
