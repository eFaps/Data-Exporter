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

public class CellDetails
    extends RowDetails
{

    private int columnIndex = -1;
    private Object cellValue = null;
    private AlignType cellAlign = null;
    private Column column = null;

    public CellDetails()
    {
        // do nothing
    }

    public CellDetails(final RowDetails rowDetails,
                       final int columnIndex)
    {
        this.columnIndex = columnIndex;
        setTable(rowDetails.getTable());
        setRow(rowDetails.getRow());
        setRowHeight(rowDetails.getRowHeight());
        setRowIndex(rowDetails.getRowIndex());
    }

    public AlignType getCellAlign()
    {
        if (this.cellAlign == null) {
            this.cellAlign = getColumn().getAlign();
        }
        return this.cellAlign;
    }

    public void setCellAlign(final AlignType cellAlign)
    {
        this.cellAlign = cellAlign;
    }

    public int getColumnIndex()
    {
        return this.columnIndex;
    }

    public void setColumnIndex(final int columnIndex)
    {
        this.columnIndex = columnIndex;
    }

    public Object getCellValue()
    {
        return this.cellValue;
    }

    public void setCellValue(final Object defaultCellValue)
    {
        this.cellValue = defaultCellValue;
    }

    public Column getColumn()
    {
        if (this.column == null) {
            return getTable().getColumns().get(this.columnIndex);
        }

        return this.column;
    }

    public void setColumn(final Column column)
    {
        this.column = column;
    }
}
