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
package org.efaps.dataexporter.output.html;

import java.io.OutputStream;
import java.io.Writer;

import org.apache.commons.lang3.StringEscapeUtils;
import org.efaps.dataexporter.AbstractDataWriter;
import org.efaps.dataexporter.model.AlignType;
import org.efaps.dataexporter.model.CellDetails;
import org.efaps.dataexporter.model.HeaderCellDetails;
import org.efaps.dataexporter.model.RowDetails;
import org.efaps.dataexporter.model.Table;

public class HtmlWriter extends AbstractDataWriter {
    
    public HtmlWriter(HtmlExportOptions options) {
        super(options, System.out);
    }

    public HtmlWriter(HtmlExportOptions options, OutputStream out) {
        super(options, out);
    }
    
    public HtmlWriter(OutputStream out) {
        super(new HtmlExportOptions(), out);
    }

    public HtmlWriter(HtmlExportOptions options, Writer out) {
        super(options, out);
    }

    public HtmlWriter(Writer out) {
        super(new HtmlExportOptions(), out);
    }
    
    public HtmlExportOptions getHtmlExportOptions() {
        return (HtmlExportOptions) getOptions();
    }
    
    @Override
    public void beforeTable(Table table) {
        print("<html>");
        prettyPrint(1);
        print("<head><meta content=\"text/html;charset=UTF-8\"/></head>");
        prettyPrint(1);
        print("<body>");
        prettyPrint(2);
        print("<table border=1>");
    }
    
    @Override
    public void beforeHeaderRow(Table table) {
        prettyPrint(3);
        print("<tr>");
    }

    @Override
    public void beforeHeaderCell(HeaderCellDetails headerCell) {
        prettyPrint(4);
        print("<th>");
    }
    
    @Override
    public void writeHeaderCell(HeaderCellDetails headerCell) {
        print(headerCell.getColumn().getTitle());
    }
    
    @Override
    public void afterHeaderCell(HeaderCellDetails headerCell) {
        print("</th>");
    }
    
    @Override
    public void afterHeaderRow(Table table) {
        prettyPrint(3);
        print("</tr>");
    }

    @Override
    public void beforeRow(RowDetails rowDetails) {
        prettyPrint(3);
        print("<tr>");
    }
    
    @Override
    public void beforeRowCell(CellDetails cellDetails) {
        prettyPrint(4);
        
        if (getHtmlExportOptions().isAlignCells()) {
	        AlignType alignType = cellDetails.getColumn().getAlign();
	        
	        String style = "text-align:" + alignType.getHorizontalAlignment() + ";vertical-align:" + alignType.getVerticalAlignment();
	        print("<td style=\""+ style + "\">");
        } else {
        	print("<td>");
        }
    }
    
    @Override
    public void writeRowCell(CellDetails cellDetails) {
        print(StringEscapeUtils.escapeHtml4(cellDetails.getColumn().format(cellDetails)));
    }

    @Override
    public void afterRowCell(CellDetails cellDetails) {
        print("</td>");
    }
    
    @Override
    public void afterRow(RowDetails rowDetails) {
        prettyPrint(3);
        print("</tr>");
    }
    
    @Override
    public void afterTable(Table table) {
        prettyPrint(2);
        print("</table>");
        prettyPrint(1);
        print("</body>");
        prettyPrint(0);
        print("</html>");
    }
    
    private void prettyPrint(int level) {
        if (getHtmlExportOptions().isPrettyPrint()) {
            print("\n");
            for (int i = 0; i < level; i++) {
                print('\t');
            }
        }
    }
}
