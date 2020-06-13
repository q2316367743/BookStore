// pages/list/list.js
import {commodityUrl} from '../../config'
import {comImgUrl} from '../../config'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    items: {},
    comImgUrl: ''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var self=this
    this.setData({
      comImgUrl: comImgUrl
    })
    wx.request({
      url: commodityUrl + 'orderByNumber',
      data: {
        page: 1,
        limit: 9
      },
      success: function(res){
        if(res.data.code == 0){
          self.setData({
            items: res.data.data
          })
        }else{
          wx.showModal({
            title: '提示',
            content: res.data.msg,
            showCancel: false,
            confirmText: "确定",
            success: function (res) {
              wx.navigateTo({
                url: '/pages/index/index',
              })
            }
          })
        }
      }
    })
  },

})