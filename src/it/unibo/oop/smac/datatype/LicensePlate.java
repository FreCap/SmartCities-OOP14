package it.unibo.oop.smac.datatype;

import it.unibo.oop.smac.utils.RandomStringGenerator;

import java.io.Serializable;

public class LicensePlate implements Serializable {

	private static final long serialVersionUID = -194344929770325193L;
	private final String licensePlate;

	public LicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((licensePlate == null) ? 0 : licensePlate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LicensePlate) {
			return this.toString().equals(obj.toString());
		}
		return false;
	}

	@Override
	public String toString() {
		return licensePlate;
	}

	public static LicensePlate generate() {
		LicensePlate licensePlate = new LicensePlate(
				RandomStringGenerator.generateRandomString(2,
						RandomStringGenerator.Mode.ALPHA)
						+ RandomStringGenerator.generateRandomString(3,
								RandomStringGenerator.Mode.NUMERIC)
						+ RandomStringGenerator.generateRandomString(2,
								RandomStringGenerator.Mode.ALPHA));
		return licensePlate;

	}

}
