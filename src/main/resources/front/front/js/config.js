
var projectName = '劳模管理系统';
/**
 * 轮播图配置
 */
var swiper = {
	// 设定轮播容器宽度，支持像素和百分比
	width: '100%',
	height: '400px',
	// hover（悬停显示）
	// always（始终显示）
	// none（始终不显示）
	arrow: 'none',
	// default（左右切换）
	// updown（上下切换）
	// fade（渐隐渐显切换）
	anim: 'default',
	// 自动切换的时间间隔
	// 默认3000
	interval: 2000,
	// 指示器位置
	// inside（容器内部）
	// outside（容器外部）
	// none（不显示）
	indicator: 'outside'
}

/**
 * 个人中心菜单
 */
var centerMenu = [{
	name: '个人中心',
	url: '../' + localStorage.getItem('userTable') + '/center.html'
}, 
{
	name: '我的发布',
	url: '../forum/list-my.html'
},

{
	name: '我的收藏',
	url: '../storeup/list.html'
}
]


var indexNav = [

{
	name: '培训信息',
	url: './pages/peixunxinxi/list.html'
}, 

{
	name: '论坛信息',
	url: './pages/forum/list.html'
}, 
{
	name: '系统公告',
	url: './pages/news/list.html'
},
]

var adminurl =  "http://localhost:8080/springbootpc161/admin/dist/index.html";

var cartFlag = false

var chatFlag = false


chatFlag = true


var menu = [{"backMenu":[{"child":[{"buttons":["新增","查看","修改","删除","添加奖惩","添加课程","添加档案"],"menu":"劳模","menuJump":"列表","tableName":"jiaoshi"}],"menu":"劳模管理"},{"child":[{"buttons":["查看","审核","打印","导出","修改","删除"],"menu":"个人档案","menuJump":"列表","tableName":"gerendangan"}],"menu":"个人档案管理"},{"child":[{"buttons":["查看","审核","修改","删除"],"menu":"档案变动","menuJump":"列表","tableName":"danganbiandong"}],"menu":"档案变动管理"},{"child":[{"buttons":["查看","修改","删除"],"menu":"奖惩信息","menuJump":"列表","tableName":"jiangchengxinxi"}],"menu":"奖惩信息管理"},{"child":[{"buttons":["查看","修改","删除","新增","查看评论"],"menu":"培训信息","menuJump":"列表","tableName":"peixunxinxi"}],"menu":"培训信息管理"},{"child":[{"buttons":["查看","修改","删除","审核"],"menu":"培训报名","menuJump":"列表","tableName":"peixunbaoming"}],"menu":"培训报名管理"},{"child":[{"buttons":["查看","修改","删除"],"menu":"课程信息","menuJump":"列表","tableName":"kechengxinxi"}],"menu":"课程信息管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"论坛管理","tableName":"forum"}],"menu":"论坛管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"系统公告","tableName":"news"},{"buttons":["新增","查看","修改","删除"],"menu":"客服管理","tableName":"chat"},{"buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"buttons":["查看","报名"],"menu":"培训信息列表","menuJump":"列表","tableName":"peixunxinxi"}],"menu":"培训信息模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"buttons":["查看","变动申请","新增"],"menu":"个人档案","menuJump":"列表","tableName":"gerendangan"}],"menu":"个人档案管理"},{"child":[{"buttons":["查看","修改","删除"],"menu":"档案变动","menuJump":"列表","tableName":"danganbiandong"}],"menu":"档案变动管理"},{"child":[{"buttons":["查看"],"menu":"奖惩信息","menuJump":"列表","tableName":"jiangchengxinxi"}],"menu":"奖惩信息管理"},{"child":[{"buttons":["查看","修改","删除"],"menu":"培训报名","menuJump":"列表","tableName":"peixunbaoming"}],"menu":"培训报名管理"},{"child":[{"buttons":["查看"],"menu":"课程信息","menuJump":"列表","tableName":"kechengxinxi"}],"menu":"课程信息管理"},{"child":[{"buttons":["查看","删除"],"menu":"我的收藏管理","tableName":"storeup"}],"menu":"我的收藏管理"}],"frontMenu":[{"child":[{"buttons":["查看","报名"],"menu":"培训信息列表","menuJump":"列表","tableName":"peixunxinxi"}],"menu":"培训信息模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"劳模","tableName":"jiaoshi"}]


var isAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].backMenu.length;j++){
                for(let k=0;k<menus[i].backMenu[j].child.length;k++){
                    if(tableName==menus[i].backMenu[j].child[k].tableName){
                        let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}

var isFrontAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].frontMenu.length;j++){
                for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
                    if(tableName==menus[i].frontMenu[j].child[k].tableName){
                        let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}
