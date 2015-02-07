package it.unibo.oop.smac.view.stolencarspanel;

import it.unibo.oop.smac.datatype.I.IInfoStolenCar;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class StolenCarTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6581624902840366368L;

	private List<IInfoStolenCar> stolenCars;
	private static final String[] columnNames = { "Id", "Targa", "Inserimento" };

	public StolenCarTableModel() {
		stolenCars = new ArrayList<IInfoStolenCar>();
	}

	public void updateList(List<IInfoStolenCar> stolenCars) {
		this.stolenCars = stolenCars;
		int rowCount = getRowCount();
		fireTableRowsInserted(rowCount, rowCount);
	}

	@Override
	public int getRowCount() {
		return stolenCars.size();
	}

	public List<IInfoStolenCar> getStolenCars() {
		return stolenCars;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}

	@Override
	public Object getValueAt(int row, int col) {
		if (col == 0) {
			return row + 1;
		} else if (col == 1) {
			return this.getStolenCars().get(row).getDataInserimento();
		} else if (col == 2) {
			return this.getStolenCars().get(row).getLicensePlate();
		} else {
			return null;
		}
	}

}
