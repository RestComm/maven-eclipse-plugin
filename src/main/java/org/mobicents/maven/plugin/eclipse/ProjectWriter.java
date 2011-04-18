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

import java.io.File;
import java.io.FileWriter;

import org.apache.maven.plugin.logging.Log;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.IOUtil;
import org.codehaus.plexus.util.xml.PrettyPrintXMLWriter;
import org.codehaus.plexus.util.xml.XMLWriter;


/**
 * Writes .project files for Eclipse.
 *
 * @author Chad Brandon
 */
public class ProjectWriter
    extends EclipseWriter
{
    public ProjectWriter(
        final MavenProject project,
        final Log logger)
    {
        super(project, logger);
    }

    /**
     * Writes the .classpath file for Eclipse.
     */
    public void write(String projectName)
        throws Exception
    {
        final File projectFile = this.getFile(".project");
        final FileWriter fileWriter = new FileWriter(projectFile);
        final XMLWriter writer = new PrettyPrintXMLWriter(fileWriter,"UTF-8",null);
        writer.startElement("projectDescription");
        writer.startElement("name");
        writer.writeText(projectName);
        writer.endElement();
        writer.startElement("comment");
        writer.endElement();
        writer.startElement("projects");
        writer.endElement();
        writer.startElement("buildSpec");
        writer.startElement("buildCommand");
        writer.startElement("name");
        writer.writeText("org.eclipse.jdt.core.javabuilder");
        writer.endElement();
        writer.startElement("arguments");
        writer.endElement();
        writer.endElement();
        writer.endElement();
        writer.startElement("natures");
        writer.startElement("nature");
        writer.writeText("org.eclipse.jdt.core.javanature");
        writer.endElement();
        writer.endElement();
        writer.endElement();
        IOUtil.close(fileWriter);
        this.logger.info("Project file written --> '" + projectFile + "'");
    }
}