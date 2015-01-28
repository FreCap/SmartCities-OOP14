package it.unibo.oop.smac.datatype;

import it.unibo.oop.smac.datatype.I.ICoordinates;

import java.io.Serializable;
import java.math.BigDecimal;

public class Coordinates implements ICoordinates, Serializable{

	private static final long serialVersionUID = 6127098657709069219L;

	private static final int DECIMAL_PRECISION = 6;
	
	private final Float latitude;
	private final Float longitude;
	
	public Coordinates(Float latitude, Float longitude) {
		this.latitude = decimalRound(latitude);
		this.longitude = decimalRound(longitude);
	}
	
	public Coordinates(ICoordinates coordinates) {
		this(coordinates.getLatitude(), coordinates.getLongitude());
	}

	/**
	 * Metodo privato utilizzato per troncare i numeri Float fino ad una certa cifra
	 * decimale, stabilita da DECIMAL_PRECISION.
	 * 
	 * @param number
	 * 			Il numero da modificare.
	 * @return
	 * 			Il numero modificato.
	 */
	private static Float decimalRound(Float number) {
        BigDecimal bigDecimal = new BigDecimal(Float.toString(number));
        bigDecimal = bigDecimal.setScale(DECIMAL_PRECISION, BigDecimal.ROUND_HALF_UP);
        return bigDecimal.floatValue();
    }
	
	@Override
	public Float getLongitude() {
		return new Float(this.longitude);  //defensive copy
	}

	@Override
	public Float getLatitude() {
		return new Float(this.latitude);   //defensive copy
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result
				+ ((longitude == null) ? 0 : longitude.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ICoordinates){
			return this.latitude.equals(((ICoordinates) obj).getLatitude())
					&& this.longitude.equals(((ICoordinates) obj).getLongitude());
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Latitude = " + latitude.toString() + 
				", Longitude = " + longitude.toString();
	}

}
