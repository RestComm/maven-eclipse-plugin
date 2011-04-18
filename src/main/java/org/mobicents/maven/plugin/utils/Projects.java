/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.maven.plugin.utils;

import java.util.ArrayList;
import java.util.Collection;


/**
 * Stores projects ids.
 *
 * @author Chad Brandon
 */
public class Projects
{
    private Collection projects = new ArrayList();

    /**
     * The shared instance of this class.
     */
    private static Projects instance;

    /**
     * Retrieves the shared instance of this class.
     *
     * @return the shared instance.
     */
    public static Projects instance()
    {
        if (instance == null)
        {
            instance = new Projects();
        }
        return instance;
    }

    /**
     * Adds the project id to the store.
     *
     * @param projectId the project id.
     */
    public void add(final String projectId)
    {
        this.projects.add(projectId);
    }

    /**
     * Indicates whether or not the project is present.
     *
     * @param projectId the identifier of the project.
     * @return true/false
     */
    public synchronized boolean isPresent(final String projectId)
    {
        return projects.contains(projectId);
    }

    /**
     * Clears out any existing projects.
     */
    public void clear()
    {
        this.projects.clear();
        instance = null;
    }
}