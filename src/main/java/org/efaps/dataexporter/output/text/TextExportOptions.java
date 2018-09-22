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
package org.efaps.dataexporter.output.text;

import org.efaps.dataexporter.ExportOptions;

public class TextExportOptions
    extends ExportOptions
{

    private String delimiter = "\t";
    private boolean trimValues = false;

    public boolean isTrimValues()
    {
        return this.trimValues;
    }

    public TextExportOptions setTrimValues(final boolean trimValues)
    {
        this.trimValues = trimValues;

        return this;
    }

    public String getDelimiter()
    {
        return this.delimiter;
    }

    public TextExportOptions setDelimiter(final String delimiter)
    {
        this.delimiter = delimiter;
        return this;
    }

}
