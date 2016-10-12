/**
 * Created by darrenfu on 2016/8/30.
 */

import Vue from 'vue';
import VueResource from 'vue-resource';
import queryString from 'query-string';

console.log('load ajax module');

Vue.use(VueResource)
// 全局配置
Vue.config.debug = true


// Vue.http.options.headers = {
//   'Content-Type': 'application/json;charset=UTF-8;'
// }
// post的时候会把JSON对象转成formdata ,server不支持application/json的时候使用
//   Vue.http.options.emulateJSON = true

Vue.http.options.root = 'http://127.0.0.1:9000';
// Vue.http.headers.common['Authorization'] = 'Authorization-Common-Header';

Vue.http.interceptors.push((request, next) => {
  // ...
  // 请求发送前的处理逻辑
  // ...
  next((response) => {
    // ...
    // 请求发送后的处理逻辑
    // ...
    // 根据请求的状态，response参数会返回给successCallback或errorCallback
    console.log('response', response);
    return response
  })
})


const get = (url, param, options) => {
  let remoteUrl = param ? url + '?' + queryString.stringify(param) : url;
  return new Promise((resolve, reject)=> {
    Vue.http.get(remoteUrl, {credentials: true}).then((res)=> {
      resolve(res);
    }, (res)=> {
      reject(res);
    })
  });
}

const post = (url, param, options) => {
  let remoteUrl = param ? url + '?' + queryString.stringify(param) : url;
  return new Promise((resolve, reject)=> {
    Vue.http.post(remoteUrl, {credentials: true}).then((res)=> {
      resolve(res);
    }, (res)=> {
      reject(res);
    })
  });
}


export default{
  get,
  post,
}
