/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2008-2018 the original author or authors.
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
package editor;

import griffon.annotations.core.Nonnull;
import griffon.annotations.core.Nullable;
import griffon.annotations.inject.MVCMember;
import griffon.core.artifact.GriffonController;
import griffon.core.controller.ControllerAction;
import griffon.util.CollectionUtils;
import org.codehaus.griffon.runtime.core.artifact.AbstractGriffonController;
import org.kordamp.jipsy.ServiceProviderFor;

import javax.application.threading.Threading;
import java.io.File;

import static griffon.util.GriffonNameUtils.isNotBlank;

@ServiceProviderFor(GriffonController.class)
public class ContainerController extends AbstractGriffonController {
    @MVCMember @Nonnull
    private ContainerModel model;
    @MVCMember @Nonnull
    private ContainerView view;

    @ControllerAction
    @Threading(Threading.Policy.SKIP)
    public void open() {
        File file = view.selectFile();
        if (file != null) {
            String mvcIdentifier = file.getName() + "-" + System.currentTimeMillis();
            createMVC("editor", mvcIdentifier, CollectionUtils.<String, Object>map()
                .e("document", new Document(file, file.getName()))
                .e("tabName", file.getName()));
        }
    }

    @ControllerAction
    public void save() {
        EditorController controller = resolveEditorController();
        if (controller != null) {
            controller.saveFile();
        }
    }

    @ControllerAction
    public void close() {
        EditorController controller = resolveEditorController();
        if (controller != null) {
            controller.closeFile();
        }
    }

    @ControllerAction
    public void quit() {
        getApplication().shutdown();
    }

    @Nullable
    private EditorController resolveEditorController() {
        if (isNotBlank(model.getMvcIdentifier())) {
            return getApplication().getMvcGroupManager()
                .findController(model.getMvcIdentifier(), EditorController.class);
        }
        return null;
    }
}