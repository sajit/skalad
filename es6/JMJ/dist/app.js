"use strict";

require("babelify/polyfill");

var _module = function sum(x, y) {
    return x + y;
};

var math = _interopRequireWildcard(_module);

function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

console.log('Hello world'); // Needed for Babel's experimental features.

function main() {

  console.log(math.sum(5, 5));
};
main();
//# sourceMappingURL=app.js.map
