<template>

  <v-tabs :tabs="tabs"></v-tabs>
  <div>
    <button @click="add">添加</button>
  </div>
  <div class="hello">
    <v-table :data="data" :columns="columns"></v-table>
  </div>
  <span>{{count}}</span>

</template>

<script type="text/ecmascript-6">
  import vTable from 'components/table/Table';
  import vTabs from 'components/tab/Tabs';


  let data = [
    {id: 1, name: '赵千夜', sex: 1},
    {id: 2, name: '张梓潼', sex: 0},
    {id: 3, name: '刘老根', sex: 0},
    {id: 4, name: '陆长亭', sex: 1}
  ];

  let noop = ()=> {
  }
  let columns = [
    {
      key: null,
      title: '天榜排名',
      field: 'id',

    }, {
      key: null,
      title: '名字',
      field: 'name',
    }, {
      key: null,
      title: ()=> {
        return '性别'
      },
      render: (row, idx)=> {
        return row.sex == 1 ? '男' : '女';
      }
    }
  ]
  let tabs = ['标签1', '标签2', '标签3']

  export default {
    data() {
      return {
        data,
        columns,
        tabs,
      };
    },
    components: {
      vTable,
      vTabs,
    },
    computed: {
      count: function () {
        return this.$store.state.count
      },
    },
    methods: {
      add: function (e) {
        console.log(e);
        this.tabs.push('标签4');
      },
    },
    ready: function () {
      window.hello = this;

    },

  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1 {
    color: #42b983;
  }
</style>
