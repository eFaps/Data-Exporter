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

/**
 * Exception thrown by {@link DataExporter}
 *
 * @author Santhosh Kumar
 */
public class DataExportException
    extends RuntimeException
{

    private static final long serialVersionUID = 1L;

    public DataExportException()
    {
        super();
    }

    public DataExportException(final String message,
                               final Throwable cause)
    {
        super(message, cause);
    }

    public DataExportException(final String message)
    {
        super(message);
    }

    public DataExportException(final Throwable cause)
    {
        super(cause);
    }

}
