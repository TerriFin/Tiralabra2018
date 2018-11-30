# How is the program launched?

Use attached gradle wrappers to download correct version of gradle to your computer (gradle.bat if you are on windows and gradlew if on linux), and then use the correct wrapper to launch the program.

WINDOWS: gradle.bat run

UNIX-LIKE: gradlew run

alternatively you can check "releases" page on github, and download a jar file that can be excecuted normally. (will upload one when the program is done)


# What inputs does the program accept?

After the program opens, there is one input and one button. You can press the button when there is a number between 5 and 120 on the input, and doing so will generate a new labyrinth and start solving it.


# In what folder is the jar and other goodies?

If you did not download only the jar file, but instead ran gradle tasks, all files can be found in build-directory in expected gradle format.
