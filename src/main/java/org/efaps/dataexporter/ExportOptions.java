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
package org.efaps.dataexporter;

import org.efaps.dataexporter.util.Util;

/**
 * Base options applicable for all exporters.
 *
 * @author Santhosh Kumar
 */
public class ExportOptions {

    private LineSeparatorType lineSeparator = LineSeparatorType.NATIVE;
    private boolean printHeaders = true;
    private boolean escapeHtml = false;
    private String nullString = "";

    public String getNullString() {
        return this.nullString;
    }

    /**
     * The string to be used for exporting if any of the row cells values are <code>null</code>.
     * Default is empty string.
     *
     * @param nullString the string to be used if any of the cells are null. Cannot be <code>null</code>.
     * @return the this instance of export options for method chaining.
     */
    public ExportOptions setNullString(final String nullString) {
        Util.checkForNotNull(nullString, "nullString");

        this.nullString = nullString;

        return this;
    }

    public boolean isEscapeHtml() {
        return this.escapeHtml;
    }

    /**
     * If set, all html unsafe characters are escaped. This is most useful if you are going to
     * show the exported data in an html. Default is <code>false</code>
     *
     * @param escapeHtml
     * @return the this instance of export options for method chaining.
     */
    public ExportOptions setEscapeHtml(final boolean escapeHtml) {
        this.escapeHtml = escapeHtml;

        return this;
    }

    public boolean isPrintHeaders() {
        return this.printHeaders;
    }

    /**
     * Enables or disables displaying the headers
     *
     * @param printHeaders boolean to enable/disable the headers.
     * @return the this instance of export options for method chaining.
     */
    public ExportOptions setPrintHeaders(final boolean printHeaders) {
        this.printHeaders = printHeaders;
        return this;
    }

    public LineSeparatorType getLineSeparator() {
        return this.lineSeparator;
    }

    public void setLineSeparator(final LineSeparatorType lineSeparator) {
        this.lineSeparator = lineSeparator;
    }

    public String getLineSeparatorString() {
        switch(this.lineSeparator) {
            case UNIX:
                return "\n";

            case WINDOWS:
                return "\r\n";

            default:
                String separator = System.getProperty("line.separator");
                if (separator == null) {
                    separator = "\r\n";
                }
                return separator;
        }
    }

}
