package Section3;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by FI on 24-Apr-16.
 */
public class ReverseShuffleMergeTest {
    @Test
    public void testCase1(){
        String inputString ="eggegg";
        String outputString="egg";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        ReverseShuffleMerge.main(new String[0]);
        assertEquals("Comparison failed: ", outputString.trim(),actualOutput.toString().replace("\r","").trim());
    }

    @Test
    public void testCase2(){
        String inputString ="djjcddjggbiigjhfghehhbgdigjicafgjcehhfgifadihiajgciagicdahcbajjbhifjiaajigdgdfhdiijjgaiejgegbbiigida";
        String outputString="aaaaabccigicgjihidfiejfijgidgbhhehgfhjgiibggjddjjd";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        ReverseShuffleMerge.main(new String[0]);
        assertEquals("Comparison failed: ", outputString.trim(),actualOutput.toString().replace("\r","").trim());
    }

    @Test
    public void testCase3(){
        String inputString ="bdabaceadaedaaaeaecdeadababdbeaeeacacaba";
        String outputString="aaaaaabaaceededecbdb";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        ReverseShuffleMerge.main(new String[0]);
        assertEquals("Comparison failed: ", outputString.trim(),actualOutput.toString().replace("\r","").trim());
    }

    @Test
    public void testCase4(){
        String inputString ="sbcnzxqnrygkocahxjebvueaawwcythjdrhvizqsshgtwdolmillxpshxpxqrywkivceufclhydhshrklkphajbftu" +
                "apiocjlcthfirhgaohfysqjolssbzhbovdstbyqdpnjbpfmgqrzfctcwcrztvgbegunarvecseoulabaonguckqbtrvuagreyclyjy" +
                "tpvozqdnhldlnsocenuzksawirgsbjobpldjdlrxbricrauuksbmecvvwagnnacaqghmjpzrlsvlpbbcuaddgvlhvuvkxexjcfhxro" +
                "dmcwlrzyyiksuksshhonahsyzbbprwuitmoyoqurtqsaslevgvpfbzkkhgcnpjdpseuiylluvdetsqssbrxpiclxxvosuqipsqvvws" +
                "ezhl";
        String outputString="aaaaaavvcembskuabxddlpbbsgiaskucosdlhndqzovpjlcyerauvrbcugnbluescevrnubgvtzrcwccfzrqgmfpb" +
                "jnpdqybtsdvobhzsslojqsyfhoghrifhtclcoiputjhpklkrhsdyhlcuevikwyrqxpxhspxllimlowtghssqzivhrjtywweuvejxo" +
                "kgyrnqxzns";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        ReverseShuffleMerge.main(new String[0]);
        assertEquals("Comparison failed: ", outputString.trim(),actualOutput.toString().replace("\r","").trim());
    }

    @Test
    public void testCase5(){
        String inputString ="fwfcrwgpfflojzfiljoqluudqxrymtegsydlyvvgmfgpwkqxixelvpnlvlrxlzxyyuwmvlmnnnfvvzloypchaaqx" +
                "infvraefxrwdtlaydcljlfxkmaznojjtjaesunggyjrkkfruyjlnqjksttnegzaenrhbefrybuzobtpglngfkrckbxognhzzqwaim" +
                "pqoepkcjralekbrtgdziltaznrazwoljjgrjtfrmpwutzltlfyxcmrsvjkddhnkytdvbhydfxnsoyrnrmtahvhkdfogdeghjbtlgm" +
                "ckossrgsaoxijvpjickcunwjgkldcnprtkrfvytlyibsngvlbtkheeokwbalqmjksmjscqkhplkghgehgbjzzynmrppfonuvlpjlz" +
                "eeqjztcexvcbecdstrggoemgpmsmmlroyglzdmunrfjtmqbkrrfqewpafhfmqhzhokzyjigiwkgkrkrhtqqvpgetwtzflcmxnslju" +
                "xcvivjsmjzyjptrofjfxocidxzefznuxnhzvjcgxpnymvkicnqqfchotgavqvwmivulgniatmeoqzymvsfjcqhcondbxqsukpulvu" +
                "isjvzozedtepydvkoumpyvylzkqjvozhzrhkjfgkggwxjzesxtectvfvpkmfxddhjstomgfjqdyooxezsinfxwrknvtczgwwukwag" +
                "jvdwiuwmbjigxnbrdyzepgeqfaezzekqvqdkkyiwpdfrjvxzxbltjrmulfceffmuzpzftodalvjejycdyzvgtggbaeedfvsstqomw" +
                "mmdfsbxocfgqhkxjkqmradotmneufmbhgaklsrxkdkjlysgivqegsqtrrzpwrptelykgeatacslhqotootuhxloutefrksqwuiyvc" +
                "lfcmjkocjxgtqjshiyryccgesfgpjtxjohevathpvdmtppcbsnmsfezkbulprtphgcmqywrlefmbrebemjzfzhiqcolvhdduukstg" +
                "rlo";
        String outputString="aaaaaaaaaccddeikusbccfseagluimqvagocfqqcikvcjvhnuezxdcoxffortjyzjmsjvivcxujlsnxcfztwtegpv" +
                "qqtgkwgijyzkohzhqmfhapweqbqmtfnumdzgolmmsmpgmeoggrtsdcebcvxectzjqeezjplvunofppmnyzzbgheghgklphkqcsjms" +
                "jmqabwkoeehktblvgnsbiltyvfrktrpcdkgjwnuckcijpvixosgrssokcmgltbhedgodkhvhtmrnryosnxfdyhbvdtykhddkjvsrm" +
                "xyfltlztuwpmrftjrgjjlowzrnztizdgtrbkelrjkpeoqpmiwqzzhgoxbkrkfggptbozuyrfehrezenttskjqjyurfkkrjyggnuse" +
                "jtjjonzmkxfjldyltdwrxfervfixqhpyolzvvfnnnmlvmwuyyxzlxrlvlnpvlexixqkwpfmgvvyldysetmyrxqduulqojlfzjolff" +
                "pgwrfwf";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        ReverseShuffleMerge.main(new String[0]);
        assertEquals("Comparison failed: ", outputString.trim(),actualOutput.toString().replace("\r","").trim());
    }

}