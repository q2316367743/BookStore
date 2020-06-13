// pages/record/record.js
import {userUrl} from '../../config'
import {comImgUrl} from '../../config'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    items: {},
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
      url: userUrl + 'record',
      data: {
        token: wx.getStorageSync('token'),
        page: 1,
        limit: 9
      },
      success: function(res){
        if(res.data.code == 200){
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