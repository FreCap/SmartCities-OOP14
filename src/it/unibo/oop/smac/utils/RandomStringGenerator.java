package it.unibo.oop.smac.utils;

/**
 * Generatore di stringhe formato da u determinato set di caratteri
 */
public final class RandomStringGenerator {

	private RandomStringGenerator() {

	}

	public static enum Mode {
		ALPHA, ALPHANUMERIC, NUMERIC
	}

	/**
	 * Utility che data la lunghezza e la modalità di generazione, restituisce
	 * una stringa composta dai caratteri richiesti
	 * 
	 * @param length
	 * @param mode
	 * @return
	 */
	public static String generateRandomString(final int length, final Mode mode) {

		final StringBuffer buffer = new StringBuffer();
		String characters = "";
		switch (mode) {
		case ALPHA:
			characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			break;
		case NUMERIC:
		default:
			characters = "1234567890";
			break;
		}

		final int charactersLength = characters.length();

		for (int i = 0; i < length; i++) {
			final double index = Math.random() * charactersLength;
			buffer.append(characters.charAt((int) index));
		}
		return buffer.toString();
	}
}