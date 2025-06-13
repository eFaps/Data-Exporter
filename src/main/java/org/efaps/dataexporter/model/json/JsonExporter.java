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
package org.efaps.dataexporter.model.json;

import java.io.OutputStream;
import java.io.Writer;

import org.efaps.dataexporter.DataExporter;

public class JsonExporter
    extends DataExporter
{

    public JsonExporter(final OutputStream out)
    {
        this(new JsonExportOptions(), out);
    }

    public JsonExporter(final JsonExportOptions options,
                        final OutputStream out)
    {
        super(new JsonWriter(options, out));
    }

    public JsonExporter(final Writer out)
    {
        this(new JsonExportOptions(), out);
    }

    public JsonExporter(final JsonExportOptions textExportOptions,
                        final Writer out)
    {
        super(new JsonWriter(textExportOptions, out));
    }

    public JsonExporter()
    {
        this(System.out);
    }

    public JsonExporter(final JsonExportOptions options)
    {
        this(options, System.out);
    }

    public JsonExportOptions getJsonExportOptions()
    {
        return (JsonExportOptions) getDataWriter().getOptions();
    }
}
