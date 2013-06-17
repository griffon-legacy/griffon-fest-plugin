
Enables testing with FEST
-------------------------

Plugin page: [http://artifacts.griffon-framework.org/plugin/fest](http://artifacts.griffon-framework.org/plugin/fest)


Enables UI testing with [FEST][1]. FEST-Swing is a Java library that provides a
fluent interface for functional Swing GUI testing. This library provides an
easy-to-use API that makes creation and maintenance of GUI tests easy. Tests
created with FEST usually belong to the integration type, as they rely on
testing your application from the end-user's point of view: the UI.

Usage
-----

Tests are run just like normal Griffon tests via grails `test-app`.

Every FEST test must initialize the application properly and cleanup any
resources after each test method has run. The base FEST testcase enforces this
by making the following methods final: `setUp()`, `tearDown()`. However you may
perform additional steps during those phases by overriding `onSetup()` and
`onTearDown()` respectively. Here as a sample testcase that demonstrates FEST
in action

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

