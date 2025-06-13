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
 * String column which displays the given string. Default alignment is middle
 * left.
 *
 * @author Santhosh Kumar
 */
public class StringColumn
    extends Column
{

    public StringColumn(final String name)
    {
        super(name);
    }

    public StringColumn(final String name,
                        final int width)
    {
        this(name, width, AlignType.MIDDLE_LEFT);
    }

    public StringColumn(final String name,
                        final String title,
                        final int width)
    {
        this(name, title, width, AlignType.MIDDLE_LEFT);
    }

    public StringColumn(final String name,
                        final int width,
                        final AlignType align)
    {
        super(name, width, align);
    }

    public StringColumn(final String name,
                        final String title,
                        final int width,
                        final AlignType align)
    {
        super(name, title, width, align);
    }

    @Override
    public int getMaxRowHeight(final CellDetails cellDetails)
    {
        if (cellDetails.getCellValue() == null) {
            return 1;
        }

        return getMaxRowHeight(cellDetails.getCellValue().toString());
    }

    @Override
    public String format(final CellDetails cellDetails)
    {
        if (cellDetails.getCellValue() == null) {
            return "";
        }

        return cellDetails.getCellValue().toString();
    }
}
