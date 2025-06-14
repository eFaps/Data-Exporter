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

import org.apache.commons.beanutils.PropertyUtils;
import org.efaps.dataexporter.DataExportException;

public class BeanRow
    extends Row
{

    private Object bean = null;

    public BeanRow(final Object bean)
    {
        super();
        this.bean = bean;
    }

    public Object getCellValue(final String columnName)
    {
        try {
            return PropertyUtils.getProperty(this.bean, columnName);
        } catch (final Exception e) {
            throw new DataExportException("Exception while reading the property " + columnName + " from bean "
                            + this.bean + " of type " + this.bean.getClass().getName(), e);
        }
    }

    public Object getBean()
    {
        return this.bean;
    }
}
