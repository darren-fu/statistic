<template>
  <tr>
    <td colspan="{{colspan}}" align="center">
      <span class="empty">
          {{msg}}
      </span>
    </td>
  </tr>
</template>

<script type="text/ecmascript-6">

  export default {
    props: {
      colspan: Number,
      msg: {
        type: String,
        default: '没有记录'
      }
    },
    ready: function () {
      console.log('msg', this.msg);
    }
  }

</script>
<style scoped>
  .empty {
    height: 25px;
    line-height: 25px;
    font-size: inherit;
  }

</style>
