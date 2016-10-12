<template>
  <div class="container-layout bg-main bg-inverse  fixed-top w100">
    <div class="line">
      <div class=" xs2 xm2 xb2">
        <span class="h6 logo-title">STATISTIC</span>
        <img src="assets/logo.png" class="logo-img"/>
      </div>
      <div class="  xs10 xm10 xb10  ">
        <div class="xs12 xm11 xb11">
          <ul class="nav nav-menu nav-inline nav-big ">

            <li><a v-link="{ path: '/hello2' }">首页</a></li>
            <li><a v-link="{ path: '/hello2' }">新闻资讯</a></li>
            <li><a v-link="{ path: '/hello' }">产品中心</a></li>
            <li><a href="javascript:void(0);" @click="testClick">技术反馈</a></li>

            <!--<li><a href="#">技术反馈</a></li>-->
            <!--<li><a href="#">留言反馈</a></li>-->
            <!--<li><a href="#">联系方式</a></li>-->

          </ul>
        </div>
        <div class="hidden-s hidden-m xb1 xb1-move">
          <div class="xl6  text-small logo-title ">
            <a href="#" class="win-homepage"></a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="loading-nav">
    <ui-progress-linear value="30" :show=show color="primary"></ui-progress-linear>
    <!--<ui-preloader :show=show></ui-preloader>-->
  </div>
  <div class="container padding-nav">
    <router-view></router-view>
  </div>

</template>
<script type="text/ecmascript-6">
  import ajax from './common/ajax';

  const App = {
    data(){
      return {
        message: '',
        show: true,
      }
    },
    methods: {
      testClick: function (e) {
        ajax.get('login').then((res)=> {
          console.log('res success', res)
      }, (res)=> {
          console.log('res failed', res)
        });
        console.log('ajax', ajax);
//        window._router.go('/hello2');
      }
    },

    created: function () {
      // `this` 指向 vm 实例
    },
    compiled: function () {
      // `this` 指向 vm 实例
    },
    ready: function () {
      // `this` 指向 vm 实例
      window.app = this;
    },
    destroyed: function () {
      // `this` 指向 vm 实例
    },


  }

  export default App
</script>

<style scoped>

  .logo-title {
    line-height: 50px;
  }

  .logo-img {
    width: 50px;
    height: 50px
  }

  .padding-nav {
    padding-top: 65px
  }

  .loading-nav {
    top: 51px;
    position: fixed;
    width: 100%;
    padding: 0;
    marging: 0;
  }

  .nav a {
    color: #fff;
  }
</style>
