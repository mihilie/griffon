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
package griffon.core.editors

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import java.beans.PropertyEditor

@Unroll
class URLPropertyEditorSpec extends Specification {
    @Shared
    private URL url = 'http://localhost'.toURL()

    void "URL literal '#literal' should be equal to #value"() {
        setup:

        PropertyEditor editor = new URLPropertyEditor()

        when:
        editor.value = literal

        then:

        value == editor.value

        where:
        literal                    | value
        null                       | null
        ''                         | null
        ' '                        | null
        'http://localhost'         | 'http://localhost'.toURL()
        new File('/').absoluteFile | new File('/').absoluteFile.toURI().toURL()
        url                        | url
    }

    void "Invalid url literal '#literal'"() {
        setup:

        PropertyEditor editor = new URLPropertyEditor()

        when:
        editor.value = literal

        then:

        thrown(IllegalArgumentException)

        where:
        literal << [
            'garbage',
            [],
            [1, 2, 3],
            [:],
            [key: 'value'],
            new Object()
        ]
    }
}
