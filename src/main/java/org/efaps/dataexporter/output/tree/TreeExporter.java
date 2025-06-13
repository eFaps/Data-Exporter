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
package org.efaps.dataexporter.output.tree;

import java.io.OutputStream;
import java.io.Writer;

import org.efaps.dataexporter.DataExporter;

/**
 * Tree Exporter is not fully tested so things may change in subsequent
 * versions.
 *
 * @author kumarsa
 */
public class TreeExporter
    extends DataExporter
{

    public TreeExporter(final OutputStream out)
    {
        this(new TreeExportOptions(), out);
    }

    public TreeExporter(final TreeExportOptions options,
                        final OutputStream out)
    {
        super(new TreeWriter(options, out));
    }

    public TreeExporter(final Writer out)
    {
        this(new TreeExportOptions(), out);
    }

    public TreeExporter(final TreeExportOptions options,
                        final Writer out)
    {
        super(new TreeWriter(options, out));
    }

    public TreeExporter()
    {
        this(System.out);
    }

    public TreeExporter(final TreeExportOptions options)
    {
        this(options, System.out);
    }

    public TreeExportOptions getTreeExporterOptions()
    {
        return (TreeExportOptions) getOptions();
    }
}
