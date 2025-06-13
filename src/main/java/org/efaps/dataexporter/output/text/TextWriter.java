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
package org.efaps.dataexporter.output.text;

import java.io.OutputStream;
import java.io.Writer;

import org.efaps.dataexporter.AbstractDataWriter;
import org.efaps.dataexporter.model.CellDetails;
import org.efaps.dataexporter.model.HeaderCellDetails;
import org.efaps.dataexporter.model.RowDetails;

public class TextWriter
    extends AbstractDataWriter
{

    public TextWriter()
    {
        this(System.out);
    }

    public TextWriter(final TextExportOptions options)
    {
        super(options, System.out);
    }

    public TextWriter(final TextExportOptions options,
                      final OutputStream out)
    {
        super(options, out);
    }

    public TextWriter(final OutputStream out)
    {
        super(new TextExportOptions(), out);
    }

    public TextWriter(final TextExportOptions options,
                      final Writer out)
    {
        super(options, out);
    }

    public TextWriter(final Writer out)
    {
        super(new TextExportOptions(), out);
    }

    public TextExportOptions getTextExportOptions()
    {
        return (TextExportOptions) getOptions();
    }

    @Override
    public void writeHeaderCell(final HeaderCellDetails headerCell)
    {
        writeCell(headerCell.getColumnIndex(), headerCell.getColumn().getTitle());
    }

    @Override
    public void beforeRow(final RowDetails rowDetails)
    {
        println();
    }

    @Override
    public void writeRowCell(final CellDetails cellDetails)
    {
        final Object cellValue = cellDetails.getCellValue();
        writeCell(cellDetails.getColumnIndex(), cellValue == null ? "" : cellDetails.getColumn().format(cellDetails));
    }

    public void writeCell(final int i, final String cellValue)
    {
        final String delimiter = getTextExportOptions().getDelimiter();
        if (i != 0) {
            print(delimiter);
        }

        print(cellValue);
    }
}
