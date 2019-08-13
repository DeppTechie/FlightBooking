$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/Launch.feature");
formatter.feature({
  "name": "Order Garments",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "HomePage Order",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I launch the Shopping Page",
  "keyword": "Given "
});
formatter.match({
  "location": "Steps.i_launch_the_shopping_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add First Item to cart",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.i_add_first_item_to_cart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add Second Item to cart",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.i_add_second_item_to_cart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I move to Review Page",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.i_move_to_review_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter the userID",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.i_enter_the_userid()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I Fill PersonalInfo Form",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.i_fill_personalinfo_form()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I confirm Shipping Address",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.i_confirm_shipping_address()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I confirm the payment",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.i_confirm_the_payment()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Finally Place Order",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.finally_place_order()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I Close the window",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.I_Close_the_window()"
});
formatter.result({
  "status": "passed"
});
});