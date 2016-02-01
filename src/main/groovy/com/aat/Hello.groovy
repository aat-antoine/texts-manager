package com.aat

import com.android.build.gradle.api.ApplicationVariant
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin

class Hello implements Plugin<Project> {

    final static String GROUP_NAME = 'aatGroup'

    TextPluginExtension textApp

    void apply(Project project) {
        applyExtensions(project);
        project.task('hello') << {
            println "Hello from the GreetingPlugin"
            println textApp
        }
    }

    static void applyExtensions(final Project project) {
        project.extensions.create('texts', TextPluginExtension, project)
    }

    static void applyTasks(final Project project) {
        if (project.plugins.hasPlugin(AppPlugin)) {
            AppExtension android = project.android
            Task uploadAllTask = project.tasks.create("helloTask", Task);
            uploadAllTask.group = GROUP_NAME
            uploadAllTask.description = "Retrieve texts"

            /*android.applicationVariants.all { ApplicationVariant variant ->
                HockeyAppUploadTask task = project.tasks.create("upload${variant.name.capitalize()}ToHockeyApp", HockeyAppUploadTask)
                task.group = GROUP_NAME
                task.description = "Upload '${variant.name}' to HockeyApp"
                task.applicationVariant = variant
                task.variantName = variant.name
                task.outputs.upToDateWhen { false }
                task.dependsOn variant.assemble
                task.uploadAllPath = uploadAllPath

                uploadAllTask.dependsOn(task)
            }*/
        } else {
            println "An error ocurred"
        }
    }

}