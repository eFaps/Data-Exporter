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

package org.efaps.dataexporter.model;

import java.util.ArrayList;
import java.util.List;

public class Table
{

    private DataExporterCallback callback = null;
    private List<Column> columns = new ArrayList<>();

    public DataExporterCallback getCallback()
    {
        return this.callback;
    }

    public void setCallback(final DataExporterCallback callback)
    {
        this.callback = callback;
    }

    public List<Column> getColumns()
    {
        return this.columns;
    }

    public void setColumns(final List<Column> columns)
    {
        this.columns = columns;
    }

    public void addColumn(final Column column)
    {
        this.columns.add(column);
    }
}
