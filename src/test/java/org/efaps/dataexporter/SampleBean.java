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
package org.efaps.dataexporter;

import java.time.LocalDateTime;

public class SampleBean
{

    private LocalDateTime datePurchased = null;
    private int itemNo = 0;
    private String itemName = null;
    private boolean shipped = false;
    private int quantity = 0;
    private double unitPrice = 0.0;

    public SampleBean(final LocalDateTime datePurchased,
                      final int itemNum,
                      final String itemName,
                      final boolean shipped,
                      final int quantity,
                      final double unitPrice)
    {
        super();
        this.datePurchased = datePurchased;
        this.itemNo = itemNum;
        this.itemName = itemName;
        this.shipped = shipped;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public LocalDateTime getDatePurchased()
    {
        return this.datePurchased;
    }

    public void setDatePurchased(final LocalDateTime datePurchased)
    {
        this.datePurchased = datePurchased;
    }

    public int getItemNo()
    {
        return this.itemNo;
    }

    public void setItemNo(final int itemNum)
    {
        this.itemNo = itemNum;
    }

    public String getItemName()
    {
        return this.itemName;
    }

    public void setItemName(final String itemName)
    {
        this.itemName = itemName;
    }

    public boolean isShipped()
    {
        return this.shipped;
    }

    public void setShipped(final boolean shipped)
    {
        this.shipped = shipped;
    }

    public int getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(final int quantity)
    {
        this.quantity = quantity;
    }

    public double getUnitPrice()
    {
        return this.unitPrice;
    }

    public void setUnitPrice(final double unitPrice)
    {
        this.unitPrice = unitPrice;
    }
}
