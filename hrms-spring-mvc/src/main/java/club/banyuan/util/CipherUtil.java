package club.banyuan.util;

import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class CipherUtil {

    private static final String SECRET_KEY = PropUtil.getProp("secret.key");

    public static String hmacSha256(String target) {
        HMac hMac = new HMac(HmacAlgorithm.HmacSHA256, SECRET_KEY.getBytes());
        return hMac.digestHex(target);
    }

    public static String hmacSha256(String target, String key) {
        HMac hMac = new HMac(HmacAlgorithm.HmacSHA256, key.getBytes());
        return hMac.digestHex(target);
    }

    public static void main(String[] args) {
        System.out.println(hmacSha256("123456"));
    }
}
