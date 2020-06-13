// pages/login/login.js
import {userUrl} from '../../config'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    username: '',
    password: ''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },
  changeUsername: function(e){
    this.setData({
      username: e.detail.value
    })
  },
  changePassword: function(e){
    this.setData({
      password: e.detail.value
    })
  },
  bindSubmit: function(res){
    wx.showLoading({
      title: '登录中',
      mask: true
    })
    let that = this
    wx.request({
      url: userUrl + 'login',
      data: {
        username: that.data.username,
        password: that.data.password
      },
      success: function(res){
        if(res.data.code == 200){
          wx.setStorageSync('username', that.data.username)
          wx.setStorageSync('password', that.data.password)
          wx.setStorageSync('token', res.data.token)
          wx.setStorageSync('userinfo', res.data.user)
          let pages = getCurrentPages()
          let prePage = pages[pages.length - 2]
          prePage.cha
          wx.switchTab({
            url: '/pages/self/self'
          })
          
        }else{
          wx.showModal({
            title: '提示',
            content: '用户名或密码错误，请重试',
            showCancel: false,
            confirmText: "确定",
            success: function (res) {
              wx.hideLoading({
                complete: (res) => {},
              })
            }
          })
        }
      }
    })
    
  }
})