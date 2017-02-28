# dota2-api-connector


dota2-api-connector

Java-wrapper for the [Dota 2 WebAPI](https://wiki.teamfortress.com/wiki/WebAPI). 

**Requirements**

- Google GSON (JSON -> Java; java -> JSON)

**Overview**

This project will deserialize Dota2 API responses into typed Java objects. 

**Example**

1)Get the [key](http://steamcommunity.com/dev/apikey)

2)Creating a request URL:

Dota2Api dota2Api = new Dota2Api("API-KEY");
 
dota2Api.getMatchDetailed(2569227952L).toString();
 
**Documentation**

Lvl Dota2 Api is described here http://dev.dota2.com/showthread.php?t=58317
