/*
 * Created on Oct 20, 2010
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * 
 * Copyright @2010-2011 the original author or authors.
 */
package org.assertj.core.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * Tests for <code>{@link Assertions#assertThat(AssertDelegateTarget)}</code>.
 * 
 * @author Christian Rösch
 */
public class Assertions_assertThat_with_AssertDelegateTarget_Test {

  @Test
  public void should_allow_wrapping_assertion_method_within_assertThat() {
    MyAssertDelegateTarget assertion = new MyAssertDelegateTarget(true);
    assertThat(assertion).isCompletelyTrue();

    Object result = assertThat(assertion);
    assertThat(result).isSameAs(assertion);
  }

  private static class MyAssertDelegateTarget implements AssertDelegateTarget {
    private boolean value;

    public MyAssertDelegateTarget(boolean v) {
      value = v;
    }

    void isCompletelyTrue() {
      assertThat(value).isTrue();
    }
  }
}
