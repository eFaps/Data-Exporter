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

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * Date column, which formats the given date as per given formating string.
 * Format string is
 * same as documented in {@link SimpleDateFormat}
 *
 * @author Santhosh Kumar
 */
public class DateColumn
    extends Column
{

    private String dateFormat = null;
    private DateTimeFormatter df = null;

    public DateColumn(final String name,
                      final int width,
                      final String dateFormat)
    {
        this(name, null, width, AlignType.MIDDLE_LEFT, dateFormat);
    }

    public DateColumn(final String name,
                      final String title,
                      final int width,
                      final String dateFormat)
    {
        this(name, title, width, AlignType.MIDDLE_LEFT, dateFormat);
    }

    public DateColumn(final String name,
                      final String title,
                      final int width,
                      final AlignType align,
                      final String dateFormat)
    {
        super(name, title, width, align);
        this.dateFormat = dateFormat;
        this.df = DateTimeFormatter.ofPattern(dateFormat);
    }

    public String getDateFormat()
    {
        return this.dateFormat;
    }

    public void setDateFormat(final String dateFormat)
    {
        this.dateFormat = dateFormat;
    }

    @Override
    public int getMaxRowHeight(final CellDetails cellDetails)
    {
        final Object cellValue = cellDetails.getCellValue();

        if (cellValue instanceof Date) {
            return (int) Math.ceil((float) this.df.format((TemporalAccessor) cellValue).length() / getWidth());
        }

        throw new IllegalArgumentException("Expected Date instance but it is " + cellValue.getClass().getName()
                        + " instance with value " + cellValue);
    }

    @Override
    public String format(final CellDetails cellDetails)
    {
        return this.df.format((TemporalAccessor) cellDetails.getCellValue());
    }
}
