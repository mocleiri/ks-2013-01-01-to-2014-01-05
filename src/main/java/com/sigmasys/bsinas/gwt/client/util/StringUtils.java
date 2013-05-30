package com.sigmasys.bsinas.gwt.client.util;

import java.util.Collection;

/**
 * GWT client side utility for string operations
 *
 * @author Michael Ivanov
 */
public class StringUtils {

    private StringUtils() {
    }

    public static boolean isEmpty(String string) {
        return string == null || string.trim().length() == 0;
    }

    /**
     * Equivalent of apache lang commons SpringUtils.join()
     *
     * @param values    collection of values to be concatenated
     * @param separator a separator string used for value concatenation
     * @return a string representation of list
     */
    public static String listToString(Collection<?> values, String separator) {
        StringBuilder result = new StringBuilder();
        if (values != null) {
            boolean firstItem = true;
            for (Object value : values) {
                if (!firstItem) {
                    result.append(separator);
                }
                result.append(value);
                firstItem = false;
            }
        }
        return result.toString();
    }

    public static String toString(Object obj) {
        return obj == null ? "" : obj.toString().trim();
    }

    /**
     * Builds the new string based on the given string inserting
     * a given delimiter string at the given distance > 0 between the characters
     * of the original string.
     *
     * @param text      the original string
     * @param delimiter the string-delimiter
     * @param distance  the distance between characters for inserting delimiters
     * @return delimited string
     */
    public static String insertDelimiter(String text, String delimiter, int distance) {
        if (!isEmpty(text) && !isEmpty(delimiter) && distance > 0) {
            char[] chars = new char[text.length()];
            text.getChars(0, chars.length - 1, chars, 0);
            StringBuilder buffer = new StringBuilder(chars.length);
            int index = 0;
            for (char c : chars) {
                if (distance == index) {
                    buffer.append(delimiter);
                    index = 0;
                }
                buffer.append(c);
                index++;
            }
            return buffer.toString();
        }
        return text;
    }

    /**
     * Builds the new string based on the given string inserting
     * a given delimiter string at the given distance > 0 between the words
     * of the original string. It takes words and punctuation into account.
     * Example:
     * Original string: "This is a sentence.  This      is a question, right?  Yes!  It is.!!!?. Yeah!! Ok"
     * Apply: separateWordsWithDelimiter(str, "<BR/>", 5)
     * Output: "This <BR/>is a <BR/>sentence.  <BR/>This      <BR/>is a <BR/>question, <BR/>right?  <BR/>Yes!  <BR/>
     * It is.!!!?. <BR/>Yeah!! <BR/>Ok"
     *
     * @param text      the original string
     * @param delimiter the string-delimeter
     * @param distance  the distance between characters for inserting delimeters
     * @return delimited string
     */
    public static String separateWordsWithDelimiter(String text, String delimiter, int distance) {
        if (!isEmpty(text) && !isEmpty(delimiter) && distance > 0) {
            StringBuilder buffer = new StringBuilder(text.length());
            // Retrieving words from the sentence
            String[] words = text.split("[ .,?!]+");
            int length = 0;
            int prevIndex = 0;
            for (String word : words) {
                int curIndex = text.indexOf(word, prevIndex);
                String delimString = text.substring(prevIndex, curIndex);
                buffer.append(delimString);
                length += delimString.length();
                if (distance <= length) {
                    buffer.append(delimiter);
                    length = 0;
                }
                buffer.append(word);
                length += word.length();
                prevIndex = curIndex + word.length();
            }
            return buffer.toString();
        }
        return text;
    }

}
