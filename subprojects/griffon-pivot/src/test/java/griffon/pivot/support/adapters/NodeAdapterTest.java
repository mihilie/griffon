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
package griffon.pivot.support.adapters;

import griffon.core.CallableWithArgs;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class NodeAdapterTest {
    private final NodeAdapter adapter = new NodeAdapter();

    @Test
    public void testRangeInserted() {
        final boolean[] invoked = new boolean[1];
        CallableWithArgs<Void> callable = args -> {
            invoked[0] = true;
            return null;
        };

        assertNull(adapter.getRangeInserted());
        adapter.rangeInserted(null, 0, 0);
        assertFalse(invoked[0]);

        adapter.setRangeInserted(callable);
        adapter.rangeInserted(null, 0, 0);
        assertTrue(invoked[0]);
    }

    @Test
    public void testRangeRemoved() {
        final boolean[] invoked = new boolean[1];
        CallableWithArgs<Void> callable = args -> {
            invoked[0] = true;
            return null;
        };

        assertNull(adapter.getRangeRemoved());
        adapter.rangeRemoved(null, 0, 0);
        assertFalse(invoked[0]);

        adapter.setRangeRemoved(callable);
        adapter.rangeRemoved(null, 0, 0);
        assertTrue(invoked[0]);
    }

    @Test
    public void testNodeInserted() {
        final boolean[] invoked = new boolean[1];
        CallableWithArgs<Void> callable = args -> {
            invoked[0] = true;
            return null;
        };

        assertNull(adapter.getNodeInserted());
        adapter.nodeInserted(null, 0);
        assertFalse(invoked[0]);

        adapter.setNodeInserted(callable);
        adapter.nodeInserted(null, 0);
        assertTrue(invoked[0]);
    }

    @Test
    public void testNodesRemoved() {
        final boolean[] invoked = new boolean[1];
        CallableWithArgs<Void> callable = args -> {
            invoked[0] = true;
            return null;
        };

        assertNull(adapter.getNodesRemoved());
        adapter.nodesRemoved(null, null, 0);
        assertFalse(invoked[0]);

        adapter.setNodesRemoved(callable);
        adapter.nodesRemoved(null, null, 0);
        assertTrue(invoked[0]);
    }

    @Test
    public void testOffsetChanged() {
        final boolean[] invoked = new boolean[1];
        CallableWithArgs<Void> callable = args -> {
            invoked[0] = true;
            return null;
        };

        assertNull(adapter.getOffsetChanged());
        adapter.offsetChanged(null, 0);
        assertFalse(invoked[0]);

        adapter.setOffsetChanged(callable);
        adapter.offsetChanged(null, 0);
        assertTrue(invoked[0]);
    }

    @Test
    public void testParentChanged() {
        final boolean[] invoked = new boolean[1];
        CallableWithArgs<Void> callable = args -> {
            invoked[0] = true;
            return null;
        };

        assertNull(adapter.getParentChanged());
        adapter.parentChanged(null, null);
        assertFalse(invoked[0]);

        adapter.setParentChanged(callable);
        adapter.parentChanged(null, null);
        assertTrue(invoked[0]);
    }

}
