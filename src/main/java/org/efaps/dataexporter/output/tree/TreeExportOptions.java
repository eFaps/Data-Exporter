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

import org.efaps.dataexporter.ExportOptions;

public class TreeExportOptions extends ExportOptions {
    private TreeExportStyle style = TreeExportStyle.CLASSIC;
    
	public TreeExportStyle getStyle() {
		return style;
	}

	public void setStyle(TreeExportStyle style) {
		this.style = style;
	}
    
}
