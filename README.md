# gradle-retrieve-text

DO NOT USE IT IN PRODUCTION. PROJECT IS UNDER ACTIVE DEVELOPMENT

A gradle plugin to manage texts from WS or csv hosted as google sheet

## WS

This library download text from ws. Language is sent as header to API. Model should be as json like following :

```json
{
    "data": {
        "texts": [
            {
                "key": "my_key",
                "value": "My Value"
            },
            {
                "key": "other_key",
                "value": "Other wonderful value"
            }
        ]
    }
}
```

## gSheet

TODO

## Basic usage

Add to your build.gradle

```gradle
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath 'com.aat:gradle-retrieve-text:0.5.0'
    }
}

apply plugin: 'com.aat'
text {
    ...
}
```

## Advanced usage

Add to your build.gradle

```gradle
texts {
        defaultLanguage = 'en'
        languages = ['de', 'es', 'fr']
        ws = 'http://hostname/text'
        missingKeys = '''
<!-- other resources (not present in WS) -->
<string name=\"app_name\">appName</string>
'''

```
### Fields
* `defaultLanguage`: Your default language
* `languages`: All languages available for the app
* `ws`: Where you can retrieve texts as json
* `missingKeys`: Keys you want to add (not in WS)


