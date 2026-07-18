import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FirstTest {
    //КРАТНО 3, ВОЗВРАЩАТЬ "Т"
    //КРАТНО 5, ВОЗВРАЩАТЬ "М"
    //КРАТНО 3 И 5, ВОЗВРАЩАТЬ "ТИМ"
    //ВОЗВРАЩАТЬ "FAIL"

    public String trialCode(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "ТИМ";
        } else if (number % 5 == 0) {
            return "М";
        } else if (number %3 == 0) {
            return "Т";
        }else return "FAIL";
    }

    @Test
    public void checkNumber () {
        String actualResult = trialCode(3);
        assertEquals(actualResult, "Т");
    }

    @Test
    public void checkNumber2 () {
        String actualResult = trialCode(25);
        assertEquals(actualResult, "М");
    }

    @Test
    public void checkNumber4 () {
        String actualResult = trialCode(17);
        assertEquals(actualResult, "FAIL");
    }
}
