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

package org.apache.ftpserver.command;

import java.io.IOException;

import org.apache.ftpserver.ftplet.FtpReply;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.interfaces.FtpIoSession;
import org.apache.ftpserver.interfaces.FtpServerContext;
import org.apache.ftpserver.util.FtpReplyUtil;

/**
 * <code>ABOR &lt;CRLF&gt;</code><br>
 *
 * This command tells the server to abort the previous FTP
 * service command and any associated transfer of data.
 * No action is to be taken if the previous command
 * has been completed (including data transfer).  The control
 * connection is not to be closed by the server, but the data
 * connection must be closed.  
 * Current implementation does not do anything. As here data 
 * transfers are not multi-threaded. 
 */
public 
class ABOR extends AbstractCommand {

    /**
     * Execute command
     */
    public void execute(FtpIoSession session, 
    		FtpServerContext context,
            FtpRequest request) throws IOException {
        
        // reset state variables
        session.resetState();
        
        // and abort any data connection
        session.getDataConnection().closeDataConnection();
        session.write(FtpReplyUtil.translate(session, request, context, FtpReply.REPLY_226_CLOSING_DATA_CONNECTION, "ABOR", null));
    }   
}