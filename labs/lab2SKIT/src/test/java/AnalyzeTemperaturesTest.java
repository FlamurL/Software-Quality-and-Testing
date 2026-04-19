import lab.TemperatueAnalyzer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AnalyzeTemperaturesTest {


    private static String run(int... temps) {
        return TemperatueAnalyzer.analyzeTemperatures(temps);
    }


    @Test
    @DisplayName("TC1 – Empty array → 'No warm days.'  [PPC + EPC]")
    void testEmptyArray() {
        assertEquals("No warm days.", run());
    }


    @Test
    @DisplayName("TC2 – Single invalid temp (>60) → 'Invalid temperatures detected.'  [PPC + EPC]")
    void testSingleInvalidAboveMax() {
        assertEquals("Invalid temperatures detected.", run(61));
    }


    @Test
    @DisplayName("TC3 – Single invalid temp (<-50) → 'Invalid temperatures detected.'  [PPC + EPC]")
    void testSingleInvalidBelowMin() {
        assertEquals("Invalid temperatures detected.", run(-51));
    }


    @Test
    @DisplayName("TC4 – Single warm temp (20°C) → 'All days were warm.'  [PPC + EPC]")
    void testSingleWarmDay() {
        assertEquals("All days were warm.", run(20));
    }

    @Test
    @DisplayName("TC5 – Single cold temp (0°C) → 'No warm days.'  [PPC + EPC]")
    void testSingleColdDay() {
        assertEquals("No warm days.", run(0));
    }

    @Test
    @DisplayName("TC6 – All days warm (25, 30, 22) → 'All days were warm.'  [PPC + EPC]")
    void testAllDaysWarm() {
        assertEquals("All days were warm.", run(25, 30, 22));
    }

    @Test
    @DisplayName("TC7 – No warm days (10, -5, 15) → 'No warm days.'  [PPC + EPC]")
    void testNoColdDays() {
        assertEquals("No warm days.", run(10, -5, 15));
    }


    @Test
    @DisplayName("TC8 – Mixed temps (10, 25, 5) → 'Some days were warm.'  [PPC + EPC]")
    void testSomeDaysWarm() {
        assertEquals("Some days were warm.", run(10, 25, 5));
    }


    @Test
    @DisplayName("TC9 – Invalid among valid temps (10, 100, 20) → 'Invalid temperatures detected.'  [PPC + EPC]")
    void testInvalidAmongValid() {
        assertEquals("Invalid temperatures detected.", run(10, 100, 20));
    }


    @Test
    @DisplayName("TC10 – Boundary temp exactly 60°C → 'All days were warm.'  [Boundary / EPC]")
    void testBoundaryExactly60() {
        assertEquals("All days were warm.", run(60));
    }

    @Test
    @DisplayName("TC11 – Boundary temp exactly -50°C → 'No warm days.'  [Boundary / EPC]")
    void testBoundaryExactlyMinus50() {
        assertEquals("No warm days.", run(-50));
    }


    @Test
    @DisplayName("TC12 – Temp just below warm threshold (19°C) → 'No warm days.'  [Boundary / EPC]")
    void testBoundaryJustBelowWarm() {
        assertEquals("No warm days.", run(19));
    }


    @Test
    @DisplayName("TC13 – Multiple invalid temps (-100, 200) → 'Invalid temperatures detected.'  [PPC]")
    void testMultipleInvalidTemps() {
        assertEquals("Invalid temperatures detected.", run(-100, 200));
    }

    @Test
    @DisplayName("TC14 – Large mixed array (50 warm + 50 cold) → 'Some days were warm.'  [EPC loop-back]")
    void testLargeArray() {
        int[] temps = new int[100];
        for (int i = 0; i < 50; i++) temps[i] = 25;   // warm
        for (int i = 50; i < 100; i++) temps[i] = 10;  // cold
        assertEquals("Some days were warm.", run(temps));
    }
}