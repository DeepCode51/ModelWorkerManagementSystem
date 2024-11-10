import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import discusspeixunxinxi from '@/views/modules/discusspeixunxinxi/list'
    import jiangchengxinxi from '@/views/modules/jiangchengxinxi/list'
    import gerendangan from '@/views/modules/gerendangan/list'
    import jiaoshi from '@/views/modules/jiaoshi/list'
    import peixunbaoming from '@/views/modules/peixunbaoming/list'
    import storeup from '@/views/modules/storeup/list'
    import kechengxinxi from '@/views/modules/kechengxinxi/list'
    import forum from '@/views/modules/forum/list'
    import peixunxinxi from '@/views/modules/peixunxinxi/list'
    import chat from '@/views/modules/chat/list'
    import danganbiandong from '@/views/modules/danganbiandong/list'
    import config from '@/views/modules/config/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
          ,{
	path: '/news',
        name: '系统公告',
        component: news
      }
          ,{
	path: '/discusspeixunxinxi',
        name: '培训信息评论',
        component: discusspeixunxinxi
      }
          ,{
	path: '/jiangchengxinxi',
        name: '奖惩信息',
        component: jiangchengxinxi
      }
          ,{
	path: '/gerendangan',
        name: '个人档案',
        component: gerendangan
      }
          ,{
	path: '/jiaoshi',
        name: '劳模',
        component: jiaoshi
      }
          ,{
	path: '/peixunbaoming',
        name: '培训报名',
        component: peixunbaoming
      }
          ,{
	path: '/storeup',
        name: '我的收藏管理',
        component: storeup
      }
          ,{
	path: '/kechengxinxi',
        name: '课程信息',
        component: kechengxinxi
      }
          ,{
	path: '/forum',
        name: '论坛管理',
        component: forum
      }
          ,{
	path: '/peixunxinxi',
        name: '培训信息',
        component: peixunxinxi
      }
          ,{
	path: '/chat',
        name: '客服管理',
        component: chat
      }
          ,{
	path: '/danganbiandong',
        name: '档案变动',
        component: danganbiandong
      }
          ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
        ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
