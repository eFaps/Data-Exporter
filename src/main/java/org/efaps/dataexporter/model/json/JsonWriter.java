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
package org.efaps.dataexporter.model.json;

import java.io.OutputStream;
import java.io.Writer;

import org.apache.commons.lang3.StringUtils;
import org.efaps.dataexporter.AbstractDataWriter;
import org.efaps.dataexporter.model.CellDetails;
import org.efaps.dataexporter.model.RowDetails;
import org.efaps.dataexporter.model.Table;
import org.efaps.dataexporter.output.xml.XmlExporter;

/**
 * Writer which writes in xml format. Users wouldn't typically use this class
 * directly
 * but use this via {@link XmlExporter}.
 *
 * @author Santhosh Kumar
 */
public class JsonWriter
    extends AbstractDataWriter
{

    public JsonWriter(final JsonExportOptions options)
    {
        super(options, System.out);
    }

    public JsonWriter(final JsonExportOptions options,
                      final OutputStream out)
    {
        super(options, out);
    }

    public JsonWriter(final OutputStream out)
    {
        super(new JsonExportOptions(), out);
    }

    public JsonWriter(final JsonExportOptions options,
                      final Writer out)
    {
        super(options, out);
    }

    public JsonWriter(final Writer out)
    {
        super(new JsonExportOptions(), out);
    }

    public JsonExportOptions getJsonExportOptions()
    {
        return (JsonExportOptions) getOptions();
    }

    @Override
    public void beforeTable(final Table table)
    {
        print("{");
        prettyPrint(1);
        print("\"table\": {");
    }

    @Override
    public void beforeRow(final RowDetails rowDetails)
    {
        if (rowDetails.getRowIndex() != 0) {
            print(", ");
        }
        prettyPrint(2);
        print("\"row\": {");
    }

    @Override
    public void writeRowCell(final CellDetails cellDetails)
    {
        prettyPrint(3);
        print("\"" + cellDetails.getColumn().getName() + "\":");

        final Object cellValue = cellDetails.getCellValue();
        String cellValueString = cellValue.toString();

        if (cellValue instanceof Number || cellValue instanceof Boolean) {
            print(cellValueString);
        } else {

            if (cellValueString.contains("\"")) {

                String replaceWith = null;
                if (getJsonExportOptions().isDoubleEscape()) {
                    replaceWith = "\\\\\"";
                } else {
                    replaceWith = "\\\"";
                }

                cellValueString = StringUtils.replace(cellValueString, "\"", replaceWith);
            }
            print("\"" + cellValueString + "\"");
        }

        if (cellDetails.getColumnIndex() != cellDetails.getTable().getColumns().size() - 1) {
            print(",");
        }
    }

    @Override
    public void afterRow(final RowDetails rowDetails)
    {
        prettyPrint(2);
        print("}");
    }

    @Override
    public void afterTable(final Table table)
    {
        prettyPrint(1);
        print("}");

        prettyPrint(0);
        print("}");
    }

    private void prettyPrint(final int level)
    {
        if (getJsonExportOptions().isPrettyPrint()) {
            print("\n");
            for (int i = 0; i < level; i++) {
                print("    ");
            }
        }
    }
}
