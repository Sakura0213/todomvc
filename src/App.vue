<template>
  <section class="todoapp">
    <header class="header">
      <h1>TODO</h1>
      <input class="new-todo" placeholder="What needs to be done?" autofocus />
    </header>

    <section class="main">
      <input id="toggle-all" class="toggle-all" type="checkbox" />
      <label for="toggle-all">Mark all as complete</label>

      <ul class="todo-list">
        <li v-for="todo in todos" :key="todo
        .id" :class="{ completed: todo.complated }">
          <div class="view">
            <input class="toggle" type="checkbox" v-model="todo.complated"/>
            <label>{{ todo.title }}</label>
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
import { ref } from "vue";

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
  },
]);
</script>

<style>
@import "https://unpkg.com/todomvc-app-css@2.4.1/index.css";
</style>
