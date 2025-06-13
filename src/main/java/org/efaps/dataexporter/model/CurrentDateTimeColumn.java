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

import java.time.LocalDateTime;

/**
 * Column which generates the current date time.
 *
 * @author Santhosh Kumar
 */
public class CurrentDateTimeColumn
    extends DateColumn
{

    public CurrentDateTimeColumn(final String name,
                                 final int width,
                                 final AlignType align,
                                 final String dateFormat)
    {
        super(name, null, width, align, dateFormat);
        setUpColumn();
    }

    public CurrentDateTimeColumn(final String name,
                                 final int width,
                                 final String dateFormat)
    {
        super(name, width, dateFormat);
        setUpColumn();
    }

    private void setUpColumn()
    {
        setGeneratesOwnData(true);
        setCellValueGenerator(cellDetails -> LocalDateTime.now());
    }
}
