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
package org.efaps.dataexporter.output.csv;

import java.io.StringWriter;

import org.efaps.dataexporter.AbstractDataExporterTestBase;
import org.efaps.dataexporter.DataExporter;
import org.testng.annotations.Test;

public class CsvExporterTest
    extends AbstractDataExporterTestBase
{

    @Test
    public void testBasic()
        throws Exception
    {
        addData();

        getDataExporter().addRow(getDate4Laptop(), new Integer(1), "Lap\"top", new Boolean(false), new Integer(1),
                        new Double(799.78));
        getDataExporter().addRow(getDate4Laptop(), new Integer(1), "Lap,top", new Boolean(false), new Integer(1),
                        new Double(799.78));
        getDataExporter().finishExporting();

        compareText("testBasic.txt", getStringWriter().toString());
    }

    @Test
    public void testStrictQuoting()
        throws Exception
    {
        ((CsvExportOptions) getDataExporter().getOptions()).setStrictQuoting(true);
        addData();
        getDataExporter().addRow(getDate4Laptop(), new Integer(1), "Lap\"top", new Boolean(false), new Integer(1),
                        new Double(799.78));
        getDataExporter().addRow(getDate4Laptop(), new Integer(1), "Lap,top", new Boolean(false), new Integer(1),
                        new Double(799.78));
        getDataExporter().finishExporting();

        compareText("testStrictQuoting.txt", getStringWriter().toString());
    }

    @Override
    protected DataExporter getNewDataExporter()
    {
        final StringWriter sw = new StringWriter();
        setStringWriter(sw);
        return new CsvExporter(sw);
    }
}
