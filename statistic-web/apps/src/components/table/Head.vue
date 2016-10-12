<template>
  <thead>
  <tr>
    <template v-for="col in columns">
        <th v-show="isColVisible(col)">{{{getHeadTitle(col)}}}</th>
    </template>
  </tr>

  </thead>
</template>
<style scoped>

</style>
<!--suppress JSUnresolvedFunction, JSUnusedGlobalSymbols -->
<script>
  import utilMixin from './mixins/utilMixins';

  export default{
    mixins: [utilMixin],
    data(){
      return {
      }
    },
    props: {
      columns: Array

    },
    methods: {
      isTextTitle: function (col) {
        return this.isString(col['title'])
      },
      getHeadTitle: function (col) {
        let title = col['title']
        if (this.isString(title)) {
          return title;
        }
        if (this.isFunction(title)) {
          return title.call(this);
        }
      },
    }
  }
</script>
