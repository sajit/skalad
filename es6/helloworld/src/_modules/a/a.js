/**
 * Created by sajit.kunnumkal on 12/4/2015.
 */

'use strict';
export class A {
  var type = 'A';
  constructor(name){
    "use strict";
    this.name = name;
  }
  printType(){
    console.log('Type:',type);
  }
  getName(){
    return this.name;
  }
}


