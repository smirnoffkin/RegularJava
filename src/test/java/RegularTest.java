import org.junit.Assert;
import org.junit.Test;

public class RegularTest {
    @Test
    public void testBroadcastAddress(){
        Regular executor = new Regular();
        Assert.assertTrue(executor.isIpAddress("255.255.255.255"));
    }

    @Test
    public void testCorrectIp(){
        Regular executor = new Regular();
        Assert.assertTrue(executor.isIpAddress("1.10.255.128"));
    }

    @Test
    public void testNonRoutableMetaAddress(){
        Regular executor = new Regular();
        Assert.assertTrue(executor.isIpAddress("0.0.0.0"));
    }

    @Test
    public void testLocalHost(){
        Regular executor = new Regular();
        Assert.assertTrue(executor.isIpAddress("127.0.0.1"));
    }

    @Test
    public void testWithExtraSpaceBefore(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isIpAddress(" 18.100.29.138"));
    }

    @Test
    public void testWithExtraSpaceAfter(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isIpAddress("18.100.29.138 "));
    }

    @Test
    public void testNonExistingIpAddress(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isIpAddress("256.34.29.138"));
    }

    @Test
    public void testWithEmptyByte(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isIpAddress("183..0.81"));
    }

    @Test
    public void testWithoutDots(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isIpAddress("25 75 2 130"));
    }

    @Test
    public void testWithExtraDots(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isIpAddress("18..0.98.46"));
    }

    @Test
    public void testNonSignificantZero(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isIpAddress("18.01.98.100"));
    }

    @Test
    public void testWithLetter(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isIpAddress("l8.1.98.100"));
    }

    @Test
    public void testWithNegativeByte(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isIpAddress("-1.1.9.1"));
    }

    @Test
    public void testCorrectGuid(){
        Regular executor = new Regular();
        Assert.assertTrue(executor.isGuid("e0e0a4da-b0D1-def9-cae1-afec91BAedEF"));
    }

    @Test
    public void testGuidWithSquareBrackets(){
        Regular executor = new Regular();
        Assert.assertTrue(executor.isGuid("[e0e0a4da-b0D1-def9-cae1-afec91BAedEF]"));
    }

    @Test
    public void testGuidWithRoundBrackets(){
        Regular executor = new Regular();
        Assert.assertTrue(executor.isGuid("(e0e0a4da-b0D1-def9-cae1-afec91BAedEF)"));
    }

    @Test
    public void testGuidWithCurlyBrackets(){
        Regular executor = new Regular();
        Assert.assertTrue(executor.isGuid("{e0e0a4da-b0D1-def9-cae1-afec91BAedEF}"));
    }

    @Test
    public void testGuidOnlyZeros(){
        Regular executor = new Regular();
        Assert.assertTrue(executor.isGuid("00000000-0000-0000-0000-000000000000"));
    }

    @Test
    public void testGuidWithExtraSpaceBefore(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isGuid(" FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF"));
    }

    @Test
    public void testGuidWithExtraSpaceAfter(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isGuid("FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF "));
    }

    @Test
    public void testGuidWithExtraSpaceInside(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isGuid("FFFFFFFF -FFFF-FFFF-FFFF-FFFFFFFFFFFF"));
    }

    @Test
    public void testGuidWithWrongSymbolInTheFirstByte(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isGuid("gFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF"));
    }

    @Test
    public void testGuidWithExtraSymbolInTheSecondByte(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isGuid("FFFFFFF-FFFFF-FFFF-FFFF-FFFFFFFFFFFF"));
    }

    @Test
    public void testGuidWithWrongSeparator(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isGuid("FFFFFFF+FFFF-FFFF-FFFF-FFFFFFFFFFFF"));
    }

    @Test
    public void testGuidWithDoubleSeparator(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isGuid("FFFFFFF--FFFF-FFFF-FFFF-FFFFFFFFFFFF"));
    }

    @Test
    public void testUrlWithOnlyWww(){
        Regular executor = new Regular();
        Assert.assertTrue(executor.isValidUrl("www.google.com"));
    }

    @Test
    public void testUrlWithOnlyHttp(){
        Regular executor = new Regular();
        Assert.assertTrue(executor.isValidUrl("http://google.com"));
    }

    @Test
    public void testUrlWithOnlyHttpS(){
        Regular executor = new Regular();
        Assert.assertTrue(executor.isValidUrl("https://google.com"));
    }

    @Test
    public void testUrlWithoutHttpSAndWww(){
        Regular executor = new Regular();
        Assert.assertTrue(executor.isValidUrl("google.com"));
    }

    @Test
    public void testUrlWithSubdomain(){
        Regular executor = new Regular();
        Assert.assertTrue(executor.isValidUrl("https://blog.example.ru/"));
    }

    @Test
    public void testGetRequest(){
        Regular executor = new Regular();
        Assert.assertTrue(executor.isValidUrl("word-dictionary.com/test/demo_form.php?name1=value1&name2=value2"));
    }

    @Test
    public void testUrlLikeIp(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isValidUrl("192.168.1.1"));
    }

    @Test
    public void testUrlWithDomainLess2(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isValidUrl("a.b"));
    }

    @Test
    public void testUrlWithExtraSlashAfterHttps(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isValidUrl("https:///ab.b"));
    }

    @Test
    public void testUrlWithDashBeforeDomain(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isValidUrl("www.-a.b"));
    }

    @Test
    public void testUrlWithDashAfterDomain(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isValidUrl("www.a-.b"));
    }

    @Test
    public void testWrongUrl(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isValidUrl("www.-"));
    }

    @Test
    public void testCorrectPassword1(){
        Regular executor = new Regular();
        Assert.assertTrue(executor.isCorrectPassword("bsFdk8l0"));
    }

    @Test
    public void testCorrectPassword2(){
        Regular executor = new Regular();
        Assert.assertTrue(executor.isCorrectPassword("abcB12aaaaa"));
    }

    @Test
    public void testCorrectPassword3(){
        Regular executor = new Regular();
        Assert.assertTrue(executor.isCorrectPassword("As_lva00wqd"));
    }

    @Test
    public void testCorrectPassword4(){
        Regular executor = new Regular();
        Assert.assertTrue(executor.isCorrectPassword("lvkaIM0_"));
    }

    @Test
    public void testCorrectPassword5(){
        Regular executor = new Regular();
        Assert.assertTrue(executor.isCorrectPassword("_imzpx9_fKwe"));
    }

    @Test
    public void testCorrectPassword6(){
        Regular executor = new Regular();
        Assert.assertTrue(executor.isCorrectPassword("kWel62_fwce"));
    }

    @Test
    public void testPasswordWithoutCapital(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isCorrectPassword("bsfdk8l0"));
    }

    @Test
    public void testPasswordWithoutLowercase(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isCorrectPassword("BSFDK8L0"));
    }

    @Test
    public void testPasswordWithoutNumbers(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isCorrectPassword("vajkJvkd_"));
    }

    @Test
    public void testPasswordWithSpace(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isCorrectPassword("vajkJ 9vkd_"));
    }

    @Test
    public void testPasswordWithExclamationMark(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isCorrectPassword("vajkJ9vkd_!"));
    }

    @Test
    public void testPasswordWithAt(){
        Regular executor = new Regular();
        Assert.assertFalse(executor.isCorrectPassword("vajkJ9vkd_@"));
    }
}