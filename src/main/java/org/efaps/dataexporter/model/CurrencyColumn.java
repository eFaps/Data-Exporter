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
 * Currency column, which formats the given number with 2 digits precision and
 * prefixes
 * the given currency symbol.
 *
 * @author Santhosh Kumar
 *
 */
public class CurrencyColumn
    extends NumberColumn
{

    private String currencySign;

    public CurrencyColumn(final String name,
                          final String title,
                          final int width,
                          final String currencySign)
    {
        this(name, title, width, AlignType.MIDDLE_RIGHT, currencySign);
    }

    public CurrencyColumn(final String name,
                          final int width,
                          final String currencySign)
    {
        this(name, null, width, AlignType.MIDDLE_RIGHT, currencySign);
    }

    public CurrencyColumn(final String name,
                          final String title,
                          final int width,
                          final AlignType align,
                          final String currencySign)
    {
        super(name, title, width, align, 2);
        this.currencySign = currencySign;
    }

    public String getCurrencySign()
    {
        return this.currencySign;
    }

    public void setCurrencySign(final String currencySign)
    {
        this.currencySign = currencySign;
    }

    @Override
    public int getMaxRowHeight(final CellDetails cellDetails)
    {
        return super.getMaxRowHeight(this.currencySign + cellDetails.getCellValue());
    }

    @Override
    public String format(final CellDetails cellDetails)
    {
        return this.currencySign + format(cellDetails.getCellValue());
    }
}
