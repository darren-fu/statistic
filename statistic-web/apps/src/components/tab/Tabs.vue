<template>
  <div>
    <ul class="tab" v-if="tabNumber > 0">
      <template v-for="name in tabs" track-by="$index">
        <li><a class="" :class="{'selected': curIdx == $index}" href="javascript:;" @click="clickTab($index)"
               @dblclick="dubleClickTab($index)">{{name}}</a></li>
      </template>
    </ul>

  </div>
</template>

<script type="text/ecmascript-6">


  let noop = ()=> {
  }
  export default {
    data(){
      return {
        cur:0
      }
    },
    props: {
      tabs: {
        type: Array,
        default: ()=>[]
      },
      curTab: {
        type: Number,
        default: 0
      },
      onTabClick: noop,
      onTabDoubleClick: noop,
    },
    computed: {
      tabNumber: function () {
        return this.tabs.length;
      },
      curIdx: function () {
        return (this.curTab > this.tabNumber || this.curTab < 0) ? 0 : this.curTab;
      },

    },
    methods: {
      clickTab: function (idx) {
        console.log('clickTab', idx);
        this.curTab = idx;
      },
      dubleClickTab: function (idx) {
        console.log('dbclick', idx);
      },
    },
    ready: function () {
      console.log(this.tabs.length);

    }  ,
    attached:function(){
      console.log(this.curTab);
    },

  }
</script>

<style scoped>

  ul.tab {
    list-style: none;
    letter-spacing: -4px;
    margin: 10px 0 0 0;
    padding: 0;
    border-bottom: 1px solid #e1e7f1 !important;
    border: 0;
  }

  .tab li {
    display: inline-block;
    letter-spacing: 0;
    list-style: none;
    margin: 0;
    padding: 0;
    max-width: 180px;
    vertical-align: baseline;
  }

  .tab li a {
    display: inline-block;
    line-height: 16px;
    font-size: 14px;
    padding: 7px 15px;
    position: relative;
    z-index: 3;
    margin-bottom: -1px;
  }

  .tab li a.selected {
    border-color: rgba(0, 0, 0, .1) rgba(0, 0, 0, .1) rgba(0, 0, 0, .25);
    font-weight: bold;
    color: #555555 !important;
    background-color: #FFF !important;
    border: 1px solid #e1e7f1 !important;
    border-bottom: 0 !important;
  }


</style>
