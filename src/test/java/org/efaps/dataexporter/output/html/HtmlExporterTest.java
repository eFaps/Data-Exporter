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
package org.efaps.dataexporter.output.html;

import java.io.StringWriter;

import org.efaps.dataexporter.AbstractDataExporterTestBase;
import org.efaps.dataexporter.DataExporter;
import org.efaps.dataexporter.model.AbstractDataExporterCallback;
import org.efaps.dataexporter.model.AlignType;
import org.efaps.dataexporter.model.CellDetails;
import org.efaps.dataexporter.model.DataExporterCallback;
import org.efaps.dataexporter.model.StringColumn;
import org.testng.annotations.Test;

public class HtmlExporterTest
    extends AbstractDataExporterTestBase
{

    @Override
    protected DataExporter getNewDataExporter()
    {
        final StringWriter sw = new StringWriter();
        setStringWriter(sw);
        return new HtmlExporter(sw);
    }

    @Test
    public void testFormatted()
        throws Exception
    {
        ((HtmlExporter) getDataExporter()).getHtmlExportOptions().setPrettyPrint(true);
        ((HtmlExporter) getDataExporter()).getHtmlExportOptions().setAlignCells(false);

        addData();
        getDataExporter().finishExporting();
        compareText("testFormatted.txt", getStringWriter().toString());
    }

    @Test
    public void testBasic()
        throws Exception
    {
        ((HtmlExporter) getDataExporter()).getHtmlExportOptions().setAlignCells(false);
        addData();
        getDataExporter().finishExporting();
        compareText("testBasic.txt", getStringWriter().toString());
    }

    @Test
    public void testAlignment()
        throws Exception
    {

        final DataExporterCallback callback = new AbstractDataExporterCallback()
        {

            @Override
            public void beforeCell(final CellDetails cellDetails)
            {
                final int row = cellDetails.getRowIndex();
                final int column = cellDetails.getColumnIndex();

                AlignType align = null;
                if (row == 0 && column == 1) {
                    align = AlignType.TOP_LEFT;
                } else if (row == 0 && column == 2) {
                    align = AlignType.TOP_CENTER;
                } else if (row == 0 && column == 3) {
                    align = AlignType.TOP_RIGHT;
                } else if (row == 1 && column == 1) {
                    align = AlignType.MIDDLE_LEFT;
                } else if (row == 1 && column == 2) {
                    align = AlignType.MIDDLE_CENTER;
                } else if (row == 1 && column == 3) {
                    align = AlignType.MIDDLE_RIGHT;
                } else if (row == 2 && column == 1) {
                    align = AlignType.BOTTOM_LEFT;
                } else if (row == 2 && column == 2) {
                    align = AlignType.BOTTOM_CENTER;
                } else if (row == 2 && column == 3) {
                    align = AlignType.BOTTOM_RIGHT;
                }

                cellDetails.setCellAlign(align);
            }
        };

        final HtmlExporter exporter = new HtmlExporter(getStringWriter());
        exporter.getHtmlExportOptions().setPrettyPrint(true);
        exporter.setCallback(callback);
        exporter.addColumns(new StringColumn("", 15, AlignType.MIDDLE_CENTER), new StringColumn("LEFT", 15),
                        new StringColumn("CENTER", 15), new StringColumn("RIGHT", 15));

        final String data = "This is alignment test with some reallyreallybig words";
        exporter.addRow("TOP", data, data, data);
        exporter.addRow("MIDDLE", data, data, data);
        exporter.addRow("BOTTOM", data, data, data);
        exporter.finishExporting();
        compareText("testAlignment.txt", getStringWriter().toString());
    }
}
