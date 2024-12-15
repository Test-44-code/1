package business2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.Test;

import business.Bahnhof;

class BahnhofTest {

	@Test
	void test() {
		String [] ein = {"RE"};
		Bahnhof bahnhof = new Bahnhof("Majd", "OB", 3, 2023,ein);
		BooleanSupplier test =  (() -> bahnhof.getAnzahlGleise() == 3);
		assertTrue(test,"Majd ist gut");
	}
	

}
