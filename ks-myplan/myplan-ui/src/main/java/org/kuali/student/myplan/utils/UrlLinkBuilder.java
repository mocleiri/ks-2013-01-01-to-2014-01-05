package org.kuali.student.myplan.utils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: hemanthg
 * Date: 12/3/13
 * Time: 6:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class UrlLinkBuilder {
    private static final Pattern REGEX_URL =
            Pattern.compile(
                    "\\(?\\b((?:https?://|ftps?://|mailto:|www[.])[-A-Za-z0-9+&@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&@#/%=~_()|])");

    private static final String REPLACE_URL =
            "<a target=\"_blank\" href=\"{1}\">{0}</a>";


    public static String buildLinksForText(String content) {
        Matcher m = REGEX_URL.matcher(content);
        List<Token> tokens = new ArrayList<Token>();
        int position = 0;
        String tokenContent = null;

        while (m.find()) {
            int start = m.start();
            int end = m.end();
            String replacement = m.group();

            if (replacement.startsWith("www")) {
                replacement = "http://" + replacement;
            }

            tokenContent = content.substring(position, start);
            tokens.add(new Token(tokenContent));
            tokenContent = content.substring(start, end);
            tokens.add(new Token(tokenContent, replacement));
            position = end;
        }

        tokenContent = content.substring(position, content.length());
        tokens.add(new Token(tokenContent));

        StringBuilder buffer = new StringBuilder();

        for (Token token : tokens) {
            if (token.getReplacement() != null) {
                buffer.append(MessageFormat.format(REPLACE_URL, token.getValue(),
                        token.getReplacement()));
            } else {
                buffer.append(token.getValue());
            }
        }

        return buffer.toString();
    }

    private static class Token {

        public Token(String value) {
            this.value = value;
        }

        public Token(String value, String replacement) {
            this.value = value;
            this.replacement = replacement;
        }

        public String getReplacement() {
            return replacement;
        }

        public String getValue() {
            return value;
        }

        private String replacement;
        private String value;
    }
}
