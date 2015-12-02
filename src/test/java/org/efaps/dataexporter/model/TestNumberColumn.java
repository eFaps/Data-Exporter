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
package org.efaps.dataexporter.model;

import java.io.StringWriter;
import java.text.NumberFormat;
import java.util.Locale;

import org.efaps.dataexporter.model.NumberColumn;
import org.efaps.dataexporter.output.text.TextExporter;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestNumberColumn {
    
    @Test
    public void testNumberColumn() throws Exception {
        StringWriter sw = new StringWriter();
        
        TextExporter exporter = new TextExporter(sw);
        exporter.getOptions().setPrintHeaders(false);
        exporter.addColumns(new NumberColumn("number", 10, 10));
        exporter.addRow((float)22/7);
        exporter.finishExporting();
        assertEquals("3.1428570747", sw.toString().trim());
        
        exporter = new TextExporter(sw);
        exporter.getOptions().setPrintHeaders(false);
        exporter.addColumns(new NumberColumn("number", 10, 10));
        exporter.addRow((float)22/7);
        exporter.finishExporting();
    }
    
    @Test
    public void testNumberDecimalFormatter() throws Exception {
        StringWriter sw = new StringWriter();
        
        TextExporter exporter = new TextExporter(sw);
        exporter.getOptions().setPrintHeaders(false);

        exporter.addColumns(new NumberColumn("number", 10, NumberFormat.getNumberInstance(Locale.GERMAN)));
        exporter.addRow(1234567.234);
        exporter.finishExporting();
        assertEquals("1.234.567,234", sw.toString().trim());
	}
}
