/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.ode.superbia.multisource;

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;

/**
 * @goal msdp
 * @phase generate-sources
 * @description Multiple Source Directory Plugin for Maven2
 */
public class MultipleSourceDirMojo extends AbstractMojo {

    /**
     * @parameter expression="${project}"
     * @required
     * @readonly
     */
    private MavenProject project;

    /**
     * @parameter expression="${sourceDir}"
     * @required
     */
    private File sourcedir;
    
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().debug("Adding " + sourcedir + " to compiler path");
        project.addCompileSourceRoot(sourcedir.getAbsolutePath());
    }

    public MavenProject getProject() {
        return project;
    }

    public void setProject(MavenProject project) {
        this.project = project;
    }

    public File getSourceDir() {
        return sourcedir;
    }

    public void setSourceDir(File sourcedir) {
        this.sourcedir = sourcedir;
    }

}
