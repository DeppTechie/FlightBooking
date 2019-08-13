$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/Flight2.feature");
formatter.feature({
  "name": "Sydney-Brisbane Travel Booking",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Book airline tickets with increasing numer of additional bags till 5",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I launch the Qantas Website for an user for \u003cusers\u003e time",
  "keyword": "Given "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "users"
      ]
    },
    {
      "cells": [
        "2"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Book airline tickets with increasing numer of additional bags till 5",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I launch the Qantas Website for an user for 2 time",
  "keyword": "Given "
});
formatter.match({
  "location": "FlightInfo2.i_launch_the_qantas_website_for_an_user_for_time(String)"
});
formatter.result({
  "status": "passed"
});
});