package com.aat

import org.gradle.api.Project

/**
 * Extension for plugin config properties
 */
class TextPluginExtension {

    String ws = null
    String missingKeys = null
    Map<String, String> variantToWs = null
    String defaultLanguage = 'en'
    def languages = []
    boolean removeDuplicate = true
    boolean alphabeticallySort = true
    boolean removeBadKeys = true
    // gSheet credentials
    String gSpreadsheetId = null
    String gSheetClientSecret = null
    int gColumnIndexForKey = 0
    int gColumnIndexForValue = 1

    private Project project

    public TextPluginExtension(Project project) {
        this.project = project
        /*this.outputDirectory = {
            return project.project.getBuildDir()
        }*/
    }

}