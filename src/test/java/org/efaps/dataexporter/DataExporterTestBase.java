/*
 * #%L
 * data-exporter
 * %%
 * Copyright (C) 2012 - 2013 http://www.brsanthu.com
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.efaps.dataexporter;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.efaps.dataexporter.model.BooleanColumn;
import org.efaps.dataexporter.model.CellDetails;
import org.efaps.dataexporter.model.CellValueGenerator;
import org.efaps.dataexporter.model.CurrencyColumn;
import org.efaps.dataexporter.model.DateColumn;
import org.efaps.dataexporter.model.LineNumberColumn;
import org.efaps.dataexporter.model.NumberColumn;
import org.efaps.dataexporter.model.StringColumn;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class DataExporterTestBase
{

    protected DataExporter exporter = null;
    protected StringWriter sw = new StringWriter();
    protected long dateReference = 1303413278558l; // Thu Apr 21 12:14:38 PDT
                                                   // 2011

    @BeforeTest
    public void setup()
    {
        if (this.exporter == null) {
            return;
        }
        this.exporter.addColumns(new LineNumberColumn("lineNo", "Line No", 5), new DateColumn("datePurchased",
                        "Date Purchased", 23, "yyyy/MM/dd hh:mm:ss a"), new NumberColumn("itemNo", "Item No", 10, 0),
                        new StringColumn("itemName", "Item Name", 15), new BooleanColumn("shipped", "Shipped?", 10),
                        new NumberColumn("quantity", "Quantity", 10, 0), new CurrencyColumn("unitPrice", "Unit Price",
                                        10, "$"), new CurrencyColumn("price", "Price", 10, "$").setGeneratesOwnData(
                                                        true).setCellValueGenerator(new CellValueGenerator()
                                                        {

                                                            @Override
                                                            public Object generateCellValue(final CellDetails cellDetails)
                                                            {
                                                                return new Double(((Integer) cellDetails.getRow()
                                                                                .getCellValue(5))
                                                                                * ((Double) cellDetails.getRow()
                                                                                                .getCellValue(6)));
                                                            }
                                                        }));
    }

    protected void addData()
    {

        this.exporter.addRow(new Date(this.dateReference - 2397984), new Integer(1), "Laptop", new Boolean(false),
                        new Integer(1), new Double(799.78));
        this.exporter.addRow(new Date(this.dateReference - 232042098), new Integer(2), "Mouse", new Boolean(true),
                        new Integer(2), new Double(49.30));
        this.exporter.addRow(new Date(this.dateReference - 234084277), new Integer(3), "Keyboard", new Boolean(false),
                        new Integer(5), new Double(75));
    }

    protected void addDataBeans()
    {
        final List<SampleBean> beans = new ArrayList<SampleBean>();
        beans.add(new SampleBean(new Date(this.dateReference - 2397984), new Integer(1), "Laptop", new Boolean(false),
                        new Integer(1), new Double(799.78)));
        beans.add(new SampleBean(new Date(this.dateReference - 232042098), new Integer(2), "Mouse", new Boolean(true),
                        new Integer(2), new Double(49.30)));
        beans.add(new SampleBean(new Date(this.dateReference - 234084277), new Integer(3), "Keyboard", new Boolean(
                        false), new Integer(5), new Double(75)));

        this.exporter.addBeanRows(beans);
    }

    protected void compareText(final String file,
                               final String text)
                                   throws IOException
    {
        compareText(null, file, text);
    }

    protected void compareText(final String message, final String file, String text) throws IOException {
        final InputStream inputStream = this.getClass().getResourceAsStream(file);
        Assert.assertNotNull(inputStream, "Couldn't read the reference template");

        String expected = IOUtils.toString(inputStream);
        System.out.println("---------------------------------------------------------------------------");
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

}