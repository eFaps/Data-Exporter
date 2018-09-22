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
package org.efaps.dataexporter.model;

import java.util.List;

import org.efaps.dataexporter.TextAligner;

/**
 * Base class for all other columns. This abstract class also provides some
 * common functionality
 * which subclasses can make use of.
 *
 * @author Santhosh Kumar
 */
public abstract class Column
{

    public static TextAligner aligner = new TextAligner();

    private CellValueGenerator cellValueGenerator = null;
    private String title = null;
    private String title2 = "";
    private String title3 = "";
    private String name = null;
    private int width = 0;
    private AlignType align = null;
    private boolean generatesOwnData = false;
    private boolean nillable = false;

    protected String headerCellCssClass = null;
    protected String headerCellCssId = null;
    protected String headerCellCssStyle = null;
    protected String rowCellCssClass = null;
    protected String rowCellCssId = null;
    protected String rowCellCssStyle = null;

    public Column(final String name)
    {
        this(name, name.length());
    }

    public Column(final String name,
                  final int width)
    {
        this(name, null, width, AlignType.MIDDLE_LEFT);
    }

    public Column(final String name,
                  final int width,
                  final AlignType align)
    {
        this(name, null, width, align);
    }

    public Column(final String name,
                  final String title,
                  final int width,
                  final AlignType align)
    {
        super();
        this.title = title == null ? name : title;
        this.name = name;
        this.width = width;
        this.align = align;
    }

    public CellValueGenerator getCellValueGenerator()
    {
        return this.cellValueGenerator;
    }

    public Column setCellValueGenerator(final CellValueGenerator generator)
    {
        this.cellValueGenerator = generator;
        return this;
    }

    public boolean isGeneratesOwnData()
    {
        return this.generatesOwnData;
    }

    public Column setGeneratesOwnData(final boolean generatesOwnData)
    {
        this.generatesOwnData = generatesOwnData;
        return this;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(final String title)
    {
        this.title = title;
    }

    public String getTitle2()
    {
        return this.title2;
    }

    public void setTitle2(final String title2)
    {
        this.title2 = title2;
    }

    public String getTitle3()
    {
        return this.title3;
    }

    public void setTitle3(final String title3)
    {
        this.title3 = title3;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public int getWidth()
    {
        return this.width;
    }

    public void setWidth(final int width)
    {
        this.width = width;
    }

    public AlignType getAlign()
    {
        return this.align;
    }

    public void setAlign(final AlignType align)
    {
        this.align = align;
    }

    public String getHeaderCellCssClass()
    {
        return this.headerCellCssClass;
    }

    public void setHeaderCellCssClass(final String headerCellCssClass)
    {
        this.headerCellCssClass = headerCellCssClass;
    }

    public String getHeaderCellCssId()
    {
        return this.headerCellCssId;
    }

    public void setHeaderCellCssId(final String headerCellCssId)
    {
        this.headerCellCssId = headerCellCssId;
    }

    public String getHeaderCellCssStyle()
    {
        return this.headerCellCssStyle;
    }

    public void setHeaderCellCssStyle(final String headerCellCssStyle)
    {
        this.headerCellCssStyle = headerCellCssStyle;
    }

    public String getRowCellCssClass()
    {
        return this.rowCellCssClass;
    }

    public void setRowCellCssClass(final String rowCellCssClass)
    {
        this.rowCellCssClass = rowCellCssClass;
    }

    public String getRowCellCssId()
    {
        return this.rowCellCssId;
    }

    public void setRowCellCssId(final String rowCellCssId)
    {
        this.rowCellCssId = rowCellCssId;
    }

    public String getRowCellCssStyle()
    {
        return this.rowCellCssStyle;
    }

    public void setRowCellCssStyle(final String rowCellCssStyle)
    {
        this.rowCellCssStyle = rowCellCssStyle;
    }

    public boolean isNillable()
    {
        return this.nillable;
    }

    public void setNillable(final boolean nillable)
    {
        this.nillable = nillable;
    }

    /**
     * Aligns the given <code>cellData</code> using the details given in
     * <code>cellDetails</code>
     * and alignment override value returned by the call back (if there is one).
     * <p>
     * This method is usually called by the specific column implementation after
     * they have formatted
     * the string.
     *
     * @param cellDetails the object containing the details about this cell
     * @param cellData the string which should be aligned
     *
     * @return the <code>ArrayList</code> containing the Strings split and
     *         aligned as per <code>cellDetails</code>
     */
    public List<String> align(final CellDetails cellDetails, final String cellData)
    {
        return align(cellDetails, cellData, " ");
    }

    public List<String> align(final CellDetails cellDetails, final String cellData, final String filler)
    {

        AlignType alignOverride = cellDetails.getCellAlign();

        if (alignOverride == null) {
            alignOverride = cellDetails.getColumn().getAlign();
        }

        return align(cellDetails.getColumn().getWidth(), cellDetails.getRowHeight(), alignOverride, cellData, filler);
    }

    public static List<String> align(final int width, final int height, final AlignType align, final String value)
    {
        return align(width, height, align, value, " ");
    }

    public static List<String> align(final int width, final int height, final AlignType align, final String value,
                                     final String filler)
    {
        return aligner.align(width, height, align, value, filler);
    }

    /**
     * Method calculates the approximate row height based on the given
     * <code>data</code> length
     * and this column's width. It is only a approximation because once the data
     * is split and aligned
     * some times it could have been rendered in less height than what is
     * returned in this method.
     *
     * @param cellData the formatted string which would get displayed in the
     *            cell.
     *
     * @return the approximation height that is required to display this
     *         cellData in this column
     */
    public int getMaxRowHeight(final String cellData)
    {
        return getMaxRowHeight(getWidth(), cellData);
    }

    public static int getMaxRowHeight(int width, final String value)
    {
        if (width <= 0) {
            width = 1;
        }

        return (int) Math.ceil((float) value.length() / width);
    }

    /**
     * Implementation should calculate the maximum row height they would be
     * needed to render
     * the <code>defaultCellValue</code> given in <code>cellDetails</code>
     * parameter.
     *
     * @param cellDetails the object containing the details about the cell
     *
     * @return the positive integer specifying the minimum row height this cell
     *         needs to render
     *         the cell value.
     */
    public abstract int getMaxRowHeight(CellDetails cellDetails);

    /**
     * Implementation should format the cell value object as appropriate into a
     * string, align
     * the string vertically/horizontally to fit with in the column width and
     * row height. Allowed column
     * width is specified via <code>cellDetails.getColumn().getWidth()</code>.
     * Allowed row height
     * is provided via <code>cellDetails.getRowHeight()</code>
     *
     * @param cellDetails
     *
     * @return List of Strings to be rendered for this column. List should have
     *         exactly
     *         <code>cellDetails.getRowHeight()</code> strings and each of size
     *         <code>cellDetails.getColumn().getWidth()</code>
     */
    public abstract String format(CellDetails cellDetails);
}
