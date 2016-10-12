<template>
  <div>
    <table class="table table-striped" :class="[test]">
      <template v-if="showHeader">
        <v-head :columns="columns"></v-head>
      </template>
      <tbody>
      <template v-if="isNotEmpty">
        <template v-for="item in data">
          <v-row :row-data="item" :columns="columns" :row-index="$index"></v-row>
        </template>
      </template>
      <template v-else>
        <v-empty :colspan="visibleColsNumber" :msg="emptyMsg"></v-empty>
      </template>
      </tbody>
    </table>
  </div>
</template>
<style>

</style>
<script type="text/ecmascript-6">
  import {isArray, isFunction} from './base/util';
  import vHead from './Head';
  import vRow from './Row';
  import vCol from './Column';
  import vEmpty from './Empty';

  let noop = ()=> {
  }

  export default{
    data(){
      return {
        msg: ''
      }
    },

    components: {
      vHead,
      vRow,
      vCol,
      vEmpty,
    },

    props: {
      data: Array,
      columns: Array,
      onChange: noop,
      onRowClick: noop,
      showHeader: {
        type: Boolean,
        default: true
      },
      emptyMsg: String,
    },
    computed: {
      isNotEmpty: function () {
        return this.data && isArray(this.data) && this.data.length > 0;
      },
      visibleCols: function () {
        return this.data.filter(v=>this.isColVisible(v));
      },
      visibleColsNumber: function () {
        return this.visibleCols.length;
      }
    },

    methods: {},
    ready: function () {
      // `this` 指向 vm 实例
      console.log('ready is: ', this.emptyMsg);
//      console.log(isArray([1, 2, 23, 5]));
//      console.log('showHeader', this.showHeader);
//      console.log(this.$root.version);
    },
  }
</script>
