package com.aat

import org.gradle.api.Project

/**
 * Extension for plugin config properties
 */
class TextPluginExtension {
    def Object outputDirectory
    def String ws = null

    private Project project

    public TextPluginExtension(Project project) {
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