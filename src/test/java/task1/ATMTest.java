package task1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ucu.edu.ua.apps.task1.ATM;

public class ATMTest {
    private static final int TEST_PRICE_ONE = 1745;
    private static final int TEST_PRICE_TWO = 1746;
    private static final ATM atm = new ATM();

    @Test
    public void testCorrectProcess() {
        String expected = "You should take 9 of denomination 5\n" +
        "You should take 1 of denomination 200\n" +
        "You should take 1 of denomination 500\n" +
        "You should take 1 of denomination 1000\n";
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        atm.process(TEST_PRICE_ONE);
        System.setOut(System.out);
        Assertions.assertEquals(expected.replaceAll("\\s+", " "),
                                output.toString().replaceAll("\\s+", " "));
        
    }

    @Test
    public void TestIncorrectProcess() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> atm.process(TEST_PRICE_TWO));
    }
}
