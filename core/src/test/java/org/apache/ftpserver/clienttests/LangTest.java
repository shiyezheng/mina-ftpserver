/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.ftpserver.clienttests;

import java.util.Arrays;

import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.message.MessageResourceFactory;

/**
*
* @author <a href="http://mina.apache.org">Apache MINA Project</a>
*
*/
public class LangTest extends ClientTestTemplate {

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.ftpserver.clienttests.ClientTestTemplate#createConfig()
     */
    @Override
    protected FtpServerFactory createServer() throws Exception {
        FtpServerFactory server = super.createServer();

        MessageResourceFactory factory = new MessageResourceFactory();
        factory.setLanguages(Arrays.asList(new String[] { "en", "zh-tw" }));
        server.setMessageResource(factory.createMessageResource());
        
        return server;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.ftpserver.clienttests.ClientTestTemplate#setUp()
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();

        client.login(ADMIN_USERNAME, ADMIN_PASSWORD);
    }

    public void testLangDefault() throws Exception {
        assertEquals(200, client.sendCommand("LANG"));
    }

    public void testLangEn() throws Exception {
        assertEquals(200, client.sendCommand("LANG EN"));
    }

    public void testLangZHTW() throws Exception {
        assertEquals(200, client.sendCommand("LANG ZH-TW"));
    }

    public void testLangZHTWLowerCase() throws Exception {
        assertEquals(200, client.sendCommand("LANG zh-tw"));
    }

    public void testLangUnknownLang() throws Exception {
        assertEquals(504, client.sendCommand("LANG FOO"));
    }

}
