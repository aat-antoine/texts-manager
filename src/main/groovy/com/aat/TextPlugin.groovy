package com.aat

import com.android.build.gradle.api.ApplicationVariant
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin

class TextPlugin implements Plugin<Project> {

    final static String GROUP_NAME = 'Text'
    TextPluginExtension textPlugin

    void apply(Project project) {
        applyExtensions(project)
        applyTasks(project)
    }

    static void applyExtensions(final Project project) {
        project.extensions.create('texts', TextPluginExtension, project)
    }

    static void applyTasks(final Project project) {
        if (project.plugins.hasPlugin(AppPlugin)) {
            AppExtension android = project.android
            Task downloadTask = project.tasks.create("downloadTexts", Task);
            downloadTask.group = GROUP_NAME
            downloadTask.description = "Retrieve texts"

            android.applicationVariants.all { ApplicationVariant variant ->
                DownloadTextTask task = project.tasks.create("downloadTextsFrom${variant.name.capitalize()}Ws", DownloadTextTask)
                task.group = GROUP_NAME
                task.applicationVariant = variant
                task.variantName = variant.name
                task.description = "Download texts from ${variant.name}"
                task.outputs.upToDateWhen { false }
                task.dependsOn variant.assemble
                // task.downloadTask = downloadTask

                // downloadTask.dependsOn(task)
            }
        } else {
            println "An error ocurred"
        }
    }

}