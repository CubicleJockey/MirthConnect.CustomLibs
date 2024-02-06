<#
This is a script that will loop through all the *.java files of a given directory (default: project src).
It will convert the .java file into a .class and then into a .jar file to be consumed by NextGen MirthConnect
#>
param (
    [string] $javaFilesDirectory = "$(Get-Location)\..\src",
    [string] $outputDirectory = "$(Get-Location)\..\custom-libs",
    [string] $preFix
)

Write-Information("Starting Mirth Connect Custom-Lib JAR creation...")

# Ensure the output directory exists
$outputDirResolved = Resolve-Path -Path $outputDirectory -ErrorAction SilentlyContinue
if (-not $outputDirResolved) {
    Write-Host "Output directory does not exist, creating: $outputDirectory"
    New-Item -ItemType Directory -Path $outputDirectory | Out-Null
}

# Resolve the path to its absolute form
$resolvedJavaFilesDirectory = Resolve-Path -Path $javaFilesDirectory

# Ensure the java files directory path exists
if (Test-Path -Path $resolvedJavaFilesDirectory) {
    # Change to the directory where your Java files are located
    Push-Location -Path $resolvedJavaFilesDirectory

    # Compile all .java files in the directory
    Get-ChildItem -Path . -Filter *.java | ForEach-Object {
        javac $_.Name
    }

    # Move .class files to the output directory (if needed)
    Get-ChildItem -Path . -Filter *.class | ForEach-Object {
        Move-Item -Path $_.FullName -Destination $outputDirectory
    }

    # Change to the output directory where .class files are now located
    Set-Location -Path $outputDirectory

    # Create a jar file for each .class file in the output directory
    Get-ChildItem -Path . -Filter *.class | ForEach-Object {
        $jarName = $_.BaseName + ".jar"
        if(-not [string]::IsNullOrWhiteSpace($preFix)){
            $jarName = "$preFix-$jarName"
        }
        jar -cvf $jarName $_.Name
    }

    # Optionally, clean up .class files after creating .jar files
    Get-ChildItem -Path . -Filter *.class | ForEach-Object { Remove-Item $_.FullName }

    # Return to the original directory
    Pop-Location
}
else {
    Write-Host "Invalid or non-existent java files directory path: $resolvedJavaFilesDirectory"
}