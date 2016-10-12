<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <div>{{arr|json}}</div>
  </div>
  <button @click="increment">add</button>
  <span>{{count }}</span>
  <tabs></tabs>
</template>

<script type="text/ecmascript-6">
  import ajax from '../common/ajax';
  import tabs from 'components/tab/Tabs';

  export default {
    data() {
      return {
        msg: 'Hello WorlFFFFd!',
        arr: [{name: 'aaa'}, {name: 'bbb'}]
      };
    },
    methods: {
      increment: function () {
        this.$store.state.count++;
        console.log('1231231');
      }
    },
    computed: {
      count: function () {
        return this.$store.state.count;
      },
    },
    vuex: {
      actions: {
        add: ({dispatch})=> {
          console.log('add,,,.constructor.')
          dispatch('increment')
        }
      }
    },
    components: {
      tabs
    },
    created: function () {
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
