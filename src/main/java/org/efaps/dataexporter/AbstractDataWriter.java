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

import java.io.OutputStream;
import java.io.Writer;
import java.util.List;

import org.efaps.dataexporter.model.CellDetails;
import org.efaps.dataexporter.model.Column;
import org.efaps.dataexporter.model.HeaderCellDetails;
import org.efaps.dataexporter.model.RowDetails;
import org.efaps.dataexporter.model.Table;

/**
 * Empty implementation of {@link DataWriter}. All other data writers must
 * extend this instead
 * of DataWriter to keep it backward compatible.
 *
 * @author Santhosh Kumar
 */
public class AbstractDataWriter
    extends DataWriter
{

    public AbstractDataWriter(final ExportOptions options,
                              final OutputStream out)
    {
        super(options, out);
    }

    public AbstractDataWriter(final ExportOptions options,
                              final Writer out)
    {
        super(options, out);
    }

    @Override
    public void beforeTable(final Table table)
    {
        // do nothing

    }

    @Override
    public void beforeHeaderRow(final Table table)
    {
        // do nothing

    }

    @Override
    public void beforeHeaderCell(final HeaderCellDetails headerCell)
    {
        // do nothing

    }

    @Override
    public void writeHeaderCell(final HeaderCellDetails headerCell)
    {
        // do nothing

    }

    @Override
    public void afterHeaderCell(final HeaderCellDetails headerCell)
    {
        // do nothing

    }

    @Override
    public void afterHeaderRow(final Table table)
    {
        // do nothing

    }

    @Override
    public void beforeRow(final RowDetails rowDetails)
    {
        // do nothing

    }

    @Override
    public void beforeRowCell(final CellDetails cellDetails)
    {
        // do nothing

    }

    @Override
    public void writeRowCell(final CellDetails cellDetails)
    {
        // do nothing

    }

    @Override
    public void afterRowCell(final CellDetails cellDetails)
    {
        // do nothing

    }

    @Override
    public void afterRow(final RowDetails rowDetails)
    {
        // do nothing

    }

    @Override
    public void beforeFooterRow(final Table table)
    {
        // do nothing

    }

    // @Override
    // public void beforeFooterCell(FooterCellDetails footerCellDetails) {
    // //do nothing
    //
    // }
    //
    // @Override
    // public void writeFooterCell(FooterCellDetails footerCellDetails) {
    // //do nothing
    //
    // }
    //
    // @Override
    // public void afterFooterCell(FooterCellDetails footerCellDetails) {
    // //do nothing
    //
    // }

    @Override
    public void afterFooterRow(final List<Column> columns)
    {
        // do nothing

    }

    @Override
    public void afterTable(final Table table)
    {
        // do nothing

    }

}
