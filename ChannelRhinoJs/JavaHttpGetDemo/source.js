var url = "https://jsonplaceholder.typicode.com/comments";
logger.info('Executing [Packages.HttpHelper.Get] with URL[' + url + ']');
var jsonResponse = Packages.HttpHelper.Get(url);
if(jsonResponse){
    logger.info(jsonResponse);
} else {
    logger.warn('Failed to get JSON');
}

var channelName = 'JavaHttpGetDemo';

logger.info(channelName + ' end.');

logger.info('Stopping channel [' + channelName + ']');
ChannelUtil.stopChannel(channelName);