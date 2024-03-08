var text = "Your\rString\rWith\rCarriage\rReturns";
logger.info('Original text [' + text + ']');

var correctedText =  Packages.StringHelper.RemoveReturns(text);
if(correctedText){
    logger.info('Corrected text [' + correctedText + ']');
} else {
    logger.warn('Corrected text was empty. Java JAR library "Packages.StringHelper.RemoveCarriageReturns" failed.');
}

var replacedText = Packages.StringHelper.RemoveReturns(text, ":");
if(replacedText){
    logger.info('Replaced text [' + replacedText + ']');
} else {
    logger.warn('Replaced text was empty. Java JAR library "Packages.StringHelper.RemoveCarriageReturns" failed.');
}

var channelName = 'CustomJavaDemo';

logger.info(channelName + ' end.');

logger.info('Stopping channel [' + channelName + ']');
ChannelUtil.stopChannel(channelName);