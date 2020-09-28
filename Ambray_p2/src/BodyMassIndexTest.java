import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BodyMassIndexTest {
    //Category Tests
    @Test
    void categorizeUnderweightBMIA() {
        assertEquals("Underweight", BodyMassIndex.categorizeBMI(10));
    }

    @Test
    void categorizeUnderweightBMIB() {
        assertEquals("Underweight", BodyMassIndex.categorizeBMI(18.49));
    }

    @Test
    void categorizeNormalBMIA() {
        assertEquals("Normal weight", BodyMassIndex.categorizeBMI(18.5));
    }

    @Test
    void categorizeNormalBMIB() {
        assertEquals("Normal weight", BodyMassIndex.categorizeBMI(24.9));
    }

    @Test
    void categorizeOverweightBMIA() {
        assertEquals("Overweight", BodyMassIndex.categorizeBMI(25));
    }

    @Test
    void categorizeOverweightBMIB() {
        assertEquals("Overweight", BodyMassIndex.categorizeBMI(29.9));
    }

    @Test
    void categorizeObeseBMIA() {
        assertEquals("Obese", BodyMassIndex.categorizeBMI(30));
    }

    @Test
    void categorizeObeseBMIB() {
        assertEquals("Obese", BodyMassIndex.categorizeBMI(40));
    }

    //Tests for BMI
    @Test
    void bmi_5ft_100lbs(){
        BodyMassIndex e = new BodyMassIndex(60,100);
        assertEquals(703 * 100.00 / (60.00 * 60.00), e.calculateBMI());
    }

    @Test
    void bmi_5ft6_100lbs(){
        BodyMassIndex e = new BodyMassIndex(66,100);
        assertEquals(703 * 100.00 / (66.00 * 66.00), e.calculateBMI());
    }

    @Test
    void bmi_Tacko(){
        BodyMassIndex e = new BodyMassIndex(89,311);
        assertEquals(703 * 311.00 / (89 * 89), e.calculateBMI());
    }

    @Test
    void bmi_Herro(){
        BodyMassIndex e = new BodyMassIndex(77,195);
        assertEquals(703 * 195.00 / (77 * 77), e.calculateBMI());
    }

    @Test
    void bmi_Mugsy(){
        BodyMassIndex e = new BodyMassIndex(63,134);
        assertEquals(703 * 134.00 / (63 * 63), e.calculateBMI());
    }
}