/*
 * Copyright 2003 - 2018 The eFaps Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.efaps.dataexporter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.efaps.dataexporter.model.AlignType;
import org.efaps.dataexporter.util.Util;

/**
 * Class used to align the text according to different alignment modes. This is
 * completely independent
 * class and can be used in other applications. Sample usage is shown below.
 *
 * <pre>
 *
 * public static void main(String[] args)
 * {
 *     TextAligner textAligner = new TextAligner();
 *     for (AlignType align : AlignType.values()) {
 *
 *         System.out.println("&lt;h1&gt;" + align.toString() + "&lt;/h1&gt;");
 *         List&lt;String&gt; list = (textAligner.align(15, 10, align,
 *                         "Hello world is the common phrase used everywhere. In this sentense somewordsarereallyreallybig ones."));
 *         for (String string : list) {
 *             System.out.println("|" + string + "|");
 *         }
 *         System.out.println("");
 *     }
 * }
 * </pre>
 *
 * which produces the following output
 *
 * <pre>
 * <h1>TOP_LEFT</h1>
 * |Hello world is |
 * |the common     |
 * |phrase used    |
 * |everywhere. In |
 * |this sentense  |
 * |somewordsarerea|
 * |llyreallybig   |
 * |ones.          |
 * |               |
 * |               |
 *
 * <h1>TOP_CENTER</h1>
 * |Hello world is |
 * |  the common   |
 * |  phrase used  |
 * |everywhere. In |
 * | this sentense |
 * |somewordsarerea|
 * | llyreallybig  |
 * |     ones.     |
 * |               |
 * |               |
 *
 * <h1>TOP_RIGHT</h1>
 * | Hello world is|
 * |     the common|
 * |    phrase used|
 * | everywhere. In|
 * |  this sentense|
 * |somewordsarerea|
 * |   llyreallybig|
 * |          ones.|
 * |               |
 * |               |
 *
 * <h1>MIDDLE_LEFT</h1>
 * |               |
 * |Hello world    |
 * |is the common  |
 * |phrase used    |
 * |everywhere.    |
 * |In this sentense|
 * |somewordsarerea|
 * |llyreallybig   |
 * |ones.          |
 * |               |
 *
 * <h1>MIDDLE_CENTER</h1>
 * |               |
 * |  Hello world  |
 * | is the common |
 * |  phrase used  |
 * |  everywhere.  |
 * |In this sentense|
 * |somewordsarerea|
 * | llyreallybig  |
 * |     ones.     |
 * |               |
 *
 * <h1>MIDDLE_RIGHT</h1>
 * |               |
 * |    Hello world|
 * |  is the common|
 * |    phrase used|
 * |    everywhere.|
 * |In this sentense|
 * |somewordsarerea|
 * |   llyreallybig|
 * |          ones.|
 * |               |
 *
 * <h1>BOTTOM_LEFT</h1>
 * |               |
 * |               |
 * |Hello world    |
 * |is the common  |
 * |phrase used    |
 * |everywhere. In |
 * |this sentense  |
 * |somewordsarerea|
 * |llyreallybig   |
 * |ones.          |
 *
 * <h1>BOTTOM_CENTER</h1>
 * |               |
 * |               |
 * |  Hello world  |
 * | is the common |
 * |  phrase used  |
 * |everywhere. In |
 * | this sentense |
 * |somewordsarerea|
 * | llyreallybig  |
 * |     ones.     |
 *
 * <h1>BOTTOM_RIGHT</h1>
 * |               |
 * |               |
 * |    Hello world|
 * |  is the common|
 * |    phrase used|
 * | everywhere. In|
 * |  this sentense|
 * |somewordsarerea|
 * |   llyreallybig|
 * |          ones.|
 *
 * </pre>
 *
 * @author Santhosh Kumar
 */
public class TextAligner
{

    /** The evaluate for line breaks. */
    private boolean evaluateForLineBreaks = false;

    /**
     * Checks if is evaluate for line breaks.
     *
     * @return the evaluate for line breaks
     */
    public boolean isEvaluateForLineBreaks()
    {
        return this.evaluateForLineBreaks;
    }

    /**
     * Sets the evaluate for line breaks.
     *
     * @param _evaluateForLineBreaks the new evaluate for line breaks
     */
    public void setEvaluateForLineBreaks(final boolean _evaluateForLineBreaks)
    {
        this.evaluateForLineBreaks = _evaluateForLineBreaks;
    }

    /**
     * Gets the row height by analyzing its content.
     *
     * @param _width the width
     * @param _data the data
     * @param _alignType the align type
     * @return the row height
     */
    public int evaluateRowHeight(final int _width, final String _data, final AlignType _alignType)
    {
        final List<String> alignedStrings = align(_width, _data.isEmpty() ? 1 : _data.length(), _alignType, _data);
        int rowHeight = 0;
        for (final String line : alignedStrings) {
            if (line.trim().length() > 0) {
                rowHeight++;
            }
        }
        return Math.max(1, rowHeight);
    }

    /**
     * Aligns the given text according to requested alignment and returns the
     * list of strings.
     *
     * @param _width width of the cell. Cannot be less than 0
     * @param _height height of the cell. Cannot be less than 0
     * @param _align alignment mode.
     * @param _data string data to be aligned. Can be null and if so, assumed
     *            empty.
     *
     * @return returns the ArrayList of Strings, corresponding to aligned lines.
     */
    public List<String> align(final int _width, final int _height, final AlignType _align, final String _data)
    {
        return align(_width, _height, _align, _data, " ");
    }

    /**
     * Align.
     *
     * @param _width the width
     * @param _height the height
     * @param _align the align
     * @param _data the data
     * @param _filler the filler
     * @return the list< string>
     */
    public List<String> align(final int _width, final int _height, final AlignType _align, final String _data,
                              final String _filler)
    {
        Util.checkForNotNull(_align, "align");

        if (_height <= 0 || _width <= 0) {
            throw new IllegalArgumentException("Height or width cannot be less than or equal to zero.");
        }
        String data;
        if (_data == null) {
            data = "";
        } else {
            data = _data;
        }

        final int totalChars = _width * _height;
        if (data.length() > totalChars) {
            throw new IllegalArgumentException("Data given (" + data.length() + " chars) is bigger than cell size of "
                            + totalChars + " chars (width " + _width + " x height " + _height + ")");
        }

        final boolean lineBreaks = isEvaluateForLineBreaks() && _data.contains("\n");

        // If number of words are larger than height, compact to at least
        // height.
        // Compacting happens starting at top, middle or bottom as requested
        final List<String> compacted = new ArrayList<>();

        // If the data length is less than column width and does not contain
        // linebreaks,
        // then there is nothing to compact.
        // Issue# 1
        if (data.length() <= _width && !lineBreaks) {
            switch (_align) {
                case TOP_CENTER:
                case TOP_LEFT:
                case TOP_RIGHT:
                    compacted.add(data);
                    for (int i = 0; i < _height - 1; i++) {
                        compacted.add("");
                    }
                    break;

                case MIDDLE_CENTER:
                case MIDDLE_LEFT:
                case MIDDLE_RIGHT:
                    int midwayIndex = (int) Math.ceil((float) _height / 2) - 1;
                    if (midwayIndex >= _height) {
                        midwayIndex--;
                    }
                    for (int i = 0; i < midwayIndex; i++) {
                        compacted.add("");
                    }
                    compacted.add(data);
                    for (int i = midwayIndex + 1; i < _height; i++) {
                        compacted.add("");
                    }
                    break;

                case BOTTOM_CENTER:
                case BOTTOM_LEFT:
                case BOTTOM_RIGHT:
                    for (int i = 0; i < _height - 1; i++) {
                        compacted.add("");
                    }
                    compacted.add(data);
                    break;
            }
        } else {
            // Split at the word boundary
            int[] grps = new int[0];
            final String[] words;
            if (lineBreaks) {
                String[] wordsTmp = new String[0];
                final String[] wrdTmp = data.split("\n");
                int i = 0;
                for (final String wrd : wrdTmp) {
                    final String[] splitArr = wrd.split("\\s");
                    final int[] grpTmp = new int[splitArr.length];
                    Arrays.fill(grpTmp, i);
                    grps = ArrayUtils.addAll(grps, grpTmp);
                    wordsTmp = ArrayUtils.addAll(wordsTmp, splitArr);
                    i++;
                }
                words = wordsTmp;
            } else {
                words = data.split("\\s");
                grps = new int[words.length];
                Arrays.fill(grps, 0);
            }
            // Check if any word is bigger than the width. If so, split into
            // multiple words.
            int[] grpsFinal = new int[0];
            final List<String> wordsFinal = new ArrayList<>();
            int idx = 0;
            for (final String word : words) {
                if (word.trim().length() >= _width) {
                    final List<String> splitted = splitWord(word, _width);
                    wordsFinal.addAll(splitted);
                    final int[] grpTmp = new int[splitted.size()];
                    Arrays.fill(grpTmp, grps[idx]);
                    grpsFinal = ArrayUtils.addAll(grpsFinal, grpTmp);
                } else {
                    wordsFinal.add(word.trim());
                    grpsFinal = ArrayUtils.addAll(grpsFinal, grps[idx]);
                }
                idx++;
            }

            StringBuilder sb = new StringBuilder();
            int numerOfFillers = 0;

            switch (_align) {
                case TOP_LEFT:
                case TOP_CENTER:
                case TOP_RIGHT:
                    int current1 = grpsFinal[grpsFinal.length - 1];
                    for (int i = 0; i < wordsFinal.size(); i++) {
                        // See if this word could be joined with previous string
                        // and still fits
                        // in the width
                        if ((sb.length() == 0 ? 0 : sb.length() + 1) + wordsFinal.get(i).length() <= _width
                                        && (!lineBreaks || lineBreaks && grpsFinal[i] == current1)) {
                            if (sb.length() > 0) {
                                sb.append(" ");
                            }
                            sb.append(wordsFinal.get(i));
                        } else {
                            compacted.add(sb.toString());
                            sb = new StringBuilder();
                            sb.append(wordsFinal.get(i));
                        }
                        current1 = grpsFinal[i];
                    }
                    if (sb.length() > 0) {
                        compacted.add(sb.toString());
                    }

                    // We may need to add filler lines at the end of the list.
                    numerOfFillers = _height - compacted.size();
                    for (int i = 0; i < numerOfFillers; i++) {
                        compacted.add("");
                    }
                    break;

                case MIDDLE_LEFT:
                case MIDDLE_CENTER:
                case MIDDLE_RIGHT:

                    // Compact mid way towards beginning
                    int midwayIndex = (int) Math.ceil((float) wordsFinal.size() / 2);
                    if (midwayIndex >= wordsFinal.size()) {
                        midwayIndex--;
                    }
                    int current2 = grpsFinal[grpsFinal.length - 1];
                    ;
                    for (int i = midwayIndex; i >= 0; i--) {
                        // See if this word could be joined with previous string
                        // and still fits
                        // in the widths
                        if (sb.length() + wordsFinal.get(i).length() <= _width - 1 && (!lineBreaks || lineBreaks
                                        && grpsFinal[i] == current2)) {
                            if (sb.length() > 0) {
                                sb.insert(0, " ");
                            }
                            sb.insert(0, wordsFinal.get(i));
                        } else {
                            compacted.add(0, sb.toString());
                            sb = new StringBuilder();
                            sb.insert(0, wordsFinal.get(i));
                        }
                        current2 = grpsFinal[i];
                    }
                    if (sb.length() > 0) {
                        compacted.add(0, sb.toString());
                    }

                    sb = new StringBuilder();
                    // Compact mid way towards beginning
                    for (int i = midwayIndex + 1; i < wordsFinal.size(); i++) {
                        // See if this word could be joined with previous string
                        // and still fits
                        // in the width
                        if (sb.length() + wordsFinal.get(i).length() <= _width) {
                            if (sb.length() > 0) {
                                sb.append(" ");
                            }
                            sb.append(wordsFinal.get(i));
                        } else {
                            compacted.add(sb.toString());
                            sb = new StringBuilder();
                            sb.append(wordsFinal.get(i));
                        }
                    }
                    if (sb.length() > 0) {
                        compacted.add(sb.toString());
                    }

                    // We may need to add filler lines at beginning and as well
                    // at the end.
                    numerOfFillers = Math.max(0, _height - compacted.size()) / 2;
                    for (int i = 0; i < numerOfFillers; i++) {
                        compacted.add(0, "");
                    }

                    numerOfFillers = _height - compacted.size();
                    for (int i = 0; i < numerOfFillers; i++) {
                        compacted.add("");
                    }
                    break;

                case BOTTOM_LEFT:
                case BOTTOM_CENTER:
                case BOTTOM_RIGHT:
                    int current3 = grpsFinal[grpsFinal.length - 1];
                    ;
                    for (int i = wordsFinal.size() - 1; i >= 0; i--) {
                        // See if this word could be joined with previous string
                        // and still fits
                        // in the widths
                        if (sb.length() + wordsFinal.get(i).length() <= _width - 1 && (!lineBreaks || lineBreaks
                                        && grpsFinal[i] == current3)) {
                            if (sb.length() > 0) {
                                sb.insert(0, " ");
                            }
                            sb.insert(0, wordsFinal.get(i));
                        } else {
                            compacted.add(0, sb.toString());
                            sb = new StringBuilder();
                            sb.insert(0, wordsFinal.get(i));
                        }
                        current3 = grpsFinal[i];
                    }
                    if (sb.length() > 0) {
                        compacted.add(0, sb.toString());
                    }

                    numerOfFillers = _height - compacted.size();
                    for (int i = 0; i < numerOfFillers; i++) {
                        compacted.add(0, "");
                    }

                    break;
            }
        }

        final List<String> aligned = new ArrayList<>();

        // Align Horizontal
        for (int i = 0; i < compacted.size(); i++) {
            int prefixCount = 0;
            int suffixCount = 0;
            String tempData = compacted.get(i);
            if (tempData == null) {
                tempData = "";
            }

            switch (_align) {
                case TOP_LEFT:
                case MIDDLE_LEFT:
                case BOTTOM_LEFT:
                    suffixCount = _width - tempData.length();
                    break;

                case TOP_CENTER:
                case MIDDLE_CENTER:
                case BOTTOM_CENTER:
                    prefixCount = (_width - tempData.length()) / 2;
                    suffixCount = _width - prefixCount - tempData.length();
                    break;

                case TOP_RIGHT:
                case MIDDLE_RIGHT:
                case BOTTOM_RIGHT:
                    prefixCount = _width - tempData.length();
                    break;
            }
            aligned.add(Util.createSpacer(prefixCount) + tempData + Util.createSpacer(suffixCount));
        }
        return aligned;
    }

    /**
     * Substring.
     *
     * @param _data the data
     * @param _startIndex the start index
     * @param _endIndex the end index
     * @return the string
     */
    private String substring(final String _data, int _startIndex, int _endIndex)
    {
        if (_startIndex < 0) {
            _startIndex = 0;
        }

        if (_endIndex > _data.length()) {
            _endIndex = _data.length();
        }

        return _data.substring(_startIndex, _endIndex);
    }

    /**
     * Split word.
     *
     * @param _word the word
     * @param _width the width
     * @return the list< string>
     */
    private List<String> splitWord(final String _word, final int _width)
    {
        final List<String> words = new ArrayList<>();
        int startIndex = 0;
        while (startIndex < _word.length()) {
            words.add(substring(_word, startIndex, startIndex + _width).trim());
            startIndex += _width;
        }
        return words;
    }
}
