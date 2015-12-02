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
package org.efaps.dataexporter.output.texttable;

import java.io.StringWriter;
import java.lang.reflect.Field;

import org.efaps.dataexporter.DataExporter;
import org.efaps.dataexporter.DataExporterTestBase;
import org.efaps.dataexporter.model.AbstractDataExporterCallback;
import org.efaps.dataexporter.model.AlignType;
import org.efaps.dataexporter.model.CellDetails;
import org.efaps.dataexporter.model.DataExporterCallback;
import org.efaps.dataexporter.model.StringColumn;
import org.testng.annotations.Test;

public class TextTableExporterTest extends DataExporterTestBase {

    public TextTableExporterTest() {
        this.exporter = new TextTableExporter(this.sw);
    }

    @Test
    public void testDefaultFormat() throws Exception {
        addData();
        this.exporter.finishExporting();

        System.out.println(this.sw.toString());
        compareText("testDefaultFormat.txt", this.sw.toString());
    }

    @Test
    public void testBeanRows() throws Exception {
        addDataBeans();
        this.exporter.finishExporting();

        System.out.println(this.sw.toString());
    }

    @Test
    public void testRepeatHeaders() throws Exception {
        ((TextTableExportOptions) this.exporter.getOptions()).setRepeatHeadersAfterRows(2);
        addData();
        this.exporter.finishExporting();

        System.out.println(this.sw.toString());
        compareText("testRepeatHeaders.txt", this.sw.toString());
    }

    @Test
    public void testMinRows() throws Exception {
        ((TextTableExportOptions) this.exporter.getOptions()).setMinRowHeight(3);
        addData();
        this.exporter.finishExporting();

        System.out.println(this.sw.toString());
        compareText("testMinRows.txt", this.sw.toString());
    }

    @Test
    public void testHeaderAlignment() throws Exception {
        ((TextTableExportOptions) this.exporter.getOptions()).setHeaderAlignment(AlignType.MIDDLE_LEFT);
        addData();
        this.exporter.finishExporting();

        System.out.println(this.sw.toString());
        compareText("testHeaderAlignment.txt", this.sw.toString());
    }

    @Test
    public void testAlignment() throws Exception {
        final DataExporterCallback callback = new AbstractDataExporterCallback() {

            @Override
            public void beforeCell(final CellDetails cellDetails) {
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

        final TextTableExporter exporter = new TextTableExporter(this.sw);
        exporter.setCallback(callback);
        exporter.addColumns(new StringColumn("", 15, AlignType.MIDDLE_CENTER), new StringColumn(
                        "LEFT", 15), new StringColumn("CENTER", 15), new StringColumn("RIGHT", 15));
        exporter.getTextTableExportOptions().setMinRowHeight(8);

        final String data = "This is alignment test with some reallyreallybig words";
        exporter.addRow("TOP", data, data, data);
        exporter.addRow("MIDDLE", data, data, data);
        exporter.addRow("BOTTOM", data, data, data);
        exporter.finishExporting();

        System.out.println(this.sw.toString());

        compareText("testAlignment.txt", this.sw.toString());
    }

    @Test
    public void testPrintStyles() throws Exception {
        final Field[] fields = TextTableExportStyle.class.getFields();
        for (final Field field : fields) {
            if (field.getType().getName().equals(TextTableExportStyle.class.getName())) {

                System.out.println("");
                System.out.println("<h2>" + field.getName() + "</h2><pre>");
                this.exporter = new TextTableExporter();
                this.exporter.getOptions().setEscapeHtml(true);
                ((TextTableExportOptions) this.exporter.getOptions()).setStyle((TextTableExportStyle) field.get(null));
                setup();
                addData();
                this.exporter.finishExporting();
                System.out.println("</pre>");
            }
        }
    }

    /**
     * This is the test case for github issue#1.
     */
    @Test
    public void testtIssue1() throws Exception {

        //Essentially if data fits into the cell, whatever the alignment you give, it shoudln't matter
        //should produce same result.
        for (final AlignType alignType : AlignType.values()) {

            final StringWriter sw = new StringWriter();
            final DataExporter exporter = new TextTableExporter(sw);

            exporter.addColumns(new StringColumn("col1", 20), new StringColumn("col2", 50, alignType));
            exporter.startExporting();
            exporter.addRow("test", "test with a string of less than 50 chars");
            exporter.finishExporting();

            if (alignType.isLeft()) {
                compareText("Align:" + alignType, "testIssue1LeftAlign.txt", sw.toString());

            } else if (alignType.isCenter()) {
                compareText("Align:" + alignType, "testIssue1CenterAlign.txt", sw.toString());

            } else {
                compareText("Align:" + alignType, "testIssue1RightAlign.txt", sw.toString());
            }
        }
    }
}
