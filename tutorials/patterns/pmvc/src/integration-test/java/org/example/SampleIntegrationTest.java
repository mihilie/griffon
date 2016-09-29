/*
 * Copyright 2016 the original author or authors.
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
package org.example;

import griffon.core.injection.Module;
import griffon.core.mvc.MVCGroup;
import griffon.core.mvc.MVCGroupManager;
import griffon.core.test.GriffonUnitRule;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.codehaus.griffon.runtime.core.injection.AbstractTestingModule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.util.List;

import static org.awaitility.Awaitility.await;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

@RunWith(JUnitParamsRunner.class)
public class SampleIntegrationTest {
    static {
        // force initialization JavaFX Toolkit
        new javafx.embed.swing.JFXPanel();
    }

    @Rule
    public final GriffonUnitRule griffon = new GriffonUnitRule();

    @Inject private MVCGroupManager mvcGroupManager;

    private MVCGroup group;

    @Before
    public void setup() {
        group = mvcGroupManager.createMVCGroup("sample");
    }

    @After
    public void cleanup() {
        if (group != null) {
            group.destroy();
        }
    }

    @Test
    @Parameters({",Howdy stranger!",
        "Test, Hello Test"})
    public void sayHelloAction(String input, String output) {
        // given:
        SampleModel model = mvcGroupManager.findModel("sample", SampleModel.class);
        SampleController controller = mvcGroupManager.findController("sample", SampleController.class);

        // expect:
        assertThat(model.getOutput(), nullValue());
        // when:
        model.setInput(input);
        controller.invokeAction("sayHello");

        // then:
        await().until(() -> model.getOutput(), notNullValue());
        assertThat(model.getOutput(), equalTo(output));
    }

    @Nonnull
    private List<Module> moduleOverrides() {
        return asList(new AbstractTestingModule() {
            @Override
            protected void doConfigure() {
                bind(SampleView.class)
                    .toProvider(() -> mock(SampleView.class));
            }
        });
    }
}