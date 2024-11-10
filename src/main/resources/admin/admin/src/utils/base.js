const base = {
  get() {
    return {
      url: 'http://localhost:8080/springbootpc161/',
      name: 'springbootpc161',
      // 退出到首页链接
      indexUrl: 'http://localhost:8080/springbootpc161/front/index.html',
    }
  },
  getProjectName() {
    return {
      projectName: '劳模管理系统',
    }
  },
}
export default base
