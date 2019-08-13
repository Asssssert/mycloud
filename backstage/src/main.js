// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
import $ from 'jquery'
import axios from 'axios'
import Lockr from 'lockr'
import Vuex from 'vuex'
import store from './vuex/store'
import global from './assets/js/global'
import md5 from 'js-md5'
import i18n from './i18n/i18n'
import 'element-ui/lib/theme-chalk/index.css';
import ElementUI from 'element-ui';

Vue.use(ElementUI);
const bus = new Vue();
window.bus = bus;
window.md5 = md5;
window.axios = axios;
window.$ = $;
window._g = global;
window.router = router;
window.NProgress = NProgress;
window.store = store;
window.Lockr = Lockr;
Vue.config.productionTip = false;
Vue.use(Vuex);



router.beforeEach((to, from, next) => {
  NProgress.start();
  next()
});

router.afterEach(transition => {
  NProgress.done();
});

new Vue({
  el: '#app',
  router,
  store,
  i18n,
  components: {App},
  template: '<App/>'
});
