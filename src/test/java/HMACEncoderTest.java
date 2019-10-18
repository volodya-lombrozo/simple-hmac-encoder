import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HMACEncoderTest {

    private Map<String, String> expectedValues = new HashMap<>();

    @BeforeEach
    void setUp() {
        HMACEncoder.init("secretKey");
        initExpectedValues();
    }

    private void initExpectedValues() {
        expectedValues.put("text", "5df9d7a9d937542ed65d9eea31e24dd5debffb1c407ddb45fb5be188fb4737a6");
        expectedValues.put("0123456789", "e6ff42527006b2fb011b04eaa183d0c46c27feeef418e2aeacdfb6b6fbd27cda");
        expectedValues.put("BIG_TEXT", "aca36fe826ce744263e4d9553566b3cd1bd9ecee3ca26ca99d3e39e8c2f07c1c");
        expectedValues.put("big_text", "484d7a97f3e0d0a685904266cbe9c46a3ba5d53b6bb17148b983d2dbe0927d84");
        expectedValues.put("long_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_textlong_text", "9c1c3c044900c171cc9230a3e28140eae5ce0fd44b3c285e49d5d415a41da413");

    }

    @Test
    void encode() {
        expectedValues.keySet().forEach(this::assertConvert);
    }


    private void assertConvert(String key) {
        String hmacResult = HMACEncoder.encode(key);
        assertEquals(expectedValues.get(key), hmacResult.toLowerCase());
    }
}