/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.headwire.aem.tooling.intellij.io.eclipse;

import com.intellij.ide.plugins.PluginManager;
import org.apache.sling.ide.io.PluginLogger;

/**
 * Created by Andreas Schaefer (Headwire.com) on 12/22/15.
 */
public class EclipsePluginLogger
    implements PluginLogger
{
    private org.apache.sling.ide.log.Logger delegate;

    public EclipsePluginLogger() {
        delegate = org.apache.sling.ide.eclipse.core.internal.Activator.getDefault().getPluginLogger();
        //AS TODO: This will not work
    }

    @Override
    public void error(String s) {
        delegate.error(s);
    }

    @Override
    public void error(String message, Object...parameters) {
        delegate.error(format(message, parameters));
    }

    public void error(String s, Throwable throwable) {
        delegate.error(s, throwable);
    }

    @Override
    public void warn(String s) {
        delegate.warn(s);
    }

    @Override
    public void warn(String message, Object...parameters) {
        delegate.warn(format(message, parameters));
    }

    @Override
    public void trace(String message) {
        delegate.trace(message);
    }

    @Override
    public void trace(String message, Object...parameters) {
        delegate.trace(format(message, parameters));
    }

    private String format(String template, Object...parameters) {
        String ret = template;
        if(parameters != null && parameters.length > 0) {
            for (int i = 0; i < parameters.length; i++) {
                ret = ret.replace("{" + i + "}", String.valueOf(parameters[i]));
            }
        }
        return ret;
    }
}
