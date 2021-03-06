/*
 * Copyright (c) 2002-2021 Gargoyle Software Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gargoylesoftware.htmlunit.javascript.host.css;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.gargoylesoftware.htmlunit.BrowserRunner;
import com.gargoylesoftware.htmlunit.BrowserRunner.Alerts;
import com.gargoylesoftware.htmlunit.WebDriverTestCase;

/**
 * Tests for {@link MediaQueryList}.
 *
 * @author Ahmed Ashour
 * @author Ronald Brill
 */
@RunWith(BrowserRunner.class)
public class MediaQueryListTest extends WebDriverTestCase {

    /**
     * @throws Exception if the test fails
     */
    @Test
    @Alerts("true")
    public void matches() throws Exception {
        final String html
            = "<html><head><script>\n"
            + "  function test() {\n"
            + "    if (window.matchMedia) {\n"
            + "      alert(window.matchMedia('(min-width: 400px)').matches);\n"
            + "    }\n"
            + "  }\n"
            + "</script></head><body onload='test()'>\n"
            + "</body></html>";

        loadPageWithAlerts2(html);
    }

    /**
     * @throws Exception if the test fails
     */
    @Test
    @Alerts({"added", "removed"})
    public void listener() throws Exception {
        final String html
            = "<html><head><script>\n"
            + "  function listener(mql) {\n"
            + "    alert(mql);\n"
            + "  }\n"

            + "  function test() {\n"
            + "    if (window.matchMedia) {\n"
            + "      var mql = window.matchMedia('(min-width: 400px)');\n"
            + "      mql.addListener(listener);\n"
            + "      alert('added');\n"
            + "      mql.removeListener(listener);\n"
            + "      alert('removed');\n"
            + "    }\n"
            + "  }\n"
            + "</script></head><body onload='test()'>\n"
            + "</body></html>";

        loadPageWithAlerts2(html);
    }
}
