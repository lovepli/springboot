
/**
 1. 模板字符串 : 简化字符串的拼接
 * 模板字符串必须用 `` 包含
 * 变化的部分使用${xxx}定义
 *
 * 优点：
 * 1.去掉了 频繁的 + 号  和 ‘’引号
 * 2. 只需要一对 ``  就能搞定
*/

  let p = {  name:'kobe',age:18 }

  console.log('我的名字是:'+ p.name + '我的年龄是：'+ p.age)
  
  console.log(`我的名字是：${p.name},我的年龄是：${p.age}`)

