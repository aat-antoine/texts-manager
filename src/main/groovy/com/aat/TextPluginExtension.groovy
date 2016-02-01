package com.aat

import org.gradle.api.Project

/**
 * Extension for plugin config properties
 */
class HockeyAppPluginExtension {
    def Object outputDirectory
    def String url = null

    private final Project project

    public HockeyAppPluginExtension(Project project) {
        this.project = project
        this.outputDirectory = {
            return project.project.getBuildDir()
        }
    }

    File getOutputDirectory() {
        return project.file(outputDirectory)
    }

    void setOutputDirectory(Object outputDirectory) {
        this.outputDirectory = outputDirectory
    }


}