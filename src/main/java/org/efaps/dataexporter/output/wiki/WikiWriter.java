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
package org.efaps.dataexporter.output.wiki;

import java.io.OutputStream;
import java.io.Writer;

import org.efaps.dataexporter.AbstractDataWriter;
import org.efaps.dataexporter.model.CellDetails;
import org.efaps.dataexporter.model.HeaderCellDetails;
import org.efaps.dataexporter.model.RowDetails;
import org.efaps.dataexporter.model.Table;

/**
 * Wiki write which writes the output in wiki format. Sample output is as
 * follows.
 *
 * <pre>
 * ||Line No||Date Purchased||Item No||Item Name||Shipped?||Quantity||Unit Price||Price||
 * ||1||2011/04/07 08:48:39 AM||1||Laptop||No||1||$799.78||$799.78||
 * ||2||2011/04/04 05:01:15 PM||2||Mouse||Yes||2||$49.30||$98.60||
 * ||3||2011/04/04 04:27:13 PM||3||Keyboard||No||5||$75.00||$375.00||
 * </pre>
 *
 * @author Santhosh Kumar
 */
public class WikiWriter
    extends AbstractDataWriter
{

    public WikiWriter()
    {
        this(System.out);
    }

    public WikiWriter(final WikiExportOptions options)
    {
        super(options, System.out);
    }

    public WikiWriter(final WikiExportOptions options,
                      final OutputStream out)
    {
        super(options, out);
    }

    public WikiWriter(final OutputStream out)
    {
        super(new WikiExportOptions(), out);
    }

    public WikiWriter(final WikiExportOptions options,
                      final Writer out)
    {
        super(options, out);
    }

    public WikiWriter(final Writer out)
    {
        super(new WikiExportOptions(), out);
    }

    public WikiExportOptions getTextExportOptions()
    {
        return (WikiExportOptions) getOptions();
    }

    @Override
    public void beforeHeaderRow(final Table table)
    {
        println();
        print(getTextExportOptions().getDelimiter());
    }

    @Override
    public void writeHeaderCell(final HeaderCellDetails headerCell)
    {
        writeCell(headerCell.getColumnIndex(), headerCell.getColumn().getTitle());
    }

    @Override
    public void afterHeaderRow(final Table table)
    {
        print(getTextExportOptions().getDelimiter());
    }

    @Override
    public void beforeRow(final RowDetails rowDetails)
    {
        println();
        print(getTextExportOptions().getDelimiter());
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

    @Override
    public void afterRow(final RowDetails rowDetails)
    {
        print(getTextExportOptions().getDelimiter());
    }
}
