import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HMACEncoder {

    private static final String ALGORITHM = "HmacSHA256";
    private static Mac HMAC;

    public static synchronized void init(String secretKey) {
        try {
            HMAC = Mac.getInstance(ALGORITHM);
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);
            HMAC.init(secretKeySpec);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    public static String encode(String payload) {
        byte[] encodedPayload = HMAC.doFinal(payload.getBytes());
        return HexEncoder.hex(encodedPayload);
    }


}
