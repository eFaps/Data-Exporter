/*
 * Copyright © 2003 - 2024 The eFaps Team (-)
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
 */
package org.efaps.dataexporter.model;

/**
 * Column which converts the boolean string into boolean strings as per
 * configured format.
 *
 * @author Santhosh Kumar
 */
public class BooleanColumn
    extends Column
{

    private Format format = Format.YES_NO;

    public static enum Format
    {
        YES_NO, TRUE_FALSE, ONE_ZERO
    }

    /**
     * Constructor with default Yes/No formatting.
     *
     * @param name
     * @param width
     */
    public BooleanColumn(final String name,
                         final int width)
    {
        this(name, null, width, AlignType.MIDDLE_LEFT, Format.YES_NO);
    }

    public BooleanColumn(final String name,
                         final String title,
                         final int width)
    {
        this(name, title, width, AlignType.MIDDLE_LEFT, Format.YES_NO);
    }

    public BooleanColumn(final String name,
                         final int width,
                         final AlignType align)
    {
        this(name, null, width, align, Format.YES_NO);
    }

    public BooleanColumn(final String name,
                         final String title,
                         final int width,
                         final AlignType align,
                         final Format format)
    {
        super(name, title, width, align);
        this.format = format;
    }

    private String getBooleanString(final boolean booleanValue)
    {
        switch (this.format) {
            case ONE_ZERO:
                return booleanValue ? "1" : "0";
            case TRUE_FALSE:
                return booleanValue ? "True" : "False";
            case YES_NO:
                return booleanValue ? "Yes" : "No";
            default:
                return booleanValue ? "Yes" : "No";
        }
    }

    @Override
    public int getMaxRowHeight(final CellDetails cellDetails)
    {
        return getMaxRowHeight(getBooleanString(new Boolean(cellDetails.getCellValue().toString())));
    }

    @Override
    public String format(final CellDetails cellDetails)
    {
        return getBooleanString(new Boolean(cellDetails.getCellValue().toString()));
    }
}
