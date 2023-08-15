<template>
  <section class="todoapp">
    <header class="header">
      <h1>TODO</h1>
      <input class="new-todo" placeholder="What needs to be done?" autofocus />
    </header>

    <section class="main">
      <input
        id="toggle-all"
        class="toggle-all"
        type="checkbox"
        @click="toggleAll($event)"
      />
      <label for="toggle-all">Mark all as complete</label>

      <ul class="todo-list">
        <li
          v-for="todo in todos"
          :key="todo.id"
          :class="{ completed: todo.complated }"
        >
          <div class="view">
            <input class="toggle" type="checkbox" v-model="todo.complated" />
            <!-- <label>{{ todo.title }}</label> -->
            <label v-text="todo.title"></label>
            <button class="destroy"></button>
          </div>
          <!-- <input class="edit" value="Create a TodoMVC template" /> -->
        </li>
      </ul>
    </section>

    <footer class="footer">
      <span class="todo-count"><strong>0</strong> item left</span>

      <ul class="filters">
        <li>
          <a class="selected" href="#/">All</a>
        </li>
        <li>
          <a href="#/active">Active</a>
        </li>
        <li>
          <a href="#/completed">Completed</a>
        </li>
      </ul>

      <button class="clear-completed">Clear completed</button>
    </footer>
  </section>
</template>

<script setup>
import { ref, onMounted } from "vue";

const todos = ref([
  {
    id: 1,
    title: "测试内容1",
    complated: false,
  },
  {
    id: 2,
    title: "测试内容2",
    complated: true,
  }
]);

//方法1 使用内联事件处理器来访问原生 DOM 事件。你可以向该处理器方法传入一个特殊的 $event 变量
// @click="toggleAll($event)"
function toggleAll(event) {
  todos.value.forEach((element) => {
    element.complated = event.target.checked;
  });
}



//方法2：勾选复选框，修改列表中全部的复选框状态
//<input class="toggle" type="checkbox" v-model="todo.complated" />
//const toggleAll = ref();
// watch(toggleAll, (newValue) => {
//   todos.value.forEach((element) => {
//     element.complated = newValue;
//   });
// });
//


//获取页面新的hash值
//现在只能使用原生js解决，看看后续有没有方法去解决
onMounted(() => {
  window.addEventListener("hashchange", function () {
    const newHash = window.location.hash.replace(/#\//, "");
    if (["",])
  
});
})
</script>

<style>
@import "https://unpkg.com/todomvc-app-css@2.4.1/index.css";
</style>
