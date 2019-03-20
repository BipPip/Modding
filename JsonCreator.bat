SET /P _inputname= Please enter [item] or [block]:
IF "%_inputname%"=="block" GOTO :block
IF "%_inputname%"=="item" GOTO :item
echo "That was not an option"
PAUSE
GOTO: end
:block
java -jar BlockJsonCreator.jar
GOTO: end
:item
java -jar ItemJsonCreator.jar
:end
PAUSE
