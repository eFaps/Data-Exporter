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

/**
 * Bean contains the details of row being written like row index, actual row
 * and height of the row.
 *
 * @author Santhosh Kumar
 */
public class RowDetails
{

    private Table table = null;
    private int rowIndex = 0;
    private Row row = null;
    private int rowHeight = 1;

    public RowDetails()
    {
        // do nothing
    }

    public RowDetails(final Table table,
                      final int rowIndex,
                      final Row row)
    {
        super();
        this.table = table;
        this.rowIndex = rowIndex;
        this.row = row;
    }

    public Table getTable()
    {
        return this.table;
    }

    public void setTable(final Table table)
    {
        this.table = table;
    }

    public int getRowHeight()
    {
        return this.rowHeight;
    }

    public void setRowHeight(final int rowHeight)
    {
        this.rowHeight = rowHeight;
    }

    public int getRowIndex()
    {
        return this.rowIndex;
    }

    public void setRowIndex(final int rowIndex)
    {
        this.rowIndex = rowIndex;
    }

    public Row getRow()
    {
        return this.row;
    }

    public void setRow(final Row row)
    {
        this.row = row;
    }
}
