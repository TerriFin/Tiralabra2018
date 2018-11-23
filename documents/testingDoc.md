# What has been tested and how?

Most classes have junit tests made, solving algorithms and gui do not have yet and might not have at all, since it would be obvious from the program if they did not work as expected.


# With what inputs were the tests made?

Class in guestion is injected with a controlled input of correct type, and asserted to work in wanted way.


# How can the tests be replicated?

Clone the project, use gradlew or gradle.jar depending if you are on window or unix-based system, then use correct gradle call with a keyword "test"

for copy/paste

* gradlew test *
* gradle.jar test *

for reports, use 

* gradlew test jacocoTestReport *
* gradlew test jacocoTestReport *

reports can be found in build/reports/jacoco/test/html/index.html
