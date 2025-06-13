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
package org.efaps.dataexporter.output.texttable;

import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

public class TestPojos
{

    // The package to test
    private static final String POJO_PACKAGE = TestPojos.class.getPackage().getName();

    private List<PojoClass> pojoClasses;
    private Validator pojoValidator;

    @BeforeTest
    public void setup()
    {
        this.pojoClasses = PojoClassFactory.getPojoClasses(POJO_PACKAGE, pojoClass -> {
            System.out.println(pojoClass.getName());
            return pojoClass.getName().endsWith("Style");
        });

        this.pojoValidator = ValidatorBuilder.create()
                        .with(new SetterTester())
                        .with(new GetterTester())
                        .build();
    }

    @Test
    public void testPojos()
    {
        this.pojoValidator.validate(this.pojoClasses);
    }
}
