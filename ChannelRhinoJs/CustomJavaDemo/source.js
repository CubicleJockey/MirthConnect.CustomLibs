var text = "Your\rString\rWith\rCarriage\rReturns";
logger.info('Original text [' + text + ']');

var correctedText =  Packages.StringHelper.RemoveCarriageReturns(text);
if(correctedText){
    logger.info('Corrected text [' + correctedText + ']');
} else {
    logger.warn('Corrected text was empty. Java JAR library "Packages.StringHelper.RemoveCarriageReturns" failed.');
}