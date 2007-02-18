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

package org.apache.ftpserver;

import java.util.Properties;

import junit.framework.TestCase;

import org.apache.ftpserver.config.PropertiesConfiguration;
import org.apache.ftpserver.ftplet.Configuration;
import org.apache.ftpserver.listener.Listener;
import org.apache.ftpserver.listener.io.IOListener;
import org.apache.ftpserver.listener.mina.MinaListener;


public class ConfigurableFtpServerContextTest extends TestCase {

    public void testConfigListeners() throws Exception {
        Properties props = new Properties();
        props.setProperty("config.listeners.foo1.class", IOListener.class.getName());
        props.setProperty("config.listeners.foo2.class", MinaListener.class.getName());
        
        Configuration config = new PropertiesConfiguration(props);
        
        ConfigurableFtpServerContext ctx = new ConfigurableFtpServerContext(config);
        
        assertNotNull(ctx.getListener("foo1"));
        assertTrue(ctx.getListener("foo1") instanceof IOListener);
        
        assertNotNull(ctx.getListener("foo2"));
        assertTrue(ctx.getListener("foo2") instanceof MinaListener);
        
        Listener[] listeners = ctx.getListeners();
        
        assertEquals(2, listeners.length);
        assertTrue(listeners[0] instanceof Listener);
        assertTrue(listeners[1] instanceof Listener);
        
    }
    
}