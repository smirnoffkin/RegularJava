import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RegularTest {
    @ParameterizedTest
    @ValueSource(strings = {
            "255.255.255.255",
            "1.10.255.128",
            "0.0.0.0",
            "127.0.0.1",
            "192.168.1.1",
            "192.0.0.0"
    })
    public void testIsValidIP(String ip) {
        Regular executor = new Regular();
        Assertions.assertTrue(executor.isIpAddress(ip));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            " 18.100.29.138",
            "18.100.29.138 ",
            "256.34.29.138",
            "183..0.81",
            "25 75 2 130",
            "lk.1.98.100",
    })
    public void testNonValidIP(String ip) {
        Regular executor = new Regular();
        Assertions.assertFalse(executor.isIpAddress(ip));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "e0e0a4da-b0D1-def9-cae1-afec91BAedEF",
            "[e0e0a4da-b0D1-def9-cae1-afec91BAedEF]",
            "(e0e0a4da-b0D1-def9-cae1-afec91BAedEF)",
            "{e0e0a4da-b0D1-def9-cae1-afec91BAedEF}",
            "00000000-0000-0000-0000-000000000000",
            "e02fd0e4-00fd-090A-ca30-0d00a0038ba0"
    })
    public void testIsValidGUID(String guid) {
        Regular executor = new Regular();
        Assertions.assertTrue(executor.isGuid(guid));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            " FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF",
            "FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF ",
            "FFFFFFFF -FFFF-FFFF-FFFF-FFFFFFFFFFFF",
            "FFFFFFF+FFFF-FFFF-FFFF-FFFFFFFFFFFF",
            "FFFFFFF--FFFF-FFFF-FFFF-FFFFFFFFFFFF",
            "--FFFFFFF--FFFF-FFFF-FFFF-FFFFFFFFFFFF",
    })
    public void testNonValidGUID(String guid) {
        Regular executor = new Regular();
        Assertions.assertFalse(executor.isGuid(guid));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "www.google.com",
            "http://google.com",
            "https://google.com",
            "google.com",
            "https://blog.google.com/",
            "word-dictionary.com/test/demo_form.php?name1=value1&name2=value2",
    })
    public void testIsValidURL(String url) {
        Regular executor = new Regular();
        Assertions.assertTrue(executor.isValidUrl(url));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "192.168.1.1",
            "a.b",
            "https:///ab.b",
            "www.-a.b",
            "www.a-.b",
            "www.a-.b",
            "www.-",
    })
    public void testNonValidURL(String url) {
        Regular executor = new Regular();
        Assertions.assertFalse(executor.isValidUrl(url));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "bsFdk8l0",
            "abcB12aaaaa",
            "As_lva00wqd",
            "lvkaIM0_",
            "_imzpx9_fKwe",
            "kWel62_fwce",
    })
    public void testIsValidPassword(String password) {
        Regular executor = new Regular();
        Assertions.assertTrue(executor.isCorrectPassword(password));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "bsfdk8l0",
            "BSFDK8L0",
            "vajkJvkd_",
            "vajkJ 9vkd_",
            "vajkJ9vkd_!",
            "vajkJ9vkd_@"
    })
    public void testNonValidPassword(String password) {
        Regular executor = new Regular();
        Assertions.assertFalse(executor.isCorrectPassword(password));
    }
}