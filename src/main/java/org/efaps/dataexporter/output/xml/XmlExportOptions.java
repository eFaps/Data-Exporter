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
package org.efaps.dataexporter.output.xml;

import org.efaps.dataexporter.ExportOptions;

/**
 * Various options that can be set while exporting to xml.
 *
 * @author Santhosh Kumar
 */
public class XmlExportOptions
    extends ExportOptions
{

    private boolean prettyPrint = false;

    public boolean isPrettyPrint()
    {
        return this.prettyPrint;
    }

    /**
     * Indicates if xml output should be formatted with indentation and new
     * lines.
     */
    public XmlExportOptions setPrettyPrint(final boolean prettyPrint)
    {
        this.prettyPrint = prettyPrint;
        return this;
    }
}
