import * as _ from '../base/util';
const {
  isArray,
  isString,
  isBoolean,
  isFunction,
  isObject,
  getObjectValue
} = _;

const isColVisible = function(col){
     return !col.hasOwnProperty('visible') || col.visible;
}

let mixin = {
  methods: {
    isArray,
    isString,
    isBoolean,
    isFunction,
    isObject,
    getObjectValue,
    isColVisible
  }
}
export default mixin;
