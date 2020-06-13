// pages/info/info.js
import {commodityUrl} from '../../config'
import {comImgUrl} from '../../config'
import {shopUrl} from '../../config'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    id: -1,
    comImgUrl: '',
    name: '',
    imageName: '000001',
    author: '',
    number: -1,
    view: -1,
    content: '',
    price: -1,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      comImgUrl: comImgUrl
    })
    this.setData({
      id: options.id
    })
    let that = this
    wx.request({
      url: commodityUrl+'info',
      data: {
        commodityId: options.id
      }, 
      success: function(res){
        var commodity = res.data.data
        wx.setNavigationBarTitle({
          title: commodity.name,
        })
        that.setData({
          name: commodity.name,
          imageName: commodity.imageName == '' ? '000001' : commodity.imageName,
          author: commodity.author,
          price: commodity.price,
          number: commodity.number,
          view: commodity.view,
          content: commodity.content
        })
      }
    })
   
  },

  /**
   * 加入购物车
   * 
  */
  addShop: function(){
    let that = this
    wx.showLoading({
      title: '加入中',
      mask: true
    })
    wx.request({
      url: shopUrl + 'add',
      data: {
        token: wx.getStorageSync('token'),
        commodityId: that.data.id
      },
      success: function(res){
        var result = res.data
        wx.hideLoading({
          complete: (res) => {
            wx.showToast({
              title: '加入成功',
              icon: 'success',
              duration: 2000
            })
          },
        })
      }
    })
  },

  /**
   * 购买
   * 
  */
  buy: function(){

  }

})