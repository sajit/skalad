`let` is block scoped & `var` is function scoped.

```javascript
function foo() { 
  if(true){
    let i = 4;
  }
  console.log(i); //prints nothing. i is undefined
}
```
