/*
 * Copyright 2003 - 2015 The eFaps Team
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

import static org.apache.commons.lang3.StringUtils.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.efaps.dataexporter.model.BooleanColumn;
import org.efaps.dataexporter.model.CurrencyColumn;
import org.efaps.dataexporter.model.DateColumn;
import org.efaps.dataexporter.model.LineNumberColumn;
import org.efaps.dataexporter.model.NumberColumn;
import org.efaps.dataexporter.model.StringColumn;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

/**
 * The Class AbstractDataExporterTestBase.
 *
 * @author The eFaps Team
 */
public abstract class AbstractDataExporterTestBase
{

    /** The date reference. */
    private final LocalDateTime baseDate = LocalDateTime.of(2018, 8, 26, 16, 33, 12, 0);

    /** The string writer. */
    private StringWriter stringWriter;

    /** The exporter. */
    private DataExporter exporter;

    /**
     * Gets the string writer.
     *
     * @return the string writer
     */
    protected StringWriter getStringWriter()
    {
        return this.stringWriter;
    }

    /**
     * Sets the string writer.
     *
     * @param _stringWriter the new string writer
     */
    protected void setStringWriter(final StringWriter _stringWriter)
    {
        this.stringWriter = _stringWriter;
    }

    /**
     * Gets the exporter.
     *
     * @return the exporter
     */
    protected DataExporter getDataExporter()
    {
        return this.exporter;
    }

    /**
     * Gets the new data exporter.
     *
     * @return the new data exporter
     */
    protected abstract DataExporter getNewDataExporter();

    /**
     * Setup.
     */
    @BeforeMethod
    public void setup()
    {
        this.exporter = getNewDataExporter();
        this.exporter.addColumns(new LineNumberColumn("lineNo", "Line No", 5),
                        new DateColumn("datePurchased", "Date Purchased", 23, "yyyy/MM/dd hh:mm:ss a"),
                        new NumberColumn("itemNo", "Item No", 10, 0),
                        new StringColumn("itemName", "Item Name", 15),
                        new BooleanColumn("shipped", "Shipped?", 10),
                        new NumberColumn("quantity", "Quantity", 10, 0),
                        new CurrencyColumn("unitPrice", "Unit Price", 10, "$"),
                        new CurrencyColumn("price", "Price", 10, "$")
                            .setGeneratesOwnData(true)
                            .setCellValueGenerator(cellDetails ->
                                new Double((Integer) cellDetails.getRow().getCellValue(5)
                                                * (Double) cellDetails.getRow().getCellValue(6))));
    }

    /**
     * Adds the data.
     */
    protected void addData()
    {

        this.exporter.addRow(getDate4Laptop(), new Integer(1), "Laptop", new Boolean(false),
                        new Integer(1), new Double(799.78));
        this.exporter.addRow(getDate4Mouse(), new Integer(2), "Mouse", new Boolean(true),
                        new Integer(2), new Double(49.30));
        this.exporter.addRow(getDate4Keyboard(), new Integer(3), "Keyboard", new Boolean(false),
                        new Integer(5), new Double(75));
    }

    /**
     * Adds the data beans.
     */
    protected void addDataBeans()
    {
        final List<SampleBean> beans = new ArrayList<>();
        beans.add(new SampleBean(getDate4Laptop(), new Integer(1), "Laptop", new Boolean(false),
                        new Integer(1), new Double(799.78)));
        beans.add(new SampleBean(getDate4Mouse(), new Integer(2), "Mouse", new Boolean(true),
                        new Integer(2), new Double(49.30)));
        beans.add(new SampleBean(getDate4Keyboard(), new Integer(3), "Keyboard", new Boolean(
                        false), new Integer(5), new Double(75)));
        this.exporter.addBeanRows(beans);
    }

    /**
     * Compare text.
     *
     * @param file the file
     * @param text the text
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected void compareText(final String file,
                               final String text)
                                   throws IOException
    {
        compareText(null, file, text);
    }

    /**
     * Compare text.
     *
     * @param message the message
     * @param file the file
     * @param text the text
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected void compareText(final String message, final String file, String text) throws IOException {
        final InputStream inputStream = this.getClass().getResourceAsStream(file);
        Assert.assertNotNull(inputStream, "Couldn't read the reference template");

        String expected = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        if (isNotEmpty(message)) {
            System.out.println("\nExpected (" + message + "/" + file + ")\n"+ expected);
        } else {
            System.out.println("\nExpected (" +  file + ")\n"+ expected);
        }
        System.out.println("\nProduced:\n"+ text);

        expected = StringUtils.replace(expected, "\r\n", "\n");
        text = StringUtils.replace(text, "\r\n", "\n");
        Assert.assertEquals(expected.trim(), text.trim());
    }

    protected LocalDateTime getBaseDate()
    {
        return this.baseDate;
    }

    protected LocalDateTime getDate4Laptop()
    {
        return this.baseDate.minusDays(2);
    }

    protected LocalDateTime getDate4Mouse()
    {
        return this.baseDate.plusHours(4);
    }

    protected LocalDateTime getDate4Keyboard()
    {
        return this.baseDate.plusMonths(1).plusHours(2).plusMinutes(15);
    }
}
