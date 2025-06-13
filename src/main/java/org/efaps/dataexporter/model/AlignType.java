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
 * Various alignment types.
 *
 * @author Santhosh Kumar
 */
public enum AlignType
{
    TOP_LEFT("top", "left"), TOP_CENTER("top", "center"), TOP_RIGHT("top", "right"), MIDDLE_LEFT("middle",
                    "left"), MIDDLE_CENTER("middle", "center"), MIDDLE_RIGHT("middle", "right"), BOTTOM_LEFT("bottom",
                                    "left"), BOTTOM_CENTER("bottom", "center"), BOTTOM_RIGHT("bottom", "right");

    private String horAlign = null;
    private String verAlign = null;

    private AlignType(final String verAlign,
                      final String horAlign)
    {
        this.verAlign = verAlign;
        this.horAlign = horAlign;
    }

    public String getHorizontalAlignment()
    {
        return this.horAlign;
    }

    public String getVerticalAlignment()
    {
        return this.verAlign;
    }

    public boolean isLeft()
    {
        return this.horAlign.equals("left");
    }

    public boolean isCenter()
    {
        return this.horAlign.equals("center");
    }

    public boolean isRight()
    {
        return this.horAlign.equals("right");
    }
}
