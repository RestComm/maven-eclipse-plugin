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

package org.mobicents.maven.plugin.eclipse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.resolver.filter.ArtifactFilter;


/**
 * An 'OR' artifact filter.  That means if one of the artifact filters applies
 * include returns true.
 *
 * @author Chad Brandon
 */
public class OrArtifactFilter
    implements ArtifactFilter
{
    private final List filters = new ArrayList();

    /**
     * @see org.apache.maven.artifact.resolver.filter.ArtifactFilter#include(org.apache.maven.artifact.Artifact)
     */
    public boolean include(final Artifact artifact)
    {
        boolean include = false;
        for (final Iterator iterator = this.filters.iterator(); iterator.hasNext();)
        {
            ArtifactFilter filter = (ArtifactFilter)iterator.next();
            if (filter.include(artifact))
            {
                include = true;
                break;
            }
        }
        return include;
    }

    /**
     * Adds the artifact filter to be applied.
     *
     * @param artifactFilter
     */
    public void add(final ArtifactFilter artifactFilter)
    {
        this.filters.add(artifactFilter);
    }
}