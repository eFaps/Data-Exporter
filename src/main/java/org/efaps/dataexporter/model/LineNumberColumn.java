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

/**
 * Column which outputs the current row number, starting from 1.
 *
 * @author Santhosh Kumar
 */
public class LineNumberColumn
    extends NumberColumn
{

    public LineNumberColumn(final String name,
                            final int width)
    {
        this(name, null, width);
    }

    public LineNumberColumn(final String name,
                            final String title,
                            final int width)
    {
        super(name, title, width, 0);
        setGeneratesOwnData(true);
        setCellValueGenerator(cellDetails -> new Integer(cellDetails.getRowIndex() + 1));
    }
}
