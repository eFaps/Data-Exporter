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
package org.efaps.dataexporter.output.json;

import java.sql.Date;

import org.efaps.dataexporter.DataExporterTestBase;
import org.efaps.dataexporter.model.json.JsonExporter;
import org.testng.annotations.Test;

public class JsonExporterTest
    extends DataExporterTestBase
{

    public JsonExporterTest()
    {
        this.exporter = new JsonExporter(this.sw);
    }

    @Test
    public void testBasic()
        throws Exception
    {
        addData();
        this.exporter.addRow(new Date(this.dateReference - 2397984), new Integer(1), "Lap\"top", new Boolean(false),
                        new Integer(1), new Double(799.78));
        this.exporter.finishExporting();

        System.out.println(this.sw.toString());
        compareText("testBasic.txt", this.sw.toString());
    }

    @Test
    public void testFormatted()
        throws Exception
    {
        ((JsonExporter) this.exporter).getJsonExportOptions().setPrettyPrint(true);
        addData();
        this.exporter.addRow(new Date(this.dateReference - 2397984), new Integer(1), "Lap\"top", new Boolean(false),
                        new Integer(1), new Double(799.78));
        this.exporter.finishExporting();

        System.out.println(this.sw.toString());
        compareText("testFormatted.txt", this.sw.toString());
    }

    @Test
    public void testFormattedDoubleEscape()
        throws Exception
    {
        ((JsonExporter) this.exporter).getJsonExportOptions().setPrettyPrint(true).setDoubleEscape(true);
        addData();
        this.exporter.addRow(new Date(this.dateReference - 2397984), new Integer(1), "Lap\"top", new Boolean(false),
                        new Integer(1), new Double(799.78));
        this.exporter.finishExporting();

        System.out.println(this.sw.toString());
        compareText("testFormattedDoubleEscape.txt", this.sw.toString());
    }
}
