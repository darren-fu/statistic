import Vue from 'vue';
import VueRouter from 'vue-router';
import VueResource from 'vue-resource';
import Vuex from 'vuex';

import Keen from 'keen-ui';
import App from './App';

import Hello from './pages/Hello.vue';
import Hello2 from './pages/Hello2.vue';
import Table from './components/table/Table.vue';

initVue();



const store = new Vuex.Store({
  state: {
    count: 10
  },
  mutations: {
    increment (state) {
      console.log('increment.constructor......')
      state.count++
    }
  },

})


console.log('store', store.state);
/* eslint-disable no-new */
// var vm = new Vue({
//   el: 'body',
//   components: { App },
// });


// create router
const router = new VueRouter()
router.map({
  '/hello': {component: Hello},
  '/hello2': {component: Hello2},
  '/': {component: Table},
})

router.redirect({'*': '/hello2'});
let app = Vue.extend({
  data: function () {
    //this.$root 可直接获取
    return {
      version: '1.0.0',
      desc: 'statistic',
    }
  },
  store,
  components: {
    app: App
  }
});

router.start(app, '#app')
window._router = router;
//这里一定要空一个行

function initVue() {

  Vue.use(VueRouter);
  Vue.use(Keen);
  Vue.use(VueResource)
  Vue.use(Vuex);
// // 全局配置
//   Vue.config.debug = true

}
