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

import org.efaps.dataexporter.ExportOptions;

public class JsonExportOptions
    extends ExportOptions
{

    private boolean prettyPrint = false;
    private boolean doubleEscape = false;

    public boolean isDoubleEscape()
    {
        return this.doubleEscape;
    }

    public JsonExportOptions setDoubleEscape(final boolean doubleEscape)
    {
        this.doubleEscape = doubleEscape;

        return this;
    }

    public boolean isPrettyPrint()
    {
        return this.prettyPrint;
    }

    /**
     * Indicates if json output should be formatted with indentation and new
     * lines.
     */
    public JsonExportOptions setPrettyPrint(final boolean prettyPrint)
    {
        this.prettyPrint = prettyPrint;
        return this;
    }
}
