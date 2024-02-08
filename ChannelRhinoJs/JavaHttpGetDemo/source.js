var url = "https://jsonplaceholder.typicode.com/comments";
logger.info('Executing [Packages.HttpHelper.Get] with URL[' + url + ']');
var jsonResponse = Packages.HttpHelper.Get(url);
logger.info(jsonResponse);