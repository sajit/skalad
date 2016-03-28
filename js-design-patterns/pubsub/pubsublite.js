var me = function(){
  	var observers = [];
  	var _register = function(observer){
  	
  	     if(!observer || !observer.hasOwnProperty('notify')){
  	        console.error('Undefined or illegal observer');
  	        return;
  	     }
         observers.push(observer);
  	 };
  	 var _notify = function(){

        for(var i=0;i<observers.length;i++){
          observers[i].notify();
        }
  	 };
  	return {

       register : _register,
       notify: _notify
  	};

};
var observer1 = {
	notify: function(){
		console.log('In notify of observer1');
	}
};
var observer2 = {
	notify : function(){
		console.log('In notify of observer2');
	}
};
var observer3 = {};

var meme = me();
meme.register(observer1);
meme.register(observer2);
meme.register(observer3);
meme.notify();