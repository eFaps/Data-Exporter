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

import static org.efaps.dataexporter.util.Util.*;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.efaps.dataexporter.model.BeanRow;
import org.efaps.dataexporter.model.Column;
import org.efaps.dataexporter.model.DataExporterCallback;
import org.efaps.dataexporter.model.Row;
import org.efaps.dataexporter.model.StringColumn;
import org.efaps.dataexporter.model.Table;

/**
 * Base class of all exporters. This class holds the instance of {@link Table},
 * {@link DataWriter}
 * and appropriately calls the DataWriter methods during the exporting.
 *
 * @author Santhosh Kumar
 */
public abstract class DataExporter
{

    private final Table table = new Table();
    private DataWriter dataWriter = null;
    private boolean startedExporting = false;

    protected DataExporter(final DataWriter dataWriter)
    {
        checkForNotNull(dataWriter, "datawriter");
        this.dataWriter = dataWriter;
    }

    public DataExporterCallback getCallback()
    {
        return this.table.getCallback();
    }

    public void setCallback(final DataExporterCallback callback)
    {
        this.table.setCallback(callback);
    }

    public void setOutputStream(final PrintWriter out)
    {
        this.dataWriter.setOutputStream(out);
    }

    /**
     * Returns the currently assigned {@link DataWriter}
     *
     * @return the data writer
     */
    public DataWriter getDataWriter()
    {
        return this.dataWriter;
    }

    /**
     * Returns the current options in the {@link DataWriter}. This is
     * convenience method and is
     * equivalent to <code>getDataWriter().getOptions()</code>
     *
     * @return the current data writer options.
     */
    public ExportOptions getOptions()
    {
        return this.dataWriter.getOptions();
    }

    /**
     * Adds a set of new {@link StringColumn} using the given strings as column
     * name and title.
     * Width of the columns would be same as length of names.
     * <p>
     * Note that columns can only be added before any rows. If any of the rows
     * are already added, this would throw <code>IllegalStateException</code>
     *
     * @param columns the list of strings to be added as new
     *            {@link StringColumn}s. Cannot be <code>null</code>.
     * @throws IllegalStateException if rows are already added
     * @return the current instance of data exporter for method chaining.
     */
    public DataExporter addColumn(final String... columns)
    {
        checkForNotNull(columns, "columns");

        for (final String column : columns) {
            this.table.addColumn(new StringColumn(column));
        }

        return this;
    }

    /**
     * Adds given list of columns to the table.
     * <p>
     * Note that columns can only be added before any rows. If any of the rows
     * are already added, this would throw <code>IllegalStateException</code>
     *
     * @param columns the list of columns to be added. Cannot be
     *            <code>null</code>.
     * @throws IllegalStateException if rows are already added
     * @return the current instance of data exporter for method chaining.
     */
    public DataExporter addColumns(final Column... columns)
    {
        checkForNotNull(columns, "columns");

        checkNotExporting();

        for (final Column column : columns) {
            this.table.addColumn(column);
        }

        return this;
    }

    // /**
    // * Adds given list of footers to the table.
    // * <p>
    // * Note that footers can be added to the table any time before calling
    // {@link #finishExporting()}
    // *
    // * @param footers the list of footers to be added to the table. Cannot be
    // <code>null</code>.
    // * @return the current instance of data exporter for method chaining.
    // */
    // public DataExporter addFooters(Footer... footers) {
    // checkForNotNull(footers, "footers");
    //
    // for (Footer footer : footers) {
    // table.addFooter(footer);
    // }
    //
    // return this;
    // }

    /**
     * Creates a new row with given set of values and adds to the table. If this
     * is the first
     * row being added, exporting would be started (header and this rows would
     * be exported).
     * <p>
     * If there are less number of values than there are columns, values would
     * be assumed as <code>null</code>.
     * If there are more values than there are columns, those values would be
     * ignored.
     *
     * @param rowValues array of row values to be added as a row. Cannot be
     *            <code>null</code>.
     * @return the current instance of data exporter for method chaining.
     */
    public DataExporter addRow(final Object... rowValues)
    {
        checkForNotNull(rowValues, "rowValues");

        final Row row = new Row();
        row.add(rowValues);

        addRows(row);

        return this;
    }

    /**
     * Adds the given row to the table. If this is the first
     * row being added, exporting would be started (header and this rows would
     * be exported).
     * <p>
     * If there are less number of values than there are columns, values would
     * be assumed as <code>null</code>.
     * If there are more values than there are columns, those values would be
     * ignored.
     *
     * @param rows array of row values to be added as a row. Cannot be
     *            <code>null</code>.
     * @return the current instance of data exporter for method chaining.
     */
    public DataExporter addRows(final Row... rows)
    {
        checkForNotNull(rows, "rows");

        startExporting();

        this.dataWriter.writeRows(this.table, Arrays.asList(rows));

        return this;
    }

    /**
     * Creates a {@link BeanRow} for each of the given beans and adds to table
     * using {@link #addRows(Row...)} method.
     *
     * @param beans array of beans to be added to table as bean rows. Cannot be
     *            <code>null</code>.
     * @return the current instance of data exporter for method chaining.
     */
    public DataExporter addBeanRows(final Object... beans)
    {
        checkForNotNull(beans, "beans");

        for (final Object object : beans) {
            addRows(new BeanRow(object));
        }

        return this;
    }

    public DataExporter addBeanRows(final List beans)
    {
        checkForNotNull(beans, "beans");

        for (final Object object : beans) {
            addRows(new BeanRow(object));
        }

        return this;
    }

    /**
     * This would start the data exporting by exporting the table header. After
     * this call, new columns cannot be added.
     * <p>
     * If table is already in exporting mode, this method has no effect.
     *
     */
    public synchronized void startExporting()
    {

        if (this.startedExporting) {
            return;
        }

        this.startedExporting = true;

        this.dataWriter.beforeTable(this.table);
        this.dataWriter.writeHeader(this.table);
    }

    /**
     * Finishes the exporting by writing the footers, and end of table. After
     * this call, columns can be readded
     * to the table.
     * <p>
     * If table was not started to export the data, this method would throw
     * {@link IllegalStateException}.
     */
    public void finishExporting()
    {
        if (!this.startedExporting) {
            throw new IllegalStateException("Data export has not been started to finish!");
        }

        this.dataWriter.afterTable(this.table);
        this.dataWriter.flush();
        this.dataWriter.finishExporting();
        this.startedExporting = false;
    }

    /**
     * Checks and throws the exception of data is already started to be
     * exported.
     */
    private void checkNotExporting()
    {
        if (this.startedExporting) {
            throw new IllegalStateException("DataExporter has already started exporting the data and "
                            + "hence new columns cannot be added.");
        }
    }
}
