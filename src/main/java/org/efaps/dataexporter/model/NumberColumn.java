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

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.efaps.dataexporter.util.Util;

/**
 * Number column which displays the formatted numbers.
 *
 * @author Santhosh Kumar
 *
 */
public class NumberColumn
    extends Column
{

    private NumberFormat formatter = null;
    private int precision = 2;
    private boolean grouping = true;
    private boolean bracketNegitive = false;

    public NumberColumn(final String name,
                        final String title,
                        final int width,
                        final NumberFormat formatter)
    {
        this(name, title, width, AlignType.MIDDLE_RIGHT, formatter);
    }

    public NumberColumn(final String name,
                        final String title,
                        final int width,
                        final int precision)
    {
        this(name, title, width, AlignType.MIDDLE_RIGHT, precision);
    }

    public NumberColumn(final String name,
                        final int width,
                        final int precision)
    {
        this(name, width, AlignType.MIDDLE_RIGHT, precision);
    }

    public NumberColumn(final String name,
                        final int width,
                        final NumberFormat formatter)
    {
        this(name, null, width, AlignType.MIDDLE_RIGHT, formatter);
    }

    public NumberColumn(final String name,
                        final int width,
                        final AlignType align,
                        final int precision)
    {
        this(name, null, width, align, precision);
    }

    public NumberColumn(final String name,
                        final String title,
                        final int width,
                        final AlignType align,
                        final int precision)
    {
        super(name, title, width, align);
        this.precision = precision;
    }

    public NumberColumn(final String name,
                        final String title,
                        final int width,
                        final AlignType align,
                        final NumberFormat formatter)
    {
        super(name, title, width, align);
        this.formatter = formatter;
    }

    public int getPrecision()
    {
        return this.precision;
    }

    public NumberColumn setPrecision(final int precision)
    {
        this.precision = precision;

        return this;
    }

    public boolean isGrouping()
    {
        return this.grouping;
    }

    public NumberColumn setGrouping(final boolean grouping)
    {
        this.grouping = grouping;

        return this;
    }

    public boolean isBracketNegitive()
    {
        return this.bracketNegitive;
    }

    public NumberColumn setBracketNegitive(final boolean bracketNegitive)
    {
        this.bracketNegitive = bracketNegitive;

        return this;
    }

    @Override
    public int getMaxRowHeight(final CellDetails cellDetails)
    {
        return (int) Math.ceil((float) format(cellDetails.getCellValue()).length() / getWidth());
    }

    @Override
    public String format(final CellDetails cellDetails)
    {
        return format(cellDetails.getCellValue());
    }

    public String format(final Object value)
    {

        if (this.formatter == null) {
            String formatString = "";
            if (isGrouping()) {
                formatString = "#,###,###";
            } else {
                formatString = "0";
            }

            if (isBracketNegitive()) {
                formatString = formatString + ";(#)";
            }

            if (this.precision > 0) {
                this.formatter = new DecimalFormat(formatString + "." + Util.createString("0", this.precision));
            } else {
                this.formatter = new DecimalFormat(formatString);
            }
        }

        String formattedString;

        try {
            formattedString = this.formatter.format(value);
        } catch (final Exception e) {
            throw new RuntimeException("Exception while formatting the value " + value + " of type " + value.getClass()
                            .getName() + " as number for column " + this, e);
        }

        return formattedString;
    }
}
