// pages/self/self.js
//获取应用实例
const app = getApp()
import {userUrl} from '../../config'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    avatarUrl: '',
    userinfo: {},
    num: 1
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.data.num = 2;
    if (app.globalData.userInfo) {
      this.setData({
        avatarUrl: app.globalData.userInfo.avatarUrl
      })
    }else{
      this.setData({
        avatarUrl: '/images/default_head_circle.png'
      })
    }
    let that = this
    var token = wx.getStorageSync('token');
    if(token != null && token != ''){
      wx.request({
        url: userUrl + 'info',
        data: {
          token: token
        },
        success: function(res){
          var result = res.data
          if(result.code == 200){
            that.setData({
              userinfo: result.user
            })
          }else if(result.code == 400){
            var password = wx.getStorageSync('password')
            var username = wx.getStorageSync('username')
            if(username && password){
              wx.request({
                url: userUrl + 'login',
                data: {
                  username: username,
                  password: password
                },
                success: function(res){
                  if(res.data.code == 200){
                    wx.setStorageSync('token', res.data.token)
                    wx.setStorageSync('userinfo', res.data.user)
                    that.setData({
                      userinfo: res.data.userinfo
                    })
                  }else{
                    wx.showModal({
                      title: '提示',
                      content: '用户名或密码错误，请重新登录',
                      showCancel: false,
                      confirmText: "确定",
                      success: function (res) {
                        wx.navigateTo({
                          url: '/pages/login/login',
                        })
                      }
                    })
                  }
                }
              })
            }else{
              wx.showModal({
                title: '提示',
                content: '请先登录',
                showCancel: false,
                confirmText: "确定",
                success: function (res) {
                  wx.navigateTo({
                    url: '/pages/login/login',
                  })
                }
              })
            }
          }
        }
      })
    }else{
      wx.showModal({
        title: '提示',
        content: '请先登录',
        showCancel: false,
        confirmText: "确定",
        success: function (res) {
          wx.navigateTo({
            url: '/pages/login/login',
          })
        }
      })
    }
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    if(this.data.num == 2){
      this.data.num = 3
    }
    if(this.data.num < 5){
      if (app.globalData.userInfo) {
        this.setData({
          avatarUrl: app.globalData.userInfo.avatarUrl
        })
      }else{
        this.setData({
          avatarUrl: '/images/default_head_circle.png'
        })
      }
      this.setData({
        userinfo: wx.getStorageSync('userinfo')
      })
      this.data.num += 1;
    }
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  shop: function(){
    wx.navigateTo({
      url: '../shop/shop',
    })
  },
  record: function(){
    wx.navigateTo({
      url: '../record/record',
    })
  }
})