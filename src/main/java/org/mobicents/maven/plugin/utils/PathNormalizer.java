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

public class PathNormalizer {
		
	/**
	 * Forward slash character
	 */
			private static final String FORWARD_SLASH = "/";

	/**
	        * The pattern used for normalizing paths paths with more than one back slash.
	        */
	       private static final String BACK_SLASH_NORMALIZATION_PATTERN = "\\\\+";
	   
	       /**
	        * The pattern used for normalizing paths with more than one forward slash.
	        */
	       private static final String FORWARD_SLASH_NORMALIZATION_PATTERN = FORWARD_SLASH + "+";
	   
	       /**
	        * Removes any extra path separators and converts all from back slashes
	        * to forward slashes.
	        *
	        * @param path the path to normalize.
	        * @return the normalizd path
	        */
	       public static String normalizePath(final String path)
	       {
	           return path != null
	           ? path.replaceAll(
	               BACK_SLASH_NORMALIZATION_PATTERN,
	               FORWARD_SLASH).replaceAll(
	               FORWARD_SLASH_NORMALIZATION_PATTERN,
	               FORWARD_SLASH) : null;
	       }
	  
}
