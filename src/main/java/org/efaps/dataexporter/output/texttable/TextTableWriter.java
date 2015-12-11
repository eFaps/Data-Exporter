/*
 * #%L
 * data-exporter
 * %%
 * Copyright (C) 2012 - 2013 http://www.brsanthu.com
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.efaps.dataexporter.output.texttable;

import static org.efaps.dataexporter.util.Util.*;

import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.efaps.dataexporter.AbstractDataWriter;
import org.efaps.dataexporter.TextAligner;
import org.efaps.dataexporter.model.AlignType;
import org.efaps.dataexporter.model.CellDetails;
import org.efaps.dataexporter.model.Column;
import org.efaps.dataexporter.model.DataExporterCallback;
import org.efaps.dataexporter.model.RowDetails;
import org.efaps.dataexporter.model.Table;

public class TextTableWriter extends AbstractDataWriter {

    private List<Column> columns;

    public TextTableWriter(final TextTableExportOptions options) {
        this(options, System.out);
    }

    public TextTableWriter(final OutputStream out) {
        this(new TextTableExportOptions(), out);
    }

    public TextTableWriter(final Writer out) {
        this(new TextTableExportOptions(), out);
    }

    public TextTableWriter(final TextTableExportOptions options, final OutputStream out) {
        super(options, out);
    }

    public TextTableWriter(final TextTableExportOptions options, final Writer out) {
        super(options, out);
    }

    public TextTableExportOptions getTextTableExportOptions() {
        return (TextTableExportOptions) getOptions();
    }

    @Override
    public void writeHeader(final Table table) {
        this.columns = table.getColumns();

        final TextTableExportOptions options = getTextTableExportOptions();

        if (options.isPrintHeaders()) {
            //Render the top border
            printTopBorder();

            //Format header into multiple lines and render with dividers and separators.
            printHeaderCells(formatHeaderCells());
        }

        //Render the top border
        printTopDownBorder();
    }

    @Override
    public void writeRow(final RowDetails rowDetails) {

        //If repeat header after rows is specified, and if that condition
        //is come, print the headers.
        if (getTextTableExportOptions().getRepeatHeadersAfterRows() > 0) {
            if (rowDetails.getRowIndex() != 0 && rowDetails.getRowIndex() % getTextTableExportOptions().getRepeatHeadersAfterRows() == 0) {
                printBottomBorder();
                println();
                writeHeader(rowDetails.getTable());
            }
        }

        //Generate all row data as required.
        generateRowData(rowDetails);

        final DataExporterCallback callback = rowDetails.getTable().getCallback();
        if (callback != null) {
            callback.beforeRow(rowDetails);
        }

        //Format the row into cells
        final List<List<String>> rowCells = formatRowCells(rowDetails);

        //Render left row divider
        printLine(getStyle().getCenterLeftDivider(), getStyle().getCenterLeftRightDivider(),
            getStyle().getCenterCenterDivider(), getStyle().getCenterRightLeftDivider(),
            getStyle().getCenterRightDivider(), rowCells);

        if (callback != null) {
            callback.afterRow(rowDetails);
        }
    }


    @Override
    public void afterTable(final Table table) {
        //Render the final border
        printBottomBorder();
    }

    /**
     * Format row cells.
     *
     * @param _rowDetails the row details
     * @return the list< list< string>>
     */
    public List<List<String>> formatRowCells(final RowDetails _rowDetails) {

        final DataExporterCallback callback = _rowDetails.getTable().getCallback();

        final int maxRowHeight = Math.max(getTextTableExportOptions().getMinRowHeight(), getMaxRowHeight(_rowDetails));

        final List<List<String>> rowLines = new ArrayList<List<String>>();
        for (int j = 0; j < maxRowHeight; j++) {
            rowLines.add(new ArrayList<String>());
        }

        for (int columnIndex = 0; columnIndex < this.columns.size(); columnIndex++) {
            final Column column = this.columns.get(columnIndex);

            final CellDetails cellDetails = new CellDetails(_rowDetails, columnIndex);
            cellDetails.setRowHeight(maxRowHeight);
            cellDetails.setCellValue(_rowDetails.getRow().getCellValue(cellDetails));
            cellDetails.setCellAlign(cellDetails.getColumn().getAlign());

            if (callback != null) {
                callback.beforeCell(cellDetails);
            }

            final List<String> cells = align(cellDetails, column.format(cellDetails), " ");
            for (int j = 0; j < maxRowHeight; j++) {
                rowLines.get(j).add(cells.get(j));
            }

            if (callback != null) {
                callback.afterCell(cellDetails);
            }
        }
        return rowLines;
    }


    /**
     * Align.
     *
     * @param _cellDetails the cell details
     * @param _cellData the cell data
     * @param _filler the filler
     * @return the list< string>
     */
    public List<String> align(final CellDetails _cellDetails,
                              final String _cellData,
                              final String _filler)
    {
        final TextAligner textAligner = new TextAligner();
        textAligner.setEvaluateForLineBreaks(true);
        AlignType alignOverride = _cellDetails.getCellAlign();

        if (alignOverride == null) {
            alignOverride = _cellDetails.getColumn().getAlign();
        }
        return textAligner.align(_cellDetails.getColumn().getWidth(), _cellDetails.getRowHeight(), alignOverride,
                        _cellData, _filler);
    }

    /**
     * Gets the max row height.
     *
     * @param _rowDetails the row details
     * @return the max row height
     */
    public int getMaxRowHeight(final RowDetails _rowDetails)
    {
        int height = 1;
        final TextAligner textAligner = new TextAligner();
        textAligner.setEvaluateForLineBreaks(true);
        for (int columnIndex = 0; columnIndex < this.columns.size(); columnIndex++) {
            final CellDetails cellDetails = new CellDetails(_rowDetails, columnIndex);
            final Column column = this.columns.get(columnIndex);

            Object cellValue = null;
            if (column.isGeneratesOwnData()) {
                cellValue = column.getCellValueGenerator().generateCellValue(cellDetails);
            } else {
                cellValue = _rowDetails.getRow().getCellValue(cellDetails);
            }
            cellDetails.setCellValue(cellValue);
            height = Math.max(height, textAligner.evaluateRowHeight(cellDetails.getColumn().getWidth(), String.valueOf(
                            cellDetails.getCellValue()), cellDetails.getCellAlign()));
        }
        return height;
    }

    protected void printTopBorder() {
        printLine(getStyle().getTopLeftIntersection(), getStyle().getTopRightIntersection(),
            getStyle().getTopCenterIntersection(), getStyle().getTopRightLeftIntersection(),
            getStyle().getTopRightIntersection(), getStyle().getTopBorder());
    }

    public void printTopDownBorder() {
        printLine(getStyle().getTopDownLeftIntersection(), getStyle().getTopDownRightIntersection(),
            getStyle().getTopDownCenterIntersection(), getStyle().getTopDownRightLeftIntersection(),
            getStyle().getTopDownRightIntersection(), getStyle().getTopDownBorder());
    }

    public void printBottomBorder() {
        printLine(getStyle().getBottomLeftIntersection(), getStyle().getBottomRightIntersection(),
            getStyle().getBottomCenterIntersection(), getStyle().getBottomRightLeftIntersection(),
            getStyle().getBottomRightIntersection(), getStyle().getBottomBorder());
    }

    public void printHeaderCells(final List<List<String>> headerLines) {
        printLine(getStyle().getTopLeftDivider(), getStyle().getTopRightDivider(), getStyle().getTopCenterDivider(),
            getStyle().getTopRightLeftDivider(), getStyle().getTopRightDivider(), headerLines);
    }

    public void printLine(final String left, final String leftRight, final String center,
                    final String rightLeft, final String right, final List<List<String>> cells) {
        for (final List<String> rowLine : cells) {
            printLine(left, leftRight, center, rightLeft, right, rowLine, null);
        }
    }

    public void printLine(final String left, final String leftRight, final String center,
                    final String rightLeft, final String right, final String border) {
        printLine(left, leftRight, center, rightLeft, right, null, border);
    }

    public void printLine(final String left, final String leftRight, final String center,
                    final String rightLeft, final String right, final List<String> cellValues, String defaultValue) {

        if ("".equalsIgnoreCase(defaultValue)) {
            defaultValue = " ";
        }

        final StringBuilder sb = new StringBuilder();

        //Render left intersection
        sb.append(left);

        for (int i = 0; i < this.columns.size(); i++) {
            //Render the first column width using border char
            sb.append(cellValues!=null?cellValues.get(i):createString(defaultValue, this.columns.get(i).getWidth()));

            if (i == this.columns.size() - 1) {
                //Last column so print the right intersection
                sb.append(right);

            } else if (i == 0) {
                //If there are two columns, print the left right column and then right column
                sb.append(leftRight);

            } else if (i == this.columns.size() - 2) {
                //If there are three columns, print the left right column and then right column
                sb.append(rightLeft);

            } else {
                sb.append(center);
            }
        }

        //If trimmed buffer is empty, just skip the line.
        if (sb.toString().trim().length() != 0) {
            print(sb.toString());
            println();
        }
    }

    public List<List<String>> formatHeaderCells() {

        int maxHeaderHeight = 0;
        for (final Column column : this.columns) {
            maxHeaderHeight = Math.max(maxHeaderHeight, Column.getMaxRowHeight(column.getWidth(), column.getTitle()));
        }

        //Init the header lines array which would store the formatted/aligned strings
        final List<List<String>> headerLines = new ArrayList<List<String>>();
        for (int j = 0; j < maxHeaderHeight; j++) {
            headerLines.add(new ArrayList<String>());
        }

        for (int i = 0; i < this.columns.size(); i++) {

            final Column column = this.columns.get(i);
            AlignType align = getTextTableExportOptions().getHeaderAlignment();
            if (align == null) {
                align = column.getAlign();
            }

            final List<String> cells = Column.align(column.getWidth(), maxHeaderHeight, align, column.getTitle());
            for (int j = 0; j < maxHeaderHeight; j++) {
                headerLines.get(j).add(cells.get(j));
            }
        }

        return headerLines;
    }

    protected TextTableExportStyle getStyle() {
        return getTextTableExportOptions().getStyle();
    }

}
