import "babelify/polyfill"; // Needed for Babel's experimental features.
import * as math from "./module";

console.log('Hello world');


function main() {
  

  console.log(math.sum(5, 5));
};