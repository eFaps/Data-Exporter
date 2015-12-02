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
package org.efaps.dataexporter.model;

import java.util.Date;

/**
 * Column which generates the current date time.
 * 
 * @author Santhosh Kumar
 */
public class CurrentDateTimeColumn extends DateColumn {

    public CurrentDateTimeColumn(String name, int width, AlignType align, String dateFormat) {
        super(name, null, width, align, dateFormat);
        setUpColumn();
    }

    public CurrentDateTimeColumn(String name, int width, String dateFormat) {
        super(name, width, dateFormat);
        setUpColumn();
    }
    
    private void setUpColumn() {
        setGeneratesOwnData(true);
        setCellValueGenerator(new CellValueGenerator() {
            @Override
            public Object generateCellValue(CellDetails cellDetails) {
                return new Date();
            }
        });
    }
}
