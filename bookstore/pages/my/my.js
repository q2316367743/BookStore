// pages/my/my.js
const app = getApp()
import {userUrl} from '../../config'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    avatarUrl: '',
    userinfo: {},
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
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
  },
  refresh: function(){
    this.openAlert("头像暂不支持修改") 
    this.setData({
      avatarUrl: app.globalData.userInfo.avatarUrl
    })
  },
  changeUsername: function(){
    this.openAlert("用户名不支持修改") 
  },
  changeBalance: function(){
    this.openAlert("余额不支持修改") 
  },
  openAlert: function (e) { 
    wx.showToast({ 
      title: e, 
      icon: "none", 
      duration: 2000 
    }) 
  },
  layout: function(){
    wx.removeStorageSync('username')
    wx.removeStorageSync('password')
    wx.removeStorageSync('token')
    wx.removeStorageSync('userinfo')
    wx.switchTab({
      url: '/pages/self/self',
    })
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

  }
})