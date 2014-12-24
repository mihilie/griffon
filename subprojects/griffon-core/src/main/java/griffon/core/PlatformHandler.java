/*
 * Copyright 2008-2015 the original author or authors.
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
package griffon.core;

import javax.annotation.Nonnull;

/**
 * A <code>PlatformHandler</code> is capable of tweaking the application
 * to match the expectations of the current platform so that it feels and
 * behaves native.
 *
 * @author Andres Almiray
 * @since 2.0.0
 */
public interface PlatformHandler {
    /**
     * Apply platform specific tweaks to the application.
     *
     * @param app the current application
     */
    void handle(@Nonnull GriffonApplication app);
}
