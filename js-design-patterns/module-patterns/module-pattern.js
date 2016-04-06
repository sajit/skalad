var testModule = (function(){
	var name,counter = 0;
	var _getName = function(){
		 counter +=1;
         return name;
	};
	var _setName = function(aName){
	  if(aName){
	  	 counter += 1;
	     name = aName;
	  }
	};
	return {
	   getName: _getName,
	   setName: _setName,
	   getFnCalls: function() {
	   	 return counter;
	   }
	};
})();

console.log('Name',testModule.getName());
testModule.setName('Ponnu');
console.log('Name after setting',testModule.getName());
console.log('Total fn calls', testModule.getFnCalls());