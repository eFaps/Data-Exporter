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
package org.efaps.dataexporter.output.tree;

public class TreeExportStyle
{

    public static TreeExportStyle CLASSIC = new TreeExportStyle("", "+-- ", null, "|-- ", "'-- ", "|-- ", "|  ", "   ");
    public static TreeExportStyle EXTENDED_ASCII = new TreeExportStyle(new String(new char[] { 196 }), null, null,
                    new String(new char[] { 195, 196, 196 }), new String(new char[] { 192, 196, 196 }), new String(
                                    new char[] { 195, 196, 196 }), "|  ", "   ");
    // public static TreeExportStyle CLASSIC_NO_CONNECTOR = new
    // TreeExportStyle("+-- ", "|-- ", " ", " ");
    // public static TreeExportStyle MAVEN = new TreeExportStyle("", "+-- ",
    // "\\-- ", "+-- ", "| ", " ");

    private String rootNodePrefix = null;
    private String parentNodePrefix = null;
    private String firstNodePrefix = null;
    private String lastNodePrefix = null;
    private String otherNodesPrefix = null;
    private String levelSeparator = null;
    private String lastLevelSeparator = null;
    private String parentNodeSuffix = null;

    public TreeExportStyle(final String rootNodePrefix,
                           final String parentNodePrefix,
                           final String parentNodeSuffix,
                           final String firstNodePrefix,
                           final String lastNodePrefix,
                           final String otherNodesPrefix,
                           final String levelSeparator,
                           final String lastLevelSeparator)
    {
        super();
        this.rootNodePrefix = rootNodePrefix;
        this.parentNodePrefix = parentNodePrefix;
        this.parentNodeSuffix = parentNodeSuffix;
        this.firstNodePrefix = firstNodePrefix;
        this.lastNodePrefix = lastNodePrefix;
        this.otherNodesPrefix = otherNodesPrefix;
        this.levelSeparator = levelSeparator;
        this.lastLevelSeparator = lastLevelSeparator;
    }

    public String getRootNodePrefix()
    {
        return this.rootNodePrefix;
    }

    public void setRootNodePrefix(final String rootNodePrefix)
    {
        this.rootNodePrefix = rootNodePrefix;
    }

    public String getFirstNodePrefix()
    {
        return this.firstNodePrefix;
    }

    public void setFirstNodePrefix(final String firstNodePrefix)
    {
        this.firstNodePrefix = firstNodePrefix;
    }

    public String getLastNodePrefix()
    {
        return this.lastNodePrefix;
    }

    public void setLastNodePrefix(final String lastNodePrefix)
    {
        this.lastNodePrefix = lastNodePrefix;
    }

    public String getOtherNodesPrefix()
    {
        return this.otherNodesPrefix;
    }

    public void setOtherNodesPrefix(final String otherNodesPrefix)
    {
        this.otherNodesPrefix = otherNodesPrefix;
    }

    public String getLevelSeparator()
    {
        return this.levelSeparator;
    }

    public void setLevelSeparator(final String levelSeparator)
    {
        this.levelSeparator = levelSeparator;
    }

    public void setLastLevelSeparator(final String lastLevelSeparator)
    {
        this.lastLevelSeparator = lastLevelSeparator;
    }

    public String getLastLevelSeparator()
    {
        return this.lastLevelSeparator;
    }

    public String getParentNodePrefix()
    {
        return this.parentNodePrefix;
    }

    public void setParentNodePrefix(final String parentNodePrefix)
    {
        this.parentNodePrefix = parentNodePrefix;
    }

    public String getParentNodeSuffix()
    {
        return this.parentNodeSuffix;
    }

    public void setParentNodeSuffix(final String parentNodeSuffix)
    {
        this.parentNodeSuffix = parentNodeSuffix;
    }
}
