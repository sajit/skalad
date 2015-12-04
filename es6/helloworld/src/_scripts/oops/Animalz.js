/**
 * Created by sajit.kunnumkal on 12/4/2015.
 */
"use strict";
class Animalz{
  constructor(name) {
    this.name = name;
  }
  whoAmi(){
    console.log("I'm a " + this.name);
  }

}
var dog = Animalz("dog");
var cat = Animalz("cat");
dog.whoAmi();
cat.whoAmi();
