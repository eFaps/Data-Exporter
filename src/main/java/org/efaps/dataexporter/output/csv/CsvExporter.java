/*
 * Copyright © 2003 - 2024 The eFaps Team (-)
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
 */
package org.efaps.dataexporter.output.csv;

import java.io.OutputStream;
import java.io.Writer;

import org.efaps.dataexporter.DataExporter;

public class CsvExporter
    extends DataExporter
{

    public CsvExporter(final OutputStream out)
    {
        this(new CsvExportOptions(), out);
    }

    public CsvExporter(final CsvExportOptions options,
                       final OutputStream out)
    {
        super(new CsvWriter(options, out));
    }

    public CsvExporter(final Writer out)
    {
        this(new CsvExportOptions(), out);
    }

    public CsvExporter(final CsvExportOptions csvExportOptions,
                       final Writer out)
    {
        super(new CsvWriter(csvExportOptions, out));
    }

    public CsvExporter()
    {
        this(System.out);
    }

    public CsvExporter(final CsvExportOptions options)
    {
        this(options, System.out);
    }

    public CsvExportOptions getCsvExportOptions()
    {
        return (CsvExportOptions) getDataWriter().getOptions();
    }

}
