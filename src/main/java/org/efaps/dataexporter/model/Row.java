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
package org.efaps.dataexporter.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Data row being exported.
 *
 * @author Santhosh Kumar
 */
public class Row
{

    private List<Object> cells = new ArrayList<>();
    private List<Row> children = null;

    public Row()
    {
        // Default Constructor
    }

    public Row(final Object... rowValues)
    {
        add(rowValues);
    }

    public Row(final List<? extends Object> rowValues)
    {
        if (rowValues == null) {
            throw new IllegalArgumentException("Parameter rowValues cannot be null");
        }

        for (final Object object : rowValues) {
            add(object);
        }
    }

    public Row add(final Object... rowValues)
    {
        if (rowValues == null) {
            throw new IllegalArgumentException("Parameter rowValues cannot be null");
        }

        for (final Object value : rowValues) {
            this.cells.add(value);
        }

        return this;
    }

    public Object getCellValue(final CellDetails cellDetails)
    {
        return this.cells.get(cellDetails.getColumnIndex());
    }

    public Object getCellValue(final int index)
    {
        return this.cells.get(index);
    }

    public void setCellValue(final int index, final Object value)
    {
        this.cells.set(index, value);
    }

    public void addCellValue(final Object value)
    {
        this.cells.add(value);
    }

    public void clearCellValues()
    {
        this.cells = new ArrayList<>();
    }

    public void setCellValues(final List<Object> cells)
    {
        this.cells = cells;
    }

    public List<Object> getCellValues()
    {
        return this.cells;
    }

    public List<Row> getChildren()
    {
        return this.children;
    }

    public void setChildren(final List<Row> children)
    {
        this.children = children;
    }

    public void addChild(final Row child)
    {
        if (this.children == null) {
            this.children = new ArrayList<>();
        }

        this.children.add(child);
    }
}
