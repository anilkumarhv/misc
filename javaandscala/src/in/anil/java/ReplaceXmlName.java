package in.anil.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 *  Reg Expression docs
 *  url : https://dzone.com/refcardz/regular-expressions?chapter=1
 * */
public class ReplaceXmlName {
    public static void main(String[] args) {
        String text = "<Test:Name>hello</Test:Name>";
        Pattern pattern = Pattern.compile("(?<=<)\\w+:");
        Matcher matcher = pattern.matcher(text);
        final String sReplacer = "";

        while (matcher.find()) {
            text = text.replaceAll(matcher.group(), sReplacer);
        }
        System.out.println(text);

    }
}
