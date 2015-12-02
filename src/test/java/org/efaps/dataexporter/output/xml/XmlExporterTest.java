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
package org.efaps.dataexporter.output.xml;

import org.efaps.dataexporter.DataExporterTestBase;
import org.testng.annotations.Test;

public class XmlExporterTest
    extends DataExporterTestBase
{

    public XmlExporterTest()
    {
        this.exporter = new XmlExporter(this.sw);
    }

    @Test
    public void testBasic()
        throws Exception
    {
        addData();
        this.exporter.finishExporting();

        System.out.println(this.sw.toString());
        compareText("testBasic.txt", this.sw.toString());
    }

    @Test
    public void testFormatted()
        throws Exception
    {
        ((XmlExportOptions) this.exporter.getOptions()).setPrettyPrint(true);
        addData();
        this.exporter.finishExporting();

        System.out.println(this.sw.toString());
        compareText("testFormatted.txt", this.sw.toString());
    }
}
