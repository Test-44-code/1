package business;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class BahnhofTest {

	@Test
	void test() 
	{
		String [] ein = {"ICE","IC","RE","RB","S"};
		Bahnhof bahnhof = new Bahnhof("Essen HBF", "Essen", 21, 2000, ein);
		BooleanSupplier test = ()->bahnhof.getName().equals("Essen HBF");
		assertTrue(test,"Fehler");
	}
	
	@Test
	void test1()
	{
		assertThrows(IllegalArgumentException.class,()->new Bahnhof("Essen HBF", "Essen", 21, 2000, null));
	}

}
