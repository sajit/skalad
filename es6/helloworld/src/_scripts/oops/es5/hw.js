/**
 * Created by sajit.kunnumkal on 12/4/2015.
 */
"use strict";

var evens = [4, 6, 12, 4, 90];
var odds = evens.map(num => num + 1);
console.log('A list of odd numbers:', odds);

var [john, josh, jocelyn] = [1, 2, 3];
console.log('John was ', john);
class Foo {
  constructor(type) {
    "use strict";

    this.type = type;
  }
  getType() {
    "use strict";

    return this.type;
  }
}

var foo = new Foo("food");
console.log(foo.getType());
