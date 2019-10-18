import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HexEncoderTest {

    private Map<String, String> expectedValues = new HashMap<>();

    @BeforeEach
    void setUp() {
        expectedValues.put("asdasd", "617364617364");
        expectedValues.put("someLongTextsomeLongTextsomeLongTextsomeLongTextsomeLongTextsomeLongTextsomeLongTextsomeLongTextsomeLongText",
                "736f6d654c6f6e6754657874736f6d654c6f6e6754657874736f6d654c6f6e6754657874736f6d654c6f6e6754657874736f6d654c6f6e6754657874736f6d654c6f6e6754657874736f6d654c6f6e6754657874736f6d654c6f6e6754657874736f6d654c6f6e6754657874");
        expectedValues.put("123123123123", "313233313233313233313233");
    }

    @Test
    void hex() {
        expectedValues.keySet().forEach(this::assertConvert);
    }


    private void assertConvert(String key) {
        String hex = HexEncoder.hex(key.getBytes());
        assertEquals(expectedValues.get(key), hex.toLowerCase());
    }
}