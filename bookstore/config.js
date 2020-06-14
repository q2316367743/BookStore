/**
 * 配置文件
 * 
*/
//var apiUrl = 'http://127.0.0.1:8055'
var apiUrl = 'http://192.168.0.105:8055'
var imageUrl = 'http://192.168.0.105/image/bookstore'

var config = {
  commodityUrl: `${apiUrl}/commodity/`,
  comImgUrl: `${imageUrl}/commodity/`,
  userUrl: `${apiUrl}/user/`,
  shopUrl: `${apiUrl}/shop/`,
  searchUrl: `${apiUrl}/search/`,
  resourceUrl: `${apiUrl}/resource/`,
  globalUrl: `${apiUrl}/global/`
}

module.exports = config