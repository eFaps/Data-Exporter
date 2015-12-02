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
package org.efaps.dataexporter.output.tree;

import java.io.OutputStream;
import java.io.Writer;
import java.util.List;

import org.efaps.dataexporter.AbstractDataWriter;
import org.efaps.dataexporter.model.Row;
import org.efaps.dataexporter.model.RowDetails;

public class TreeWriter extends AbstractDataWriter {
	
    public TreeWriter(TreeExportOptions options) {
        this(options, System.out);
    }

    public TreeWriter(OutputStream out) {
        this(new TreeExportOptions(), out);
    }

    public TreeWriter(Writer out) {
        this(new TreeExportOptions(), out);
    }
    
    public TreeWriter(TreeExportOptions options, OutputStream out) {
        super(options, out);
    }

    public TreeWriter(TreeExportOptions options, Writer out) {
        super(options, out);
    }
    
    public TreeExportOptions getTreeExportOptions() {
        return (TreeExportOptions) getOptions();
    }	
    
    @Override
    public void writeRow(RowDetails rowDetails) {
    	Row row = rowDetails.getRow();
    	printTreeNode("", true, true, true, row);
    }
    
	private void printTreeNode(String prefix, boolean isRoot, boolean isHead, boolean isTail, Row row) {
		
		String nodePrefix = null;
		String nodeSuffix = "";
		if (isRoot) {
			nodePrefix = getStyle().getRootNodePrefix(); 
			
		} else if (row.getChildren() != null && !row.getChildren().isEmpty() && getStyle().getParentNodePrefix() != null) {
			nodePrefix = getStyle().getParentNodePrefix(); 
			
		} else if (isHead) {
			nodePrefix = getStyle().getFirstNodePrefix();
			
		} else if (isTail) {
			nodePrefix = getStyle().getLastNodePrefix();
			
		} else {
			nodePrefix = getStyle().getOtherNodesPrefix();
		}
		
		if (row.getChildren() != null && !row.getChildren().isEmpty() && getStyle().getParentNodeSuffix() != null) {
			nodeSuffix = getStyle().getParentNodeSuffix();
		}
		
		println(prefix + nodePrefix + String.valueOf(row.getCellValue(0)) + nodeSuffix);
		
		List<Row> children = row.getChildren();
		if (children != null && !children.isEmpty()) {
			for (int i = 0; i < children.size() - 1; i++) {
				Row child = children.get(i);
				printTreeNode(prefix + (isTail ? getStyle().getLastLevelSeparator() : getStyle().getLevelSeparator()), false, i==0, false, child);
			}
			if (children.size() >= 1) {
				printTreeNode(prefix + (isTail ? getStyle().getLastLevelSeparator() : getStyle().getLevelSeparator()), false, false, true, children.get(children.size() - 1));
			}
		}
	}

	private TreeExportStyle getStyle() {
		return getTreeExportOptions().getStyle();
	}
    

}
