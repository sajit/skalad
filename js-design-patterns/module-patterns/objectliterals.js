//In javascript there are many ways to implement modules
//1. Object literal notation
//2. The Module pattern
//3. AMD modules
//4. CommonJs modules
//5. ECMAScript Harmony modules

//Object literal notation

var my1stModule = {
	
	name : 'Sample Module',
	getName: function() {
	  return this.name;
	}
};

console.log('Module property',my1stModule.name);
console.log('Module fn call', my1stModule.getName());
try{
	console.log(getName())
}catch(err){
	console.error(err);
}