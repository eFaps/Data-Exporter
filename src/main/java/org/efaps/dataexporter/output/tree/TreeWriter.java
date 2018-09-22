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

package org.efaps.dataexporter.output.tree;

import java.io.OutputStream;
import java.io.Writer;
import java.util.List;

import org.efaps.dataexporter.AbstractDataWriter;
import org.efaps.dataexporter.model.CellDetails;
import org.efaps.dataexporter.model.Row;
import org.efaps.dataexporter.model.RowDetails;

/**
 * The Class TreeWriter.
 */
public class TreeWriter
    extends AbstractDataWriter
{

    /**
     * Instantiates a new tree writer.
     *
     * @param options the options
     */
    public TreeWriter(final TreeExportOptions _options)
    {
        this(_options, System.out);
    }

    /**
     * Instantiates a new tree writer.
     *
     * @param _out the _out
     */
    public TreeWriter(final OutputStream _out)
    {
        this(new TreeExportOptions(), _out);
    }

    /**
     * Instantiates a new tree writer.
     *
     * @param _out the _out
     */
    public TreeWriter(final Writer _out)
    {
        this(new TreeExportOptions(), _out);
    }

    /**
     * Instantiates a new tree writer.
     *
     * @param _options the _options
     * @param _out the _out
     */
    public TreeWriter(final TreeExportOptions _options,
                      final OutputStream _out)
    {
        super(_options, _out);
    }

    /**
     * Instantiates a new tree writer.
     *
     * @param _options the _options
     * @param _out the _out
     */
    public TreeWriter(final TreeExportOptions _options,
                      final Writer _out)
    {
        super(_options, _out);
    }

    /**
     * Gets the tree export options.
     *
     * @return the tree export options
     */
    public TreeExportOptions getTreeExportOptions()
    {
        return (TreeExportOptions) getOptions();
    }

    @Override
    public void writeRow(final RowDetails _rowDetails)
    {
        printTreeNode(_rowDetails, "", true, true, true);
    }

    /**
     * Prints the tree node.
     *
     * @param _rowDetails the _row details
     * @param _prefix the _prefix
     * @param _isRoot the _is root
     * @param _isHead the _is head
     * @param _isTail the _is tail
     */
    private void printTreeNode(final RowDetails _rowDetails, final String _prefix, final boolean _isRoot,
                               final boolean _isHead, final boolean _isTail)
    {

        final Row row = _rowDetails.getRow();
        String nodePrefix = null;
        String nodeSuffix = "";
        if (_isRoot) {
            nodePrefix = getStyle().getRootNodePrefix();

        } else if (row.getChildren() != null && !row.getChildren().isEmpty() && getStyle()
                        .getParentNodePrefix() != null) {
            nodePrefix = getStyle().getParentNodePrefix();

        } else if (_isHead) {
            nodePrefix = getStyle().getFirstNodePrefix();

        } else if (_isTail) {
            nodePrefix = getStyle().getLastNodePrefix();

        } else {
            nodePrefix = getStyle().getOtherNodesPrefix();
        }

        if (row.getChildren() != null && !row.getChildren().isEmpty() && getStyle().getParentNodeSuffix() != null) {
            nodeSuffix = getStyle().getParentNodeSuffix();
        }

        final StringBuilder val = new StringBuilder();
        boolean first = true;
        for (int i = 0; i < row.getCellValues().size(); i++) {
            if (first) {
                first = false;
            } else {
                val.append(" ").append("|").append(" ");
            }
            final CellDetails cellDetails = new CellDetails(_rowDetails, i);
            cellDetails.setCellValue(_rowDetails.getRow().getCellValue(cellDetails));
            val.append(cellDetails.getCellValue());
        }
        println(_prefix + nodePrefix + val + nodeSuffix);

        final List<Row> children = row.getChildren();
        if (children != null && !children.isEmpty()) {
            for (int i = 0; i < children.size() - 1; i++) {
                final Row child = children.get(i);
                final RowDetails rowDetails = new RowDetails(_rowDetails.getTable(), this.rowIndex.getAndIncrement(),
                                child);
                printTreeNode(rowDetails, _prefix + (_isTail ? getStyle().getLastLevelSeparator()
                                : getStyle().getLevelSeparator()), false, i == 0, false);
            }
            if (children.size() >= 1) {
                final RowDetails rowDetails = new RowDetails(_rowDetails.getTable(), this.rowIndex.getAndIncrement(),
                                children.get(children.size() - 1));
                printTreeNode(rowDetails, _prefix + (_isTail ? getStyle().getLastLevelSeparator()
                                : getStyle().getLevelSeparator()), false, false, true);
            }
        }
    }

    /**
     * Gets the style.
     *
     * @return the style
     */
    private TreeExportStyle getStyle()
    {
        return getTreeExportOptions().getStyle();
    }

}
