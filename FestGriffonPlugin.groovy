/*
 * Copyright 2009-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the 'License');
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an 'AS IS' BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Andres Almiray
 */
class FestGriffonPlugin {
    // the plugin version
    String version = '1.0'
    // the version or versions of Griffon the plugin is designed for
    String griffonVersion = '0.9.5 > *'
    // the other plugins this plugin depends on
    Map dependsOn = [swing: '1.0.0', spock: '0.6']
    // resources that are included in plugin packaging
    List pluginIncludes = []
    // the plugin license
    String license = 'Apache Software License 2.0'
    // Toolkit compatibility. No value means compatible with all
    // Valid values are: swing, javafx, swt, pivot, gtk
    List toolkits = ['swing']
    // Platform compatibility. No value means compatible with all
    // Valid values are:
    // linux, linux64, windows, windows64, macosx, macosx64, solaris
    List platforms = []
    // URL where documentation can be found
    String documentation = ''
    // URL where source can be found
    String source = 'https://github.com/griffon/griffon-fest-plugin'

    List authors = [
            [
                    name: 'Andres Almiray',
                    email: 'aalmiray@yahoo.com'
            ]
    ]
    String title = 'Enables testing with FEST'
    // accepts Markdown syntax. See http://daringfireball.net/projects/markdown/ for details
    String description = '''
Enables UI testing with [FEST][1]. FEST-Swing is a Java library that provides a fluent interface for functional
Swing GUI testing. This library provides an easy-to-use API that makes creation and maintenance of GUI tests easy.
Tests created with FEST usually belong to the integration type, as they rely on testing your application from the
end-user's point of view: the UI.

Usage
-----

Tests are run just like normal Griffon tests via grails `test-app`.

Every FEST test must initialize the application properly and cleanup any resources after each test method has run.
The base FEST testcase enforces this by making the following methods final: `setUp()`, `tearDown()`. However you may
perform additional steps during those phases by overriding `onSetup()` and `onTearDown()` respectively.
Here as a sample testcase that demonstrates FEST in action

        import org.fest.swing.fixture.*
        import griffon.test.FestSwingTestCase
        class WordFinderTests extends FestSwingTestCase {
           // instance variables:
           // app - current application
           // window - value returned from initWindow()
           //      defaults to app.appFrames[0]
 
            void testNoWordPresentThenInvalidText() {
                window.with {
                    textBox("wordValue").enterText ""
                    button("findWord").click()
                    label("answer").requireText WordFinderModel.TYPE_A_WORD
                }
            }
 
            void testDefinitionPresent() {
                window.with {
                    textBox("wordValue").enterText "pugnacious"
                    button("findWord").click()
                    label("answer").requireText "Combative in nature; belligerent."
                }
            }
 
            void testWordPresentThenUnknownWord() {
                window.with {
                    textBox("wordValue").enterText "Bogus"
                    button("findWord").click()
                    label("answer").requireText WordFinderModel.UNKNOWN_WORD
                }
            }
        }

Scripts
-------

 * **create-fest-test** - creates a new FEST enabled integration test
 * **create-fest-spec** - creates a new FEST+[Spock][2] specification


[1]: http://fest.easytesting.org/swing/
[2]: /plugin/spock
'''
}