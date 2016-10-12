<template>
  <tr>
    <template v-for="col in columns">
      <template v-if="isHasRenderFn(col)">
        <td>{{callRender(col)}}</td>

      </template>
      <template v-else>
        <td>{{getObjectValue(rowData,col.field,'')}}</td>
      </template>
    </template>
  </tr>
</template>
<style>
</style>
<script type="text/ecmascript-6">
  import utilMixin from './mixins/utilMixins';
  export default{
    mixins: [utilMixin],
    data(){
      return {}
    },
    props: {
      rowIndex: Number,
      rowData: Object,
      columns: Array
    },
    components: {},

    methods: {
      isHasRenderFn: function (col) {
        return col && typeof col['render'] == 'function';
      },
      callRender: function (col) {
        return col['render'].call(this, this.rowData, this.rowIndex);
      }
    }
  }

</script>
