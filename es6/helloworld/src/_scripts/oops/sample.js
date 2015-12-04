/**
 * Created by sajit.kunnumkal on 12/4/2015.
 */

class Animalz {
  constructor(name) {
    "use strict";

    this.name = name;
  }
  whoAmi() {
    "use strict";

    console.log("I'm a " + this.name);
  }

}
var dog = Animalz("dog");
var cat = Animalz("cat");
dog.whoAmi();
cat.whoAmi();

