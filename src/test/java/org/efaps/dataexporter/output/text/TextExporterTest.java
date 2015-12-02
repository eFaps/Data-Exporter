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
package org.efaps.dataexporter.output.text;

import org.efaps.dataexporter.DataExporterTestBase;
import org.testng.annotations.Test;

/**
 * The Class TextExporterTest.
 *
 * @author The eFaps Team
 */
public class TextExporterTest
    extends DataExporterTestBase
{

    /**
     * Instantiates a new text exporter test.
     */
    public TextExporterTest()
    {
        this.exporter = new TextExporter(this.sw);
    }

    /**
     * Test basic.
     *
     * @throws Exception the exception
     */
    @Test
    public void testBasic()
        throws Exception
    {
        addData();
        this.exporter.finishExporting();

        System.out.println(this.sw);
        compareText("testBasic.txt", this.sw.toString());
    }
}
