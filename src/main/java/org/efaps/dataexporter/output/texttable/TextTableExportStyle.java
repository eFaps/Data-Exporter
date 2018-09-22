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
package org.efaps.dataexporter.output.texttable;

/**
 * Class to configure the text table style. This class offers extensive set of
 * properties to configure
 * every aspect of text table. There are many pre-defined styles which you can
 * use or customize from scratch
 * or over existing style to your needs. Note that pre-defined styles are static
 * instnaces. So if you modify,
 * they would retain the changes till JVM restart.
 * <p>
 * Here are the available styles and their names.
 *
 * <h2>CLASSIC</h2>
 *
 * <pre>
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 * |Line |    Date Purchased     | Item No  |   Item Name   | Shipped? | Quantity |Unit Price|  Price   |
 * | No  |                       |          |               |          |          |          |          |
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 * |    1|2011/04/09 11:00:43 PM |         1|Laptop         |No        |         1|   $799.78|   $799.78|
 * |    2|2011/04/07 07:13:19 AM |         2|Mouse          |Yes       |         2|    $49.30|    $98.60|
 * |    3|2011/04/07 06:39:17 AM |         3|Keyboard       |No        |         5|    $75.00|   $375.00|
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 * </pre>
 *
 * <h2>CLASSIC_SIMPLE</h2>
 *
 * <pre>
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 * |Line |    Date Purchased     | Item No  |   Item Name   | Shipped? | Quantity |Unit Price|  Price   |
 * | No  |                       |          |               |          |          |          |          |
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 * |    1|2011/04/09 11:00:43 PM |         1|Laptop         |No        |         1|   $799.78|   $799.78|
 * |    2|2011/04/07 07:13:19 AM |         2|Mouse          |Yes       |         2|    $49.30|    $98.60|
 * |    3|2011/04/07 06:39:17 AM |         3|Keyboard       |No        |         5|    $75.00|   $375.00|
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 * </pre>
 *
 * <h2>CLASSIC_NO_DIVIDER_NO_ROW</h2>
 *
 * <pre>
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 *  Line      Date Purchased       Item No      Item Name     Shipped?   Quantity  Unit Price   Price
 *   No
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 *      1 2011/04/09 11:00:43 PM           1 Laptop          No                  1    $799.78    $799.78
 *      2 2011/04/07 07:13:19 AM           2 Mouse           Yes                 2     $49.30     $98.60
 *      3 2011/04/07 06:39:17 AM           3 Keyboard        No                  5     $75.00    $375.00
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 * </pre>
 *
 * <h2>CLASSIC_NO_DIVIDER</h2>
 *
 * <pre>
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 *  Line      Date Purchased       Item No      Item Name     Shipped?   Quantity  Unit Price   Price
 *   No
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 *      1 2011/04/09 11:00:43 PM           1 Laptop          No                  1    $799.78    $799.78
 *      2 2011/04/07 07:13:19 AM           2 Mouse           Yes                 2     $49.30     $98.60
 *      3 2011/04/07 06:39:17 AM           3 Keyboard        No                  5     $75.00    $375.00
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 * </pre>
 *
 * <h2>HEAVY</h2>
 *
 * <pre>
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 * |Line |    Date Purchased     | Item No  |   Item Name   | Shipped? | Quantity |Unit Price|  Price   |
 * | No  |                       |          |               |          |          |          |          |
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 * |    1|2011/04/09 11:00:43 PM |         1|Laptop         |No        |         1|   $799.78|   $799.78|
 * |    2|2011/04/07 07:13:19 AM |         2|Mouse          |Yes       |         2|    $49.30|    $98.60|
 * |    3|2011/04/07 06:39:17 AM |         3|Keyboard       |No        |         5|    $75.00|   $375.00|
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 * </pre>
 *
 * <h2>DOUBLE_HEAVY</h2>
 *
 * <pre>
 * ++=====++=======================++==========++===============++==========++==========++==========++==========++
 * ||Line ||    Date Purchased     || Item No  ||   Item Name   || Shipped? || Quantity ||Unit Price||  Price   ||
 * || No  ||                       ||          ||               ||          ||          ||          ||          ||
 * ++=====++=======================++==========++===============++==========++==========++==========++==========++
 * ||    1||2011/04/09 11:00:43 PM ||         1||Laptop         ||No        ||         1||   $799.78||   $799.78||
 * ||    2||2011/04/07 07:13:19 AM ||         2||Mouse          ||Yes       ||         2||    $49.30||    $98.60||
 * ||    3||2011/04/07 06:39:17 AM ||         3||Keyboard       ||No        ||         5||    $75.00||   $375.00||
 * ++=====++=======================++==========++===============++==========++==========++==========++==========++
 * </pre>
 *
 * <h2>OO</h2>
 *
 * <pre>
 * O=====O=======================O==========O===============O==========O==========O==========O==========O
 * |Line |    Date Purchased     | Item No  |   Item Name   | Shipped? | Quantity |Unit Price|  Price   |
 * | No  |                       |          |               |          |          |          |          |
 * O=====O=======================O==========O===============O==========O==========O==========O==========O
 * |    1|2011/04/09 11:00:43 PM |         1|Laptop         |No        |         1|   $799.78|   $799.78|
 * |    2|2011/04/07 07:13:19 AM |         2|Mouse          |Yes       |         2|    $49.30|    $98.60|
 * |    3|2011/04/07 06:39:17 AM |         3|Keyboard       |No        |         5|    $75.00|   $375.00|
 * O=====O=======================O==========O===============O==========O==========O==========O==========O
 * </pre>
 *
 * <h2>BIG_OO</h2>
 *
 * <pre>
 * O=====O=======================O==========O===============O==========O==========O==========O==========O
 * |Line |    Date Purchased     | Item No  |   Item Name   | Shipped? | Quantity |Unit Price|  Price   |
 * | No  |                       |          |               |          |          |          |          |
 * O=====O=======================O==========O===============O==========O==========O==========O==========O
 * |    1|2011/04/09 11:00:43 PM |         1|Laptop         |No        |         1|   $799.78|   $799.78|
 * |    2|2011/04/07 07:13:19 AM |         2|Mouse          |Yes       |         2|    $49.30|    $98.60|
 * |    3|2011/04/07 06:39:17 AM |         3|Keyboard       |No        |         5|    $75.00|   $375.00|
 * O=====O=======================O==========O===============O==========O==========O==========O==========O
 * </pre>
 *
 * <h2>ZERO</h2>
 *
 * <pre>
 * 0=====0=======================0==========0===============0==========0==========0==========0==========0
 * |Line |    Date Purchased     | Item No  |   Item Name   | Shipped? | Quantity |Unit Price|  Price   |
 * | No  |                       |          |               |          |          |          |          |
 * 0=====0=======================0==========0===============0==========0==========0==========0==========0
 * |    1|2011/04/09 11:00:43 PM |         1|Laptop         |No        |         1|   $799.78|   $799.78|
 * |    2|2011/04/07 07:13:19 AM |         2|Mouse          |Yes       |         2|    $49.30|    $98.60|
 * |    3|2011/04/07 06:39:17 AM |         3|Keyboard       |No        |         5|    $75.00|   $375.00|
 * 0=====0=======================0==========0===============0==========0==========0==========0==========0
 * </pre>
 *
 * <h2>WEAVY</h2>
 *
 * <pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * |Line |    Date Purchased     | Item No  |   Item Name   | Shipped? | Quantity |Unit Price|  Price   |
 * | No  |                       |          |               |          |          |          |          |
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * |    1|2011/04/09 11:00:43 PM |         1|Laptop         |No        |         1|   $799.78|   $799.78|
 * |    2|2011/04/07 07:13:19 AM |         2|Mouse          |Yes       |         2|    $49.30|    $98.60|
 * |    3|2011/04/07 06:39:17 AM |         3|Keyboard       |No        |         5|    $75.00|   $375.00|
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * </pre>
 *
 * <h2>WEAVY_SIMPLE</h2>
 *
 * <pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * |Line |    Date Purchased     | Item No  |   Item Name   | Shipped? | Quantity |Unit Price|  Price   |
 * | No  |                       |          |               |          |          |          |          |
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * |    1|2011/04/09 11:00:43 PM |         1|Laptop         |No        |         1|   $799.78|   $799.78|
 * |    2|2011/04/07 07:13:19 AM |         2|Mouse          |Yes       |         2|    $49.30|    $98.60|
 * |    3|2011/04/07 06:39:17 AM |         3|Keyboard       |No        |         5|    $75.00|   $375.00|
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * </pre>
 *
 * <h2>DOTS</h2>
 *
 * <pre>
 * ......................................................................................................
 * |Line |    Date Purchased     | Item No  |   Item Name   | Shipped? | Quantity |Unit Price|  Price   |
 * | No  |                       |          |               |          |          |          |          |
 * ......................................................................................................
 * |    1|2011/04/09 11:00:43 PM |         1|Laptop         |No        |         1|   $799.78|   $799.78|
 * |    2|2011/04/07 07:13:19 AM |         2|Mouse          |Yes       |         2|    $49.30|    $98.60|
 * |    3|2011/04/07 06:39:17 AM |         3|Keyboard       |No        |         5|    $75.00|   $375.00|
 * ......................................................................................................
 * </pre>
 *
 * <h2>DOTS_SIMPLE</h2>
 *
 * <pre>
 * ......................................................................................................
 * |Line |    Date Purchased     | Item No  |   Item Name   | Shipped? | Quantity |Unit Price|  Price   |
 * | No  |                       |          |               |          |          |          |          |
 * ......................................................................................................
 * |    1|2011/04/09 11:00:43 PM |         1|Laptop         |No        |         1|   $799.78|   $799.78|
 * |    2|2011/04/07 07:13:19 AM |         2|Mouse          |Yes       |         2|    $49.30|    $98.60|
 * |    3|2011/04/07 06:39:17 AM |         3|Keyboard       |No        |         5|    $75.00|   $375.00|
 * ......................................................................................................
 * </pre>
 *
 * <h2>QUOTED</h2>
 *
 * <pre>
 * &quot;=====&quot;=======================&quot;==========&quot;===============&quot;==========&quot;==========&quot;==========&quot;==========&quot;
 * |Line |    Date Purchased     | Item No  |   Item Name   | Shipped? | Quantity |Unit Price|  Price   |
 * | No  |                       |          |               |          |          |          |          |
 * &quot;=====&quot;=======================&quot;==========&quot;===============&quot;==========&quot;==========&quot;==========&quot;==========&quot;
 * |    1|2011/04/09 11:00:43 PM |         1|Laptop         |No        |         1|   $799.78|   $799.78|
 * |    2|2011/04/07 07:13:19 AM |         2|Mouse          |Yes       |         2|    $49.30|    $98.60|
 * |    3|2011/04/07 06:39:17 AM |         3|Keyboard       |No        |         5|    $75.00|   $375.00|
 * &quot;=====&quot;=======================&quot;==========&quot;===============&quot;==========&quot;==========&quot;==========&quot;==========&quot;
 * </pre>
 *
 * <h2>QUOTED_SIMPLE</h2>
 *
 * <pre>
 * &quot;=====&quot;=======================&quot;==========&quot;===============&quot;==========&quot;==========&quot;==========&quot;==========&quot;
 * |Line |    Date Purchased     | Item No  |   Item Name   | Shipped? | Quantity |Unit Price|  Price   |
 * | No  |                       |          |               |          |          |          |          |
 * &quot;=====&quot;=======================&quot;==========&quot;===============&quot;==========&quot;==========&quot;==========&quot;==========&quot;
 * |    1|2011/04/09 11:00:43 PM |         1|Laptop         |No        |         1|   $799.78|   $799.78|
 * |    2|2011/04/07 07:13:19 AM |         2|Mouse          |Yes       |         2|    $49.30|    $98.60|
 * |    3|2011/04/07 06:39:17 AM |         3|Keyboard       |No        |         5|    $75.00|   $375.00|
 * &quot;=====&quot;=======================&quot;==========&quot;===============&quot;==========&quot;==========&quot;==========&quot;==========&quot;
 * </pre>
 *
 * <h2>ANGLES</h2>
 *
 * <pre>
 * &lt;-&gt;=====&lt;-&gt;=======================&lt;-&gt;==========&lt;-&gt;===============&lt;-&gt;==========&lt;-&gt;==========&lt;-&gt;==========&lt;-&gt;==========&lt;-&gt;
 *  | Line  |     Date Purchased      |  Item No   |    Item Name    |  Shipped?  |  Quantity  | Unit Price |   Price    |
 *  |  No   |                         |            |                 |            |            |            |            |
 * &lt;-&gt;=====&lt;-&gt;=======================&lt;-&gt;==========&lt;-&gt;===============&lt;-&gt;==========&lt;-&gt;==========&lt;-&gt;==========&lt;-&gt;==========&lt;-&gt;
 *  |     1 | 2011/04/09 11:00:43 PM  |          1 | Laptop          | No         |          1 |    $799.78 |    $799.78 |
 *  |     2 | 2011/04/07 07:13:19 AM  |          2 | Mouse           | Yes        |          2 |     $49.30 |     $98.60 |
 *  |     3 | 2011/04/07 06:39:17 AM  |          3 | Keyboard        | No         |          5 |     $75.00 |    $375.00 |
 * &lt;-&gt;=====&lt;-&gt;=======================&lt;-&gt;==========&lt;-&gt;===============&lt;-&gt;==========&lt;-&gt;==========&lt;-&gt;==========&lt;-&gt;==========&lt;-&gt;
 * </pre>
 *
 * <h2>TEST</h2>
 *
 * <pre>
 * #=====#=======================#==========#===============#==========#==========#==========#==========#
 * |Line |    Date Purchased     | Item No  |   Item Name   | Shipped? | Quantity |Unit Price|  Price   |
 * | No  |                       |          |               |          |          |          |          |
 * #=====#=======================#==========#===============#==========#==========#==========#==========#
 * |    1|2011/04/09 11:00:43 PM |         1|Laptop         |No        |         1|   $799.78|   $799.78|
 * |    2|2011/04/07 07:13:19 AM |         2|Mouse          |Yes       |         2|    $49.30|    $98.60|
 * |    3|2011/04/07 06:39:17 AM |         3|Keyboard       |No        |         5|    $75.00|   $375.00|
 * #=====#=======================#==========#===============#==========#==========#==========#==========#
 * </pre>
 *
 * @author Santhosh Kumar
 */
public class TextTableExportStyle
{

    public static TextTableExportStyle CLASSIC = new TextTableExportStyle("+", "=", "-", "|");
    public static TextTableExportStyle CLASSIC_SIMPLE = new TextTableExportStyle("+", "", "=", "", "|", "|");
    public static TextTableExportStyle CLASSIC_NO_DIVIDER_NO_ROW = new TextTableExportStyle("+", "", "=", "", " ", " ");
    public static TextTableExportStyle CLASSIC_NO_DIVIDER = new TextTableExportStyle("+", "+", "=", "-", " ", " ");
    public static TextTableExportStyle HEAVY = new TextTableExportStyle("+", "+", "=", "=", "|", "|");
    public static TextTableExportStyle DOUBLE_HEAVY = new TextTableExportStyle("++", "++", "=", "=", "||", "||");
    public static TextTableExportStyle OO = new TextTableExportStyle("O", "o", "=", "-", "|", "|");
    public static TextTableExportStyle BIG_OO = new TextTableExportStyle("O", "O", "=", "-", "|", "|");
    public static TextTableExportStyle ZERO = new TextTableExportStyle("0", "0", "=", "-", "|", "|");
    public static TextTableExportStyle WEAVY = new TextTableExportStyle("~", "~", "~", "~", "|", "|");
    public static TextTableExportStyle WEAVY_SIMPLE = new TextTableExportStyle("~", "", "~", "", "|", "|");
    public static TextTableExportStyle DOTS = new TextTableExportStyle(".", ".", ".", ".", "|", "|");
    public static TextTableExportStyle DOTS_SIMPLE = new TextTableExportStyle(".", "", ".", "", "|", "|");
    public static TextTableExportStyle QUOTED = new TextTableExportStyle("\"", "'", "=", "-", "|", "|");
    public static TextTableExportStyle QUOTED_SIMPLE = new TextTableExportStyle("\"", "", "=", "", "|", "|");
    public static TextTableExportStyle ANGLES = new TextTableExportStyle("<->", "", "=", "", " | ", " | ");
    public static TextTableExportStyle TEST = new TextTableExportStyle("#", "", "=", "", "|", "|");

    private String topLeftIntersection = null;
    private String topLeftRightIntersection = null;
    private String topCenterIntersection = null;
    private String topRightLeftIntersection = null;
    private String topRightIntersection = null;

    private String topDownLeftIntersection = null;
    private String topDownLeftRightIntersection = null;
    private String topDownCenterIntersection = null;
    private String topDownRightLeftIntersection = null;
    private String topDownRightIntersection = null;

    private String centerLeftIntersection = null;
    private String centerLeftRightIntersection = null;
    private String centerCenterIntersection = null;
    private String centerRightLeftIntersection = null;
    private String centerRightIntersection = null;

    private String bottomUpLeftIntersection = null;
    private String bottomUpLeftRightIntersection = null;
    private String bottomUpCenterIntersection = null;
    private String bottomUpRightLeftIntersection = null;
    private String bottomUpRightIntersection = null;

    private String bottomLeftIntersection = null;
    private String bottomLeftRightIntersection = null;
    private String bottomCenterIntersection = null;
    private String bottomRightLeftIntersection = null;
    private String bottomRightIntersection = null;

    private String topBorder = null;
    private String topDownBorder = null;
    private String centerBorder = null;
    private String bottomUpBorder = null;
    private String bottomBorder = null;

    private String topLeftDivider = null;
    private String topLeftRightDivider = null;
    private String topCenterDivider = null;
    private String topRightLeftDivider = null;
    private String topRightDivider = null;

    private String centerLeftDivider = null;
    private String centerLeftRightDivider = null;
    private String centerCenterDivider = null;
    private String centerRightLeftDivider = null;
    private String centerRightDivider = null;

    private String bottomLeftDivider = null;
    private String bottomLeftRightDivider = null;
    private String bottomCenterDivider = null;
    private String bottomRightLeftDivider = null;
    private String bottomRightDivider = null;

    public TextTableExportStyle(final String headerFooterIntersection,
                                final String rowIntersection,
                                final String headerFooterBorder,
                                final String rowBorder,
                                final String headerFooterDividers,
                                final String rowDividers)
    {
        this(headerFooterIntersection, headerFooterIntersection, headerFooterIntersection, headerFooterIntersection,
                        headerFooterIntersection, headerFooterIntersection, headerFooterIntersection,
                        headerFooterIntersection, headerFooterIntersection, headerFooterIntersection, rowIntersection,
                        rowIntersection, rowIntersection, rowIntersection, rowIntersection, headerFooterIntersection,
                        headerFooterIntersection, headerFooterIntersection, headerFooterIntersection,
                        headerFooterIntersection, headerFooterIntersection, headerFooterIntersection,
                        headerFooterIntersection, headerFooterIntersection, headerFooterIntersection,
                        headerFooterBorder, headerFooterBorder, rowBorder, headerFooterBorder, headerFooterBorder,
                        headerFooterDividers, headerFooterDividers, headerFooterDividers, headerFooterDividers,
                        headerFooterDividers, rowDividers, rowDividers, rowDividers, rowDividers, rowDividers,
                        headerFooterDividers, headerFooterDividers, headerFooterDividers, headerFooterDividers,
                        headerFooterDividers);
    }

    public TextTableExportStyle(final String allIntersections,
                                final String headerFooterBorder,
                                final String rowBorder,
                                final String allCellDividers)
    {
        this(allIntersections, allIntersections, allIntersections, allIntersections, allIntersections, allIntersections,
                        allIntersections, allIntersections, allIntersections, allIntersections, allIntersections,
                        allIntersections, allIntersections, allIntersections, allIntersections, allIntersections,
                        allIntersections, allIntersections, allIntersections, allIntersections, allIntersections,
                        allIntersections, allIntersections, allIntersections, allIntersections, headerFooterBorder,
                        headerFooterBorder, rowBorder, headerFooterBorder, headerFooterBorder, allCellDividers,
                        allCellDividers, allCellDividers, allCellDividers, allCellDividers, allCellDividers,
                        allCellDividers, allCellDividers, allCellDividers, allCellDividers, allCellDividers,
                        allCellDividers, allCellDividers, allCellDividers, allCellDividers);
    }

    public TextTableExportStyle(final String topLeftIntersection,
                                final String topLeftRightIntersection,
                                final String topCenterIntersection,
                                final String topRightLeftIntersection,
                                final String topRightIntersection,
                                final String topDownLeftIntersection,
                                final String topDownLeftRightIntersection,
                                final String topDownCenterIntersection,
                                final String topDownRightLeftIntersection,
                                final String topDownRightIntersection,
                                final String centerLeftIntersection,
                                final String centerLeftRightIntersection,
                                final String centerCenterIntersection,
                                final String centerRightLeftIntersection,
                                final String centerRightIntersection,
                                final String bottomUpLeftIntersection,
                                final String bottomUpLeftRightIntersection,
                                final String bottomUpCenterIntersection,
                                final String bottomUpRightLeftIntersection,
                                final String bottomUpRightIntersection,
                                final String bottomLeftIntersection,
                                final String bottomLeftRightIntersection,
                                final String bottomCenterIntersection,
                                final String bottomRightLeftIntersection,
                                final String bottomRightIntersection,
                                final String topBorder,
                                final String topDownBorder,
                                final String centerBorder,
                                final String bottomUpBorder,
                                final String bottomBorder,
                                final String topLeftDivider,
                                final String topLeftRightDivider,
                                final String topCenterDivider,
                                final String topRightLeftDivider,
                                final String topRightDivider,
                                final String centerLeftDivider,
                                final String centerLeftRightDivider,
                                final String centerCenterDivider,
                                final String centerRightLeftDivider,
                                final String centerRightDivider,
                                final String bottomLeftDivider,
                                final String bottomLeftRightDivider,
                                final String bottomCenterDivider,
                                final String bottomRightLeftDivider,
                                final String bottomRightDivider)
    {
        super();
        this.topLeftIntersection = topLeftIntersection;
        this.topLeftRightIntersection = topLeftRightIntersection;
        this.topCenterIntersection = topCenterIntersection;
        this.topRightLeftIntersection = topRightLeftIntersection;
        this.topRightIntersection = topRightIntersection;
        this.topDownLeftIntersection = topDownLeftIntersection;
        this.topDownLeftRightIntersection = topDownLeftRightIntersection;
        this.topDownCenterIntersection = topDownCenterIntersection;
        this.topDownRightLeftIntersection = topDownRightLeftIntersection;
        this.topDownRightIntersection = topDownRightIntersection;
        this.centerLeftIntersection = centerLeftIntersection;
        this.centerLeftRightIntersection = centerLeftRightIntersection;
        this.centerCenterIntersection = centerCenterIntersection;
        this.centerRightLeftIntersection = centerRightLeftIntersection;
        this.centerRightIntersection = centerRightIntersection;
        this.bottomUpLeftIntersection = bottomUpLeftIntersection;
        this.bottomUpLeftRightIntersection = bottomUpLeftRightIntersection;
        this.bottomUpCenterIntersection = bottomUpCenterIntersection;
        this.bottomUpRightLeftIntersection = bottomUpRightLeftIntersection;
        this.bottomUpRightIntersection = bottomUpRightIntersection;
        this.bottomLeftIntersection = bottomLeftIntersection;
        this.bottomLeftRightIntersection = bottomLeftRightIntersection;
        this.bottomCenterIntersection = bottomCenterIntersection;
        this.bottomRightLeftIntersection = bottomRightLeftIntersection;
        this.bottomRightIntersection = bottomRightIntersection;
        this.topBorder = topBorder;
        this.topDownBorder = topDownBorder;
        this.centerBorder = centerBorder;
        this.bottomUpBorder = bottomUpBorder;
        this.bottomBorder = bottomBorder;
        this.topLeftDivider = topLeftDivider;
        this.topLeftRightDivider = topLeftRightDivider;
        this.topCenterDivider = topCenterDivider;
        this.topRightLeftDivider = topRightLeftDivider;
        this.topRightDivider = topRightDivider;
        this.centerLeftDivider = centerLeftDivider;
        this.centerLeftRightDivider = centerLeftRightDivider;
        this.centerCenterDivider = centerCenterDivider;
        this.centerRightLeftDivider = centerRightLeftDivider;
        this.centerRightDivider = centerRightDivider;
        this.bottomLeftDivider = bottomLeftDivider;
        this.bottomLeftRightDivider = bottomLeftRightDivider;
        this.bottomCenterDivider = bottomCenterDivider;
        this.bottomRightLeftDivider = bottomRightLeftDivider;
        this.bottomRightDivider = bottomRightDivider;
    }

    public String getTopLeftIntersection()
    {
        return this.topLeftIntersection;
    }

    public void setTopLeftIntersection(final String topLeftIntersection)
    {
        this.topLeftIntersection = topLeftIntersection;
    }

    public String getTopLeftRightIntersection()
    {
        return this.topLeftRightIntersection;
    }

    public void setTopLeftRightIntersection(final String topLeftRightIntersection)
    {
        this.topLeftRightIntersection = topLeftRightIntersection;
    }

    public String getTopCenterIntersection()
    {
        return this.topCenterIntersection;
    }

    public void setTopCenterIntersection(final String topCenterIntersection)
    {
        this.topCenterIntersection = topCenterIntersection;
    }

    public String getTopRightLeftIntersection()
    {
        return this.topRightLeftIntersection;
    }

    public void setTopRightLeftIntersection(final String topRightLeftIntersection)
    {
        this.topRightLeftIntersection = topRightLeftIntersection;
    }

    public String getTopRightIntersection()
    {
        return this.topRightIntersection;
    }

    public void setTopRightIntersection(final String topRightIntersection)
    {
        this.topRightIntersection = topRightIntersection;
    }

    public String getTopDownLeftIntersection()
    {
        return this.topDownLeftIntersection;
    }

    public void setTopDownLeftIntersection(final String topDownLeftIntersection)
    {
        this.topDownLeftIntersection = topDownLeftIntersection;
    }

    public String getTopDownLeftRightIntersection()
    {
        return this.topDownLeftRightIntersection;
    }

    public void setTopDownLeftRightIntersection(final String topDownLeftRightIntersection)
    {
        this.topDownLeftRightIntersection = topDownLeftRightIntersection;
    }

    public String getTopDownCenterIntersection()
    {
        return this.topDownCenterIntersection;
    }

    public void setTopDownCenterIntersection(final String topDownCenterIntersection)
    {
        this.topDownCenterIntersection = topDownCenterIntersection;
    }

    public String getTopDownRightLeftIntersection()
    {
        return this.topDownRightLeftIntersection;
    }

    public void setTopDownRightLeftIntersection(final String topDownRightLeftIntersection)
    {
        this.topDownRightLeftIntersection = topDownRightLeftIntersection;
    }

    public String getTopDownRightIntersection()
    {
        return this.topDownRightIntersection;
    }

    public void setTopDownRightIntersection(final String topDownRightIntersection)
    {
        this.topDownRightIntersection = topDownRightIntersection;
    }

    public String getCenterLeftIntersection()
    {
        return this.centerLeftIntersection;
    }

    public void setCenterLeftIntersection(final String centerLeftIntersection)
    {
        this.centerLeftIntersection = centerLeftIntersection;
    }

    public String getCenterLeftRightIntersection()
    {
        return this.centerLeftRightIntersection;
    }

    public void setCenterLeftRightIntersection(final String centerLeftRightIntersection)
    {
        this.centerLeftRightIntersection = centerLeftRightIntersection;
    }

    public String getCenterCenterIntersection()
    {
        return this.centerCenterIntersection;
    }

    public void setCenterCenterIntersection(final String centerCenterIntersection)
    {
        this.centerCenterIntersection = centerCenterIntersection;
    }

    public String getCenterRightLeftIntersection()
    {
        return this.centerRightLeftIntersection;
    }

    public void setCenterRightLeftIntersection(final String centerRightLeftIntersection)
    {
        this.centerRightLeftIntersection = centerRightLeftIntersection;
    }

    public String getCenterRightIntersection()
    {
        return this.centerRightIntersection;
    }

    public void setCenterRightIntersection(final String centerRightIntersection)
    {
        this.centerRightIntersection = centerRightIntersection;
    }

    public String getBottomUpLeftIntersection()
    {
        return this.bottomUpLeftIntersection;
    }

    public void setBottomUpLeftIntersection(final String bottomUpLeftIntersection)
    {
        this.bottomUpLeftIntersection = bottomUpLeftIntersection;
    }

    public String getBottomUpLeftRightIntersection()
    {
        return this.bottomUpLeftRightIntersection;
    }

    public void setBottomUpLeftRightIntersection(final String bottomUpLeftRightIntersection)
    {
        this.bottomUpLeftRightIntersection = bottomUpLeftRightIntersection;
    }

    public String getBottomUpCenterIntersection()
    {
        return this.bottomUpCenterIntersection;
    }

    public void setBottomUpCenterIntersection(final String bottomUpCenterIntersection)
    {
        this.bottomUpCenterIntersection = bottomUpCenterIntersection;
    }

    public String getBottomUpRightLeftIntersection()
    {
        return this.bottomUpRightLeftIntersection;
    }

    public void setBottomUpRightLeftIntersection(final String bottomUpRightLeftIntersection)
    {
        this.bottomUpRightLeftIntersection = bottomUpRightLeftIntersection;
    }

    public String getBottomUpRightIntersection()
    {
        return this.bottomUpRightIntersection;
    }

    public void setBottomUpRightIntersection(final String bottomUpRightIntersection)
    {
        this.bottomUpRightIntersection = bottomUpRightIntersection;
    }

    public String getBottomLeftIntersection()
    {
        return this.bottomLeftIntersection;
    }

    public void setBottomLeftIntersection(final String bottomLeftIntersection)
    {
        this.bottomLeftIntersection = bottomLeftIntersection;
    }

    public String getBottomLeftRightIntersection()
    {
        return this.bottomLeftRightIntersection;
    }

    public void setBottomLeftRightIntersection(final String bottomLeftRightIntersection)
    {
        this.bottomLeftRightIntersection = bottomLeftRightIntersection;
    }

    public String getBottomCenterIntersection()
    {
        return this.bottomCenterIntersection;
    }

    public void setBottomCenterIntersection(final String bottomCenterIntersection)
    {
        this.bottomCenterIntersection = bottomCenterIntersection;
    }

    public String getBottomRightLeftIntersection()
    {
        return this.bottomRightLeftIntersection;
    }

    public void setBottomRightLeftIntersection(final String bottomRightLeftIntersection)
    {
        this.bottomRightLeftIntersection = bottomRightLeftIntersection;
    }

    public String getBottomRightIntersection()
    {
        return this.bottomRightIntersection;
    }

    public void setBottomRightIntersection(final String bottomRightIntersection)
    {
        this.bottomRightIntersection = bottomRightIntersection;
    }

    public String getTopBorder()
    {
        return this.topBorder;
    }

    public void setTopBorder(final String topBorder)
    {
        this.topBorder = topBorder;
    }

    public String getTopDownBorder()
    {
        return this.topDownBorder;
    }

    public void setTopDownBorder(final String topDownBorder)
    {
        this.topDownBorder = topDownBorder;
    }

    public String getCenterBorder()
    {
        return this.centerBorder;
    }

    public void setCenterBorder(final String centerBorder)
    {
        this.centerBorder = centerBorder;
    }

    public String getBottomUpBorder()
    {
        return this.bottomUpBorder;
    }

    public void setBottomUpBorder(final String bottomUpBorder)
    {
        this.bottomUpBorder = bottomUpBorder;
    }

    public String getBottomBorder()
    {
        return this.bottomBorder;
    }

    public void setBottomBorder(final String bottomBorder)
    {
        this.bottomBorder = bottomBorder;
    }

    public String getTopLeftDivider()
    {
        return this.topLeftDivider;
    }

    public void setTopLeftDivider(final String topLeftDivider)
    {
        this.topLeftDivider = topLeftDivider;
    }

    public String getTopLeftRightDivider()
    {
        return this.topLeftRightDivider;
    }

    public void setTopLeftRightDivider(final String topLeftRightDivider)
    {
        this.topLeftRightDivider = topLeftRightDivider;
    }

    public String getTopCenterDivider()
    {
        return this.topCenterDivider;
    }

    public void setTopCenterDivider(final String topCenterDivider)
    {
        this.topCenterDivider = topCenterDivider;
    }

    public String getTopRightLeftDivider()
    {
        return this.topRightLeftDivider;
    }

    public void setTopRightLeftDivider(final String topRightLeftDivider)
    {
        this.topRightLeftDivider = topRightLeftDivider;
    }

    public String getTopRightDivider()
    {
        return this.topRightDivider;
    }

    public void setTopRightDivider(final String topRightDivider)
    {
        this.topRightDivider = topRightDivider;
    }

    public String getCenterLeftDivider()
    {
        return this.centerLeftDivider;
    }

    public void setCenterLeftDivider(final String centerLeftDivider)
    {
        this.centerLeftDivider = centerLeftDivider;
    }

    public String getCenterLeftRightDivider()
    {
        return this.centerLeftRightDivider;
    }

    public void setCenterLeftRightDivider(final String centerLeftRightDivider)
    {
        this.centerLeftRightDivider = centerLeftRightDivider;
    }

    public String getCenterCenterDivider()
    {
        return this.centerCenterDivider;
    }

    public void setCenterCenterDivider(final String centerCenterDivider)
    {
        this.centerCenterDivider = centerCenterDivider;
    }

    public String getCenterRightLeftDivider()
    {
        return this.centerRightLeftDivider;
    }

    public void setCenterRightLeftDivider(final String centerRightLeftDivider)
    {
        this.centerRightLeftDivider = centerRightLeftDivider;
    }

    public String getCenterRightDivider()
    {
        return this.centerRightDivider;
    }

    public void setCenterRightDivider(final String centerRightDivider)
    {
        this.centerRightDivider = centerRightDivider;
    }

    public String getBottomLeftDivider()
    {
        return this.bottomLeftDivider;
    }

    public void setBottomLeftDivider(final String bottomLeftDivider)
    {
        this.bottomLeftDivider = bottomLeftDivider;
    }

    public String getBottomLeftRightDivider()
    {
        return this.bottomLeftRightDivider;
    }

    public void setBottomLeftRightDivider(final String bottomLeftRightDivider)
    {
        this.bottomLeftRightDivider = bottomLeftRightDivider;
    }

    public String getBottomCenterDivider()
    {
        return this.bottomCenterDivider;
    }

    public void setBottomCenterDivider(final String bottomCenterDivider)
    {
        this.bottomCenterDivider = bottomCenterDivider;
    }

    public String getBottomRightLeftDivider()
    {
        return this.bottomRightLeftDivider;
    }

    public void setBottomRightLeftDivider(final String bottomRightLeftDivider)
    {
        this.bottomRightLeftDivider = bottomRightLeftDivider;
    }

    public String getBottomRightDivider()
    {
        return this.bottomRightDivider;
    }

    public void setBottomRightDivider(final String bottomRightDivider)
    {
        this.bottomRightDivider = bottomRightDivider;
    }
}
