# Custom Mirth Connect Package (Java):

1. Create Java Class (Save included `StringHelper.java` file from GIST.)
2. Compile Java (Run: `javac` in `PowerShell` to see if it's installed.)
    * Run: `javac StringHelper.java` on the file from step 1.
4. Package Compiled Java into JAR file:
    * Run: `jar cf string-helper.jar StringHelper.class`
5. Install Java Package (JAR file):
    * Copy the `string-helper.jar` file into the custom lib directory of Mirtch Connect.
    * Directory `MIRTH_CONNECT_HOME/custom-lib`
        * If does not exist create it.
    * Restart Mirth Connect to have Mirth Connect load the new JAR file
6. Sample RhinoJS code in a JavaScript transformer:
```JavaScript
var text = "Your\rString\rWith\rCarriage\rReturns";

var correctedText = Packages.StringHelper.RemoveReturns(text);
``` 