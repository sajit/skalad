var a = {};
console.log(a.age); //should be undefined
var Car = function(model,year){
	var myModel = model,myYear = year;
 //this.model = model;
 //this.year = year;
 this.getModel = function() {
 	return myModel;
 };
 this.getYear = function() {
 	return myYear;
 }

};

var ford = new Car("Fiesta",2001);
console.log(ford.model); //undefined
console.log(ford.myModel); //undefined
console.log(ford.getModel()); //"Fiesta"

Car.prototype.toString = function() {
	return "Type:"+this.getModel()+",Year:"+this.getYear();
};

//////
console.log(ford.toString());
ford.slogan = function(){
	return "Its a ford!";
};
console.log("Slogan",ford.slogan());

var fiat = new Car("Fiat",1998);
console.log(fiat.slogan ===undefined); //true

console.log(fiat.toString());