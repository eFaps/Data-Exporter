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

public class HeaderCellDetails {

    private Table table = null;
    private int columnIndex = -1;

    public HeaderCellDetails() {
        //Do nothing
    }

    public HeaderCellDetails(final Table table, final int columnIndex) {
        super();
        this.columnIndex = columnIndex;
        this.table = table;
    }


    public Table getTable() {
        return this.table;
    }

    public void setTable(final Table table) {
        this.table = table;
    }

    public int getColumnIndex() {
        return this.columnIndex;
    }
    public void setColumnIndex(final int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public Column getColumn() {
        return getTable().getColumns().get(this.columnIndex);
    }

}
