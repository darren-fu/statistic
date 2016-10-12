/**
 * Created by darrenfu on 2016/8/31.
 */
const emptyStr = '';
const emptyObj = {};
const emptyArr = [];

const isArray = Array.isArray;

const isString = function (val) {
  return typeof val === 'string';
}

const isBoolean = function (val) {
  return val === true || val === false;
}

const isFunction = function (val) {
  return typeof val === 'function';
}

const isObject = function (obj) {
  return obj !== null && typeof obj === 'object';
}


const getObjectValue = function (object = emptyObj, path = emptyStr, defaultValue = emptyStr) {
  if (object === emptyObj || path === emptyStr) {
    return defaultValue
  }

  var obj = object
  if (path.trim() != '') {
    var keys = path.split('.')
    keys.forEach(function (key) {
      if (obj !== null && typeof obj[key] != 'undefined' && obj[key] !== null) {
        obj = obj[key]
      } else {
        obj = defaultValue
        return
      }
    })
  }
  return obj
}

// const callCallback = function (field, item) {
//   if (!this.hasCallback(field))
//     return
//   var args = field.callback.split('|')
//   var func = args.shift()
//   if (typeof this.$parent[func] == 'function') {
//     return (args.length > 0)
//       ? this.$parent[func].apply(this.$parent, [this.getObjectValue(item, field.name)].concat(args))
//       : this.$parent[func].call(this.$parent, this.getObjectValue(item, field.name))
//   }
//   return null
// }

export {
  isArray,
  isString,
  isBoolean,
  isFunction,
  isObject,
  getObjectValue
}

