/* ====================================================================
 * Copyright 2002 - 2004
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
 *
 *
 * $Id$
 */

package org.apache.ftpserver.interfaces;

import org.apache.ftpserver.FtpUser;

import java.io.IOException;

/**
 * This observer interface monitors all the ftp connections.
 *
 * @author <a href="mailto:rana_b@yahoo.com">Rana Bhattacharyya</a>
 */
public
interface FtpConnectionObserver {

    /**
     * New connection notification.
     * @param user new connected user.
     */
    void newConnection(final FtpUser user);

    /**
     * Close connection notification
     * @param user closed user object
     */
    void removeConnection(final FtpUser user);

    /**
     * Update connection notification
     * @param user updated user object
     */
    void updateConnection(final FtpUser user);

    void requestError(String message, IOException ex);

    void unknownServiceException(String message, Throwable th);

    void newRequest(String message);

}
